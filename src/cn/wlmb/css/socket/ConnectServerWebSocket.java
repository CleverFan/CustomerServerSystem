package cn.wlmb.css.socket;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import cn.wlmb.css.po.Chat;
import cn.wlmb.css.po.ChatExample;
import cn.wlmb.css.po.Currentstate;
import cn.wlmb.css.po.CurrentstateExample;
import cn.wlmb.css.po.Customer;
import cn.wlmb.css.po.CustomerExample;
import cn.wlmb.css.po.Leavemessage;
import cn.wlmb.css.po.LeavemessageExample;
import cn.wlmb.css.po.Leavemsgdividebytime;
import cn.wlmb.css.po.LeavemsgdividebytimeExample;
import cn.wlmb.css.po.Msg;
import cn.wlmb.css.po.MsgExample;
import cn.wlmb.css.po.Num;
import cn.wlmb.css.po.NumExample;
import cn.wlmb.css.po.Server;
import cn.wlmb.css.po.ServerExample;
import cn.wlmb.css.po.Servermsg;
import cn.wlmb.css.po.ServermsgExample;
import cn.wlmb.css.service.ChatService;
import cn.wlmb.css.service.CurrentStateService;
import cn.wlmb.css.service.CustomerService;
import cn.wlmb.css.service.LeamdbtService;
import cn.wlmb.css.service.LeaveMessageService;
import cn.wlmb.css.service.MsgService;
import cn.wlmb.css.service.NumService;
import cn.wlmb.css.service.ServerService;
import cn.wlmb.css.service.ServermsgService;
import cn.wlmb.css.util.AppUtil;
import cn.wlmb.css.util.JsonDateValueProcessor;
import cn.wlmb.css.util.UniqueIdUtil;

/**
 * 当客服上线后，连接该类 用于客服端与后台之间的通信
 * 
 * @author ChengFan
 * 
 */
@ServerEndpoint("/connectserverwebsocket")
public class ConnectServerWebSocket implements WebSocketInterface {

	// 与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session serverSession;
	// 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
	private static int onlineCustomerCount = 0;

	private static String customerID;
	private static String serverID;
	private String chatID;
	private Server server;
	private JsonConfig jsonConfig;

	// 客服的service
	private ServerService serverService = (ServerService) AppUtil
			.getBean("serverService");
	// 客户的service
	private CustomerService customerService = (CustomerService) AppUtil
			.getBean("customerService");
	// chat的service
	private ChatService chatService = (ChatService) AppUtil
			.getBean("chatService");
	// msg的service
	private MsgService msgService = (MsgService) AppUtil.getBean("msgService");

	// 留言的service
	private LeaveMessageService leavemessageService = (LeaveMessageService) AppUtil
			.getBean("leavemessageService");

	// num的service
	private NumService numService = (NumService) AppUtil.getBean("numService");

	// servermsg的service
	private ServermsgService servermsgService = (ServermsgService) AppUtil
			.getBean("servermsgService");

	// servermsg的service
	private LeamdbtService leamdbtService = (LeamdbtService) AppUtil
			.getBean("leamdbtService");
	
	private CurrentStateService currentStateService = (CurrentStateService) AppUtil
			.getBean("currentStateService");

	// 用户和后台连接成功之后
	@OnOpen
	public void onOpen(Session session) {
		this.serverSession = session;
		jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor());
		// 2.发送在线的客户列表给客服
		/** 获取在线客户列表 */

		// 获得一个CustomerExample（用来写自定义查询的，这里需要查询所有在线的客户）
		CustomerExample example = new CustomerExample();
		// 这里自定义了一个查询语句
		// andStateEqualTo 相当于and state=1；就是查询当前在线的客户
		example.createCriteria().andStateEqualTo(1);
		// 将自定义语句example传递到findCustomerList中
		// 得到查询结果是一个list
		List<Customer> cusList = customerService.findCustomerList(example);

		/** 整理为json */
		JSONArray onlineCus = JSONArray.fromObject(cusList, jsonConfig);

