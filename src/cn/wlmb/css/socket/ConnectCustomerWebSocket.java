package cn.wlmb.css.socket;

import java.io.IOException;
import java.util.ArrayList;
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
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import cn.wlmb.css.po.Chat;
import cn.wlmb.css.po.ChatExample;
import cn.wlmb.css.po.Customer;
import cn.wlmb.css.po.CustomerExample;
import cn.wlmb.css.po.Msg;
import cn.wlmb.css.po.Server;
import cn.wlmb.css.po.ServerExample;
import cn.wlmb.css.po.Serverans;
import cn.wlmb.css.po.ServeransExample;
import cn.wlmb.css.po.Systemans;
import cn.wlmb.css.po.SystemansExample;
import cn.wlmb.css.service.ChatService;
import cn.wlmb.css.service.CustomerService;
import cn.wlmb.css.service.MsgService;
import cn.wlmb.css.service.NumService;
import cn.wlmb.css.service.ServerService;
import cn.wlmb.css.service.ServeranService;
import cn.wlmb.css.service.SystemanService;
import cn.wlmb.css.util.AppUtil;
import cn.wlmb.css.util.JsonDateValueProcessor;
import cn.wlmb.css.util.Robot;
import cn.wlmb.css.util.UniqueIdUtil;

//用来和用户交换信息的socket
/**
 * 这个类是客户打开了使用了本客服系统的网站时与服务器建立连接的类 只用来传递信息
 * 
 * @author ChengFan
 * 
 */
@ServerEndpoint("/connectwebsocket")
public class ConnectCustomerWebSocket {

	private Session custumerSession;
	private ServeranService serveranService = (ServeranService) AppUtil
			.getBean("serveranService");
	private SystemanService systemanService = (SystemanService) AppUtil
			.getBean("systemanService");

	// 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
	private static int onlineCustomerCount = 0;

	private static String customerID = null;
	private static String serverId = null;
	private String chatID = null;
	private Customer customer = null;

	private boolean flag = false;// 用来标记是否是和机器人通话

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

	// 用户和后台连接成功之后
	@OnOpen
	public void onOpen(Session session) {

		jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor());
		this.custumerSession = session;

		/** 1.把客服列表发送给用户，如果所有客服都不在线 ，则发一个离线客服 */
		ServerExample example = new ServerExample();
		example.createCriteria().andStateEqualTo(1);
		List<Server> list = serverService.findServerList(example);
		JSONArray subMsgs = JSONArray.fromObject(list, jsonConfig);
		try {
			// 将在线客服的信息转化为json并添加一个头发送个客户端
			session.getBasicRemote().sendText(
					"onlineServer###" + subMsgs.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		/** 3.在线用户数量+1 */
		addOnlineCount(); // 在线数加1
		System.out.println("有用户连接了！当前连接人数为" + getOnlineCount());

	}

	// 当用户退出的时候
	@OnClose
	public void onClose() {
		// 1.在线数量-1
		subOnlineCount();
		// 将状态设置为离线
		System.out.println("-------离线---------");
		customer.setState(0);
		customerService.updateStatusById(customer);
		/** 动态的更新客服界面的在线客户数据 */
		// 获得一个CustomerExample（用来写自定义查询的，这里需要查询所有在线的客户）

		updateCustomer();
	}

	// 当用户传来数据的时候
	@OnMessage
	public void onMessage(String message, Session session) {
		// 处理message 得到用户需求
		System.out.println("from customer " + message);

		// 判断用户的需求,根据需求提供不同的数据
		if (message.indexOf("iamcid") != -1) {
			// 用户发来的信息是自己的id
			cusLogin(message);
		} else if (message.indexOf("chattosid") != -1) {
			// 客户要和某个客服通话
			chatToServer(message);
		} else if (message.indexOf("chatToRobot") != -1) {
			// 和机器人通话
			this.flag = true;
			chatToRobot();
		} else if (message.indexOf("chatover") != -1) {
			// 会话结束
			ConnectCustomerWebSocket.serverId = null;
			saveMask(message);
			this.flag = false;
		} else if (flag) {
			// 将发来的消息产地给机器人 并将机器人说的话返回给客户
			chatWithAdobo(message);
		} else {
			// 接收到的信息为普通的消息
			sendMsgToServer(message);
			chatIfHasEasyAnswer(message);
		}

	}

	private void chatIfHasEasyAnswer(String message) {
		ServeransExample example = new ServeransExample();
		//查出所有的关键词
		List<String> msg = new ArrayList<>();
		List<Serverans> list = serveranService.findMsgByExample(example);
		for(int i = 0; i < list.size(); i++)  {
			if(message.indexOf(list.get(i).getWord()) != -1){
				//数据库中有这个关键词
				String content = list.get(i).getContent();
				msg.add(content);
			}
		}
		try {
			JSONArray numMsgs = JSONArray.fromObject(msg, jsonConfig);
			WebSocketTools.getConnectServerMap().get(serverId)
			.sendMessage("serveran###" + numMsgs.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		SystemansExample example2 = new SystemansExample();
		List<Systemans> list2 = systemanService.findMsgByExample(example2);
		
		List<String> msg2 = new ArrayList<>();
		for(int i = 0; i < list2.size(); i++)  {
			if(message.indexOf(list2.get(i).getSyword()) != -1){
				String content = list2.get(i).getSycontent();
				msg2.add(content);
			}
		}
		try {
			JSONArray numMsgs = JSONArray.fromObject(msg2, jsonConfig);
			System.out.println(numMsgs+"ooooooooooooooo");
			WebSocketTools.getConnectServerMap().get(serverId)
			.sendMessage("systeman###" + numMsgs.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void chatToRobot() {
		// 创建一个和robot聊天的会话 serverid设置为0
		chatID = UniqueIdUtil.getGuidNoDash();
		Chat chat = new Chat();
		chat.setChatid(chatID);
		chat.setCreatetime(new Date());
		chat.setCustomerid(customerID);

		chatService.insertChat(chat);

	}

	private void saveMask(String message) {
		// 保存评价的分数
		if (!flag) {
			// 获取给该客服打分的人数 及平均分
			// 获取当前用户所打的分数
			double mask = Double.parseDouble(message.split("##")[1]);
			System.out.println("mask=========" + mask);
			// 求平均值并重新写入到数据库中
		}
		// 与机器人聊天

		// 设置会话结束时间
		Chat chat = chatService.findChatById(chatID);
		chat.setOvertime(new Date());
		chatService.updateChatById(chat);
	}

	@OnError
	public void onError(Session session, Throwable error) {
		// 提示用户发生错误
		// 尝试重新连接
		onClose();

	}

	private void chatWithAdobo(String message) {
		String answerJson = Robot.messageFromRobot(message);
		System.out.println(answerJson);
		JSONObject jsonObject = JSONObject.fromObject(answerJson);
		String msg = jsonObject.getString("text");
		try {
			this.sendMessage(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(String message) throws IOException {
		this.custumerSession.getBasicRemote().sendText(message);
		// this.session.getAsyncRemote().sendText(message);
	}

	public static synchronized int getOnlineCount() {
		return onlineCustomerCount;
	}

	public static synchronized void addOnlineCount() {
		ConnectCustomerWebSocket.onlineCustomerCount++;
	}

	public static synchronized void subOnlineCount() {
		ConnectCustomerWebSocket.onlineCustomerCount--;
	}

	public static void setCustomerID(String customerID) {
		ConnectCustomerWebSocket.customerID = customerID;
	}

	public static void setServerId(String serverId) {
		ConnectCustomerWebSocket.serverId = serverId;
	}

	public void cusLogin(String message) {
		/** 1.判断是否为新用户，如果是则将新用户信息添加到数据库中 */
		customerID = message.split("##")[1];
		customer = customerService.findCustomerById(customerID);
		if (customer == null) {
			// 证明是新用户 创建一个新用户 添加到数据库中
			customer = new Customer();

			customer.setCustomerid(customerID);
			customer.setIp("127.0.0.1");
			customer.setState(1);
			customer.setLocation("杭州");
			customer.setCuCreatime(new Date());
			customerService.insertCustomer(customer);

			/** 将该连接保存在map中 */

			WebSocketTools.setConnectCustomerMap(customerID, this);
		} else {
			// 证明这个人已经存在与数据库中了；
			System.out.println("you are exist");
			// 将他的状态设置为1（在线状态）

			customer.setState(1);
			customerService.updateStatusById(customer);
			System.out.println("--------上线-------");
			/** 将该连接保存在map中 */

			WebSocketTools.setConnectCustomerMap(customerID, this);

			// ConnectServerWebSocket.sendToAllServer();

		}
		updateCustomer();
	}

	public void sendMsgToServer(String message) {
		// 给客服发消息
		try {
			WebSocketTools.getConnectServerMap().get(serverId)
					.sendMessage(customerID + "###" + message);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 将数据保存在数据库中
		Msg msg = new Msg();
		msg.setChatid(chatID);
		msg.setContent(message);
		msg.setCreatetime(new Date());
		msg.setFromwho(0);
		msg.setStatue(1);// 默认未读
		msg.setCustomerid(customerID);
		msg.setServerid(serverId);
		msg.setId(UniqueIdUtil.getGuidNoDash());

		msgService.insertMsg(msg);
	}

	@SuppressWarnings("static-access")
	public void chatToServer(String msg) {
		// 发来的信息是客服的id
		serverId = msg.split("##")[1];
		// 判断是否存在已经包含了当前客服与客户之间的会话 并且该会话还没结束
		ChatExample example = new ChatExample();
		example.createCriteria().andCustomeridEqualTo(customerID)
				.andServeridEqualTo(serverId).andOvertimeIsNotNull();
		List<Chat> list = chatService.findChatByExample(example);
		if (list.isEmpty()) {
			// 新建一个对话（chat） 并将该chat保存在数据库中
			chatID = UniqueIdUtil.getGuidNoDash();
			Chat chat = new Chat();
			chat.setChatid(chatID);
			chat.setCreatetime(new Date());
			chat.setCustomerid(customerID);
			chat.setServerid(serverId);

			chatService.insertChat(chat);
		} else {
			// 已经存在该会话
			chatID = list.get(0).getChatid();
		}
		// 将该客服中的customerID设置为该用户的id
		WebSocketTools.getConnectServerMap().get(serverId)
				.setCuotomerID(customerID);
		// 设置客户的serverid 表明该客户已经开始通话
		// customer = customerService.findCustomerById(customerID);
		customer.setCustomerid(customerID);
		customer.setServerid(serverId);
		customerService.updateStatusById(customer);
	}

	public void updateCustomer() {
		/** 动态的更新客服界面的在线客户数据 */
		// 获得一个CustomerExample（用来写自定义查询的，这里需要查询所有在线的客户）
		CustomerExample example = new CustomerExample();
		// 这里自定义了一个查询语句
		// andStateEqualTo 相当于and state=1；就是查询当前在线的客户
		example.createCriteria().andStateEqualTo(1);
		// 将自定义语句example传递到findCustomerList中
		// 得到查询结果是一个list
		List<Customer> list = customerService.findCustomerList(example);

		/** 整理为json */
		JSONArray subMsgs = JSONArray.fromObject(list, jsonConfig);

		Map<String, ConnectServerWebSocket> map = WebSocketTools
				.getConnectServerMap();

		for (Entry<String, ConnectServerWebSocket> entry : map.entrySet()) {

			System.out.println("Key = " + entry.getKey() + ", Value = "
					+ entry.getValue());
			/** 发送给客服 */
			try {
				entry.getValue().sendMessage(
						"onlineCustomer###" + subMsgs.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