		/** 发送给客服 */
		try {
			session.getBasicRemote().sendText(
					"onlineCustomer###" + onlineCus.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 3.在线客服数量+1

		addOnlineCount(); // 在线数加1
		System.out.println("有客服连接了！当前连接人数为" + getOnlineCount());

		ServerExample example1 = new ServerExample();
		example.createCriteria().andStateEqualTo(1);
		List<Server> list = serverService.findServerList(example1);
		JSONArray subMsgs = JSONArray.fromObject(list, jsonConfig);

		try {
			session.getBasicRemote().sendText(
					"onlineServer###" + subMsgs.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(subMsgs);
	}

	// 当用户退出的时候
	@OnClose
	public void onClose() {
		System.out.println("close");
		// 在线客服数量-1
		subOnlineCount();
		// 将客服状态改为离线
		server.setState(0);
		serverService.updateServerById(server);
		updateServer();
	}

	// 当用户传来数据的时候
	@OnMessage
	public void onMessage(String message, Session session) {
		// 不同的消息处理不同的事件
		System.out.println("from server " + message);

		if (message.indexOf("iamsid") != -1) {
			// 用户发来的信息是自己的id
			setLogin(message);
		} else if (message.indexOf("chattosid") != -1) {
			chatToCustomer(message);
		} else if (message.indexOf("left_hischat") != -1) {
			// 历史会话列表
			getHisChat();
		} else if (message.indexOf("gethischat") != -1) {
			// 历史会话内容
			sendHisMsg(message);
		} else if (message.indexOf("left_leavemessage") != -1) {
			// 留言列表
			getLeaveMessage();
		} else if (message.indexOf("getleamsg") != -1) {
			// 留言信息
			sendLeaveMessage(message);
		} else if (message.indexOf("adminMsg") != -1) {
			// 后台信息
			System.out.println(111);
			sendAdminMessage();
		} else if(message.indexOf("fileeeeee") != -1){
			//发给客户的是文件（图片）
			sendPhotoToCus(message);
		}else if(message.indexOf("serveran") != -1){
			//有智能回复
			System.out.println("2222222222222222222");
			addCleverAnswer(message);
		}else {
			// 就是客服发来的普通聊天信息
			sendToCustomer(message);
			System.out.println(message);
		}
	}

	private void addCleverAnswer(String message) {
		try {
			serverSession.getBasicRemote().sendText(
					"cleverAnswer###" + message);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void sendPhotoToCus(String message) {
		String fileName = message.split("fileeeeee")[0];
		byte[] msg = null;
		try {
			msg = message.split("fileeeeee")[1].getBytes("UTF8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		WebSocketTools.saveFileFromBytes(msg, "/CustomerServerSystem/resources/reveiveImg/");
        System.out.println("收到2进制流");
		
	}

	private void sendAdminMessage() {
		// 正在咨询人数 //当前等待人数 //在线客服人数 //总会话数 //平均满意度
		CurrentstateExample example = new CurrentstateExample();
		List<Currentstate> numList = currentStateService.findCurrentstateByExample(example);
		
		JSONArray numMsgs = JSONArray.fromObject(numList, jsonConfig);
		// {"chatnumber":23,"customernumber":3,"onlinecustomer":0,"onlineserver":1,"servernumber":5}

		try {
			serverSession.getBasicRemote().sendText(
					"numMsgs###" + numMsgs.toString());  
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("11111"+numMsgs);

		// /*每个客服的消息数量（客户加客服）*/ /*每个客服自己发出的的消息数量*/
//		ServermsgExample example2 = new ServermsgExample();
//		List<Servermsg> servermsgNum = servermsgService
//				.findServermsgByExample(example2);
//
//		JSONArray servermsgMsgs = JSONArray
//				.fromObject(servermsgNum, jsonConfig);
//		// {"msgnum":2,"serverid":"00HxVzYlw3OXQqsBAAwBtN3gPRg90J3UwvmXzyV4tgi5vdpXGCA5VqcrGF4xkihG","servermsgnum":1}
//
//		try {
//			serverSession.getBasicRemote().sendText(
//					"servermsgMsgs###" + servermsgMsgs.toString());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		/*留言信息统计*/
//		
//		LeavemsgdividebytimeExample example3 = new LeavemsgdividebytimeExample();
//		List<Leavemsgdividebytime> lmdbtMsg = leamdbtService.findLeadbt(example3);
//		JSONArray lmdbtMsgs = JSONArray
//				.fromObject(lmdbtMsg, jsonConfig);
//		System.out.println(lmdbtMsgs);
		

	}

	private void sendLeaveMessage(String message) {
		chatID = message.split("##")[1];
		MsgExample example2 = new MsgExample();
		// 查找该chatid今天的消息
		example2.createCriteria().andChatidEqualTo(chatID).andStatueEqualTo(2);
		List<Msg> hisChatList = msgService.findMsgByExample(example2);
		// JSONArray subMsgs = JSONArray.fromObject(list2);
		// System.out.println(subMsgs);
		// JSONObject subMsgs = new JSONObject();
		// subMsgs.fromObject(list2, jsonConfig);
		JSONArray subMsgs = JSONArray.fromObject(hisChatList, jsonConfig);
		System.out.println(subMsgs);
		/** 发送给客户 */
		try {
			serverSession.getBasicRemote().sendText(
					"leavemsg###" + subMsgs.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void getLeaveMessage() {
		LeavemessageExample example2 = new LeavemessageExample();
		// 查找statue位2的消息
		example2.createCriteria().andServeridEqualTo(serverID);
		List<Leavemessage> leaveMessage = leavemessageService
				.findLeaveMsgList(example2);
		JSONArray subMsgs = JSONArray.fromObject(leaveMessage, jsonConfig);
		System.out.println("---------leaveMessage--------------" + subMsgs);

		/** 发送给客户 */
		try {
			serverSession.getBasicRemote().sendText(
					"leaveMessage###" + subMsgs.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sendHisMsg(String message) {
		chatID = message.split("##")[1];
		MsgExample example2 = new MsgExample();
		// 查找该chatid今天的消息
		example2.createCriteria().andChatidEqualTo(chatID);
		List<Msg> hisChatList = msgService.findMsgByExample(example2);
		// JSONArray subMsgs = JSONArray.fromObject(list2);
		// System.out.println(subMsgs);
		// JSONObject subMsgs = new JSONObject();
		// subMsgs.fromObject(list2, jsonConfig);
		JSONArray subMsgs = JSONArray.fromObject(hisChatList, jsonConfig);
		System.out.println(subMsgs);
		/** 发送给客户 */
		try {
			serverSession.getBasicRemote().sendText(
					"chathismsg###" + subMsgs.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getHisChat() {
		/** 获取历史会话 */
		ChatExample ceExample = new ChatExample();
		ceExample.createCriteria().andServeridEqualTo(serverID);
		List<Chat> chatList = chatService.findChatByExample(ceExample);
		JSONArray hisChat = JSONArray.fromObject(chatList, jsonConfig);
		System.out.println("-----his-----" + hisChat);
		try {
			serverSession.getBasicRemote().sendText(
					"hisChat###" + hisChat.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@OnError
	public void onError(Session session, Throwable error) {
		onClose();
	}

	public void sendToCustomer(String message) {
		// 将这个信息发送给相应的客户
		try {
			WebSocketTools.getConnectCustomerMap().get(customerID)
					.sendMessage(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 将消息保存在数据库中
		Msg msg = new Msg();
		msg.setChatid(chatID);
		msg.setContent(message);
		msg.setCreatetime(new Date());
		msg.setFromwho(1);
		msg.setStatue(1);// 默认未读
		msg.setCustomerid(customerID);
		msg.setServerid(serverID);
		msg.setId(UniqueIdUtil.getGuidNoDash());

		msgService.insertMsg(msg);
	}

	@SuppressWarnings("static-access")
	public void chatToCustomer(String message) {
		customerID = message.split("##")[1];
		// 判断是否存在已经包含了当前客服与客户之间的会话 并且该会话还没有结束
		ChatExample example = new ChatExample();
		example.createCriteria().andCustomeridEqualTo(customerID)
				.andServeridEqualTo(serverID).andOvertimeIsNotNull();
		List<Chat> list = chatService.findChatByExample(example);
		if (list.isEmpty()) {
			// 新建一个对话（chat） 并将该chat保存在数据库中
			chatID = UniqueIdUtil.getGuidNoDash();
			Chat chat = new Chat();
			chat.setChatid(chatID);
			chat.setCreatetime(new Date());
			chat.setCustomerid(customerID);
			chat.setServerid(serverID);

			chatService.insertChat(chat);
		} else {
			// 已经存在该会话
			chatID = list.get(0).getChatid();
			// 将旧的聊天信息显示在界面上
			MsgExample example2 = new MsgExample();
			// 查找该chatid今天的消息
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -1);
			// 昨天的时间
			Date yesterday = cal.getTime();
			example2.createCriteria().andChatidEqualTo(chatID)
					.andCreatetimeGreaterThan(yesterday);
			List<Msg> list2 = msgService.findMsgByExample(example2);
			// JSONArray subMsgs = JSONArray.fromObject(list2);
			// System.out.println(subMsgs);
			// JSONObject subMsgs = new JSONObject();
			// subMsgs.fromObject(list2, jsonConfig);
			JSONArray subMsgs = JSONArray.fromObject(list2, jsonConfig);
			System.out.println(subMsgs);
			/** 发送给客服 */
			try {
				serverSession.getBasicRemote().sendText(
						"msgRecord###" + subMsgs.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 将该客户的serverID设置为本客服id
		WebSocketTools.getConnectCustomerMap().get(customerID) 
				.setServerId(serverID);
	}

	public void setLogin(String message) {
		/** 1.判断是否为新用户，如果是则将新用户信息添加到数据库中 */
		serverID = message.split("##")[1];
		server = serverService.findServerById(serverID);
		if (server == null) {
			// 证明是新用户 创建一个新客服 添加到数据库中
			server = new Server();
			// 给改用户创建一个新的id 和一个新的socketid

			server.setHeadimg("/lujin");
			server.setName("server");
			server.setServerid(serverID);
			server.setState(1);
			server.setSerCreatime(new Date());

			serverService.insertServer(server);
			/** 将该连接保存在map中 */

			WebSocketTools.setConnectServerMap(serverID, this);
		} else {
			// 证明这个人已经存在与数据库中了；
			System.out.println("you are exist");
			// 将状态设置为在线
			server.setState(1);
			serverService.updateServerById(server);
			/** 将该连接保存在map中 */
			WebSocketTools.setConnectServerMap(serverID, this);
		}
		updateServer();
	}

	public void updateServer() {
		/** 动态的更新客户界面的在线客服数据 */
		/** 获取在线客服列表 */

		ServerExample example = new ServerExample();
		example.createCriteria().andStateEqualTo(1);
		List<Server> list = serverService.findServerList(example);
		JSONArray subMsgs = JSONArray.fromObject(list);

		/** 发送给用户 */

		Map<String, ConnectCustomerWebSocket> map = WebSocketTools
				.getConnectCustomerMap();

		for (Entry<String, ConnectCustomerWebSocket> entry : map.entrySet()) {

			System.out.println("Key = " + entry.getKey() + ", Value = "
					+ entry.getValue());
			if(entry.getValue() == null) break;
			/** 发送给客户 */
			try {
				entry.getValue().sendMessage(
						"onlineServer###" + subMsgs.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		
		Map<String, ConnectServerWebSocket> smap = WebSocketTools
				.getConnectServerMap();

		for (Entry<String, ConnectServerWebSocket> entry : smap.entrySet()) {

			System.out.println("Key = " + entry.getKey() + ", Value = "
					+ entry.getValue());
			/** 发送给客服 */
			if(entry.getValue() == null) break;
			try {
				entry.getValue().sendMessage(
						"onlineServer###" + subMsgs.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public static synchronized int getOnlineCount() {
		return onlineCustomerCount;
	}

	public static synchronized void addOnlineCount() {
		ConnectServerWebSocket.onlineCustomerCount++;
	}

	public static synchronized void subOnlineCount() {
		ConnectServerWebSocket.onlineCustomerCount--;
	}

	public void sendMessage(String message) throws IOException {
		this.serverSession.getBasicRemote().sendText(message);
		// this.session.getAsyncRemote().sendText(message);
	}

	public static void setCuotomerID(String cuotomerID) {
		ConnectServerWebSocket.customerID = cuotomerID;
	}

	public static void setServerID(String serverID) {
		ConnectServerWebSocket.serverID = serverID;
	}
}
