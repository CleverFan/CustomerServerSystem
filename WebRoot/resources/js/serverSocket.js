window.onload = function() {

	// window_onload();
	// 客服一登陆到主界面 立刻与服务器建立一个用来传递数据的连接
	ws = new WebSocket(
			"ws://localhost:8080/CustomerServerSystem/connectserverwebsocket");

	var customer = null;// 用来保存客户的名字（id） 是一个数组
	var his_chat = new Array();// 用来保存chat的（id） 是一个数组
	var lea_chat = new Array();// 用来保存chat的（id） 是一个数组
	var serveridMsg = null;// 从json中解析出来的某一个用户的id
	var serverCreatimeDate = null;// 从json中解析出来的某一个用户的创建时间
	var customeridMsg = null;// 从json中解析出来的某一个用户的id
	var cuCreatimeDate = null;// 从json中解析出来的某一个用户的创建时间
	var index = null;// 上一个聊天的用户的编号
	var index_now = null;// 当前聊天的用户的编号
	var his_index = null;// 上一个聊天的用户的编号
	var his_index_now = null;// 当前聊天的用户的编号
	var lea_index = null;// 上一个留言的用户的编号
	var lea_index_now = null;// 当前留言的用户的编号
	var msgNum = new Array();// 用来保存某一个客户发来的 客服还没有看的消息的条数

	ws.onopen = function(e) {
		// 一建立连接 就将自己的用户名发送给服务器 如果还没有用户名 就随机生成一个
		if (localStorage.serverNum == null) {
			localStorage.serverNum = randomWord(false, 64, 64);

		}

		ws.send("iamsid##" + localStorage.serverNum);
		
	};
	$('.iWantMsg').click(function() {
		ws.send("adminMsg##");
	});

	ws.onmessage = function(e) {
		// 连接一建立 服务器会立即发送客户的信息给客服 在这里处理接收到的信息
		var str = e.data;
		// 处理客服请求服务器的信息 将服务器传来的json转化并处理
		var msg = str.split("###");// 将服务器传来的信息分成两部分--信息头和信息体
		var msgTitle = msg[0];// 获得信息头 判断发来的是哪种信息
		var jsonMsg = null;

		switch (msgTitle) {
		case "onlineServer":
			jsonMsg = JSON.parse(msg[1]);// 获得信息体 将信息转化为json
			customer = new Array(jsonMsg.length);

			$('.server_li').remove();
			var mydate = new Date();
			var t = mydate.toLocaleTimeString();

			for (var i = 0; i < jsonMsg.length; i++) {
				// 获得需要的信息
				// var cuCreatimeDate = jsonMsg[i].cuCreatime.date;

				serverCreatimeDate = jsonMsg[i].ser_creatime;

				serveridMsg = jsonMsg[i].serverid;
				customer[i] = customeridMsg;
				// var customersocketidMsg = jsonMsg[i].customersocketid;
				// var ipMsg = jsonMsg[i].ip;
				// var locationMsg = jsonMsg[i].location;
				// var stateMsg = jsonMsg[i].state;

				if (serveridMsg != localStorage.serverNum) {
					// 将信息展示在界面上
					var li = document.createElement("li");
					li.className = "server_li";
					var a = document.createElement("a");
					a.className = "easy_li";

					var newCus = document.createElement("div");
					newCus.className = "customerDiv";

					var cus_id = document.createElement("div");
					cus_id.className = "cus_id";

					var cus_time = document.createElement("div");
					cus_time.className = "cus_time";
					cus_time.innerHTML = t;

					var cus_num = document.createElement("div");
					cus_num.className = "cus_num";

					cus_id.innerHTML = serveridMsg.substring(0, 8) + "...";

					newCus.appendChild(cus_id);
					newCus.appendChild(cus_time);
					newCus.appendChild(cus_num);
					a.appendChild(newCus);
					li.appendChild(a);
					$('#server_list').append(li);

					// msgNum[i] = 0;
				}

			}
			$("div.customerDiv").click(function() {
				// index_now = $("div.customerDiv").index(this);
				// var cid = customer[index_now];
				// ws.send("chattosid##" + cid);
				// if (index != null && index != index_now) {
				$('.chat__msgRow').remove();
				// }
				// index = index_now;
				$('.cname').val(serveridMsg);
				$('.registertime').text(serverCreatimeDate);
				$('.logintime').text(mydate);
				$('.chat').css('display', 'block');
				$('.info').css('display', 'block');
				$('.cus_num').eq(index_now).text(" ");
			});
			break;
		case "onlineCustomer":
			jsonMsg = JSON.parse(msg[1]);// 获得信息体 将信息转化为json
			customer = new Array(jsonMsg.length);
			$('.chatToCustomer').remove();
			var mydate = new Date();
			//var t = mydate.toLocaleTimeString();
			for (var i = 0; i < jsonMsg.length; i++) {
				// 获得需要的信息
				// var cuCreatimeDate = jsonMsg[i].cuCreatime.date;
				cuCreatimeDate = jsonMsg[i].cuCreatime;

				customeridMsg = jsonMsg[i].customerid;
				customer[i] = customeridMsg;
				// var customersocketidMsg = jsonMsg[i].customersocketid;
				// var ipMsg = jsonMsg[i].ip;
				// var locationMsg = jsonMsg[i].location;
				// var stateMsg = jsonMsg[i].state;

				// 将信息展示在界面上
				/*
				 * <li> <a href="#"> <i class="fa fa-angle-double-right"></i>
				 * 客户1 <small class="badge pull-right bg-green"> </small> </a>
				 * 
				 * </li>
				 */
				var iTag = document.createElement("i");
				iTag.className = "fa fa-angle-double-right";

				var li = document.createElement("li");
				li.className = "chatToCustomer";

				var span = document.createElement("span");
				span.innerHTML = customeridMsg.substring(0, 8) + "...";

				var a = document.createElement("a");

				a.appendChild(iTag);
				a.appendChild(span);

				var div = document.createElement("div");
				div.className = "badge pull-right bg-green noReadNum";

				a.appendChild(div);
				// a.className = "easy_li";
				li.appendChild(a);

				$('#customer_list').append(li);

				/*
				 * var li = document.createElement("li"); li.className =
				 * "customer_li"; var a = document.createElement("a");
				 * a.className = "easy_li";
				 * 
				 * var newCus = document.createElement("div"); newCus.className =
				 * "customerDiv";
				 * 
				 * var cus_id = document.createElement("div"); cus_id.className =
				 * "cus_id";
				 * 
				 * var cus_time = document.createElement("div");
				 * cus_time.className = "cus_time"; cus_time.innerHTML = t;
				 * 
				 * var cus_num = document.createElement("div");
				 * cus_num.className = "cus_num";
				 * 
				 * cus_id.innerHTML = customeridMsg.substring(0, 8) + "...";
				 * 
				 * newCus.appendChild(cus_id); newCus.appendChild(cus_time);
				 * newCus.appendChild(cus_num); a.appendChild(newCus);
				 * li.appendChild(a); $('#customer_list').append(li);
				 */

				msgNum[i] = 0;
			}
			$("li.chatToCustomer").click(function() {
				index_now = $("li.chatToCustomer").index(this);
				var cid = customer[index_now];
				ws.send("chattosid##" + cid);
				// if (index != null && index != index_now) {
				$('.chat__msgRow').remove();
				// }
				index = index_now;
				$('.cname').val(customeridMsg);
				$('.registertime').text(cuCreatimeDate);
				$('.logintime').text(mydate);
				$('.chat').css('display', 'block');
				$('.info').css('display', 'block');
				$('.noReadNum').eq(index_now).html("");
				$('.haveNewMessage').html("");
			});
			break;

		case "msgRecord":
			// 旧的聊天记录 添加到界面上
			// 根据时间将json排序
			jsonMsg = JSON.parse(msg[1]);// 获得信息体 将信息转化为json
			jsonMsg.sort(function(a, b) {
				return Date.parse(a.createtime) - Date.parse(b.createtime);// 时间正序
			});
			for (var i = 0; i < jsonMsg.length; i++) {
				// 获得需要的信息
				var chatText = jsonMsg[i].content;
				var fromWho = jsonMsg[i].fromwho;
				if (chatText != null) {
					// 客户的信息
					// 将信息显示在界面上
					msgBodyDiv = document.getElementById("message");
					RowDiv = document.createElement("div");
					RowDiv.className = "chat__msgRow";
					var mydiv = document.createElement("span");
					if (fromWho == 0) {
						mydiv.className = "chat__message notMine";
					} else {
						mydiv.className = "chat__message mine";
					}
					mydiv.innerHTML = replace_em(chatText);

					RowDiv.appendChild(mydiv);
					msgBodyDiv.appendChild(RowDiv);
				}
			}
			break;

		case "hisChat":
			// leave_message_list
			jsonMsg = JSON.parse(msg[1]);// 获得信息体 将信息转化为json
			jsonMsg.sort(function(a, b) {
				return Date.parse(b.createtime) - Date.parse(a.createtime);// 时间正序
			});
			$('.history_div').remove();
			for (var int = 0; int < jsonMsg.length; int++) {
				var his_chat_id = jsonMsg[int].chatid;
				var his_cus_certime = jsonMsg[int].createtime;

				his_chat[int] = jsonMsg[int].chatid;
				// 将信息展示在界面上
				
				/*
				 * <li class="active">
				 * <a href="server1.html"> 
				 * <i class="fa fa-dashboard"></i> <span>当前会话</span><small
							class="badge pull-right bg-green">new</small>
					</a>
					</li>
				 * */
				var li = document.createElement("li");
				li.className="history_div"
				var a = document.createElement("a");
				var iTag = document.createElement("i");
				var span = document.createElement("span");
				span.innerHTML = his_chat_id.substring(0, 6) + "...";
				var div = document.createElement("div");
				div.innerHTML = his_cus_certime
				div.className = "badge pull-right bg-red";
				
				a.appendChild(iTag);
				a.appendChild(span);
				a.appendChild(div);
				li.appendChild(a);
				$('.hisChat-list').append(li);
			}
			$('.history_div').click(function() {
				his_index_now = $(".history_div").index(this);
				var his_chatid = his_chat[his_index_now];
				ws.send("gethischat##" + his_chatid);
				// if (index != null && index != index_now) {
				$('.chat__msgRow').remove();
				// }
				his_index = his_index_now;
				//$('.cname').val(customeridMsg);
				//$('.registertime').text(cuCreatimeDate);
				//$('.chat').css('display', 'block');
				//$('.info').css('display', 'block');
			});
			break;

		case "chathismsg":
			jsonMsg = JSON.parse(msg[1]);// 获得信息体 将信息转化为json
			
			jsonMsg.sort(function(a, b) {
				return Date.parse(b.createtime) - Date.parse(a.createtime);// 时间正序
			});

			for (var i = 0; i < jsonMsg.length; i++) {
				// 获得需要的信息
				var chatText = jsonMsg[i].content;
				var fromWho = jsonMsg[i].fromwho;
				if (chatText != null) {
					// 客户的信息
					// 将信息显示在界面上
					
					RowDiv = document.createElement("div");
					RowDiv.className = "chat__msgRow";
					var mydiv = document.createElement("span");
					if (fromWho == 0) {
						mydiv.className = "chat__message notMine";
					} else {
						mydiv.className = "chat__message mine";
					}
					mydiv.innerHTML = replace_em(chatText);

					RowDiv.appendChild(mydiv);
					$('.hisContent').append(RowDiv);
				}
			}
			break;

		case "leaveMessage":
			// 获得了留言列表 显示在界面上
			jsonMsg = JSON.parse(msg[1]);// 获得信息体 将信息转化为json
			$('.leaveMessage_div').remove();
			var lea_cus_certime = null;
			var lea_cus_id = null;
			for (var int = 0; int < jsonMsg.length; int++) {
				// 显示留言面板
				lea_cus_id = jsonMsg[int].customerid;
				lea_cus_certime = jsonMsg[int].createtime;
				var lea_cus_num = jsonMsg[int].msgnum;

				lea_chat[int] = jsonMsg[int].chatid;
				// 将信息展示在界面上
				var li = document.createElement("li");
				li.className="leaveMessage_div";
				var a = document.createElement("a");
				var iTag = document.createElement("i");
				var span = document.createElement("span");
				span.innerHTML = lea_cus_id.substring(0, 6) + "...";
				var div = document.createElement("div");
				div.innerHTML = lea_cus_certime;
				div.className = "badge pull-right bg-red";
				var div2 = document.createElement("div");
				div2.innerHTML = lea_cus_num;
				div2.className="lea_cus_num";
				div2.className = "badge pull-right bg-green";
				
				a.appendChild(iTag);
				a.appendChild(span);
				a.appendChild(div);
				a.appendChild(div2);
				li.appendChild(a);
				$('.leaveMessage-list').append(li);

			}
			$('.leaveMessage_div').click(function() {
				lea_index_now = $(".leaveMessage_div").index(this);
				var lea_chatid = lea_chat[lea_index_now];
				ws.send("getleamsg##" + lea_chatid);
				// if (index != null && index != index_now) {
				$('.chat__msgRow').remove();
				// }
				lea_index = lea_index_now;
				$('.lea_cus_num').eq(lea_index).val("");
				//$('.cname').val(lea_cus_id);
				//$('.registertime').text(lea_cus_certime);
				//$('.chat').css('display', 'block');
				//$('.info').css('display', 'block');
			});
			break;

		case "leavemsg":
			jsonMsg = JSON.parse(msg[1]);// 获得信息体 将信息转化为json
			jsonMsg.sort(function(a, b) {
				return Date.parse(a.createtime) - Date.parse(b.createtime);// 时间正序
			});

			for (var i = 0; i < jsonMsg.length; i++) {
				// 获得需要的信息
				var chatText = jsonMsg[i].content;
				var fromWho = jsonMsg[i].fromwho;
				if (chatText != null) {
					// 客户的信息
					// 将信息显示在界面上
					msgBodyDiv = document.getElementById("leave_message_content");
					RowDiv = document.createElement("div");
					RowDiv.className = "chat__msgRow";
					var mydiv = document.createElement("span");
					if (fromWho == 0) {
						mydiv.className = "chat__message notMine";
					} else {
						mydiv.className = "chat__message mine";
					}
					mydiv.innerHTML = replace_em(chatText);

					RowDiv.appendChild(mydiv);
					msgBodyDiv.appendChild(RowDiv);
				}
			}
			break;

		case "serveran":
			jsonMsg = JSON.parse(msg[1]);
			//将信息添加在面板上 <li class="easy"><a class="easy_li">多喝热水 </a></li>
			$('.serverAnswer li').remove();
			
			for (var int2 = 0; int2 < jsonMsg.length; int2++) {
				var content = jsonMsg[int2];
				
				var li = document.createElement("li");
				li.className="easy";
				var a = document.createElement("a");
				a.className="easy_li";
				a.innerHTML = content;
				li.appendChild(a);
				$('.serverAnswer').append(li);
				$(".easy .easy_li").click(function() {
					var eastContent = $(this).text();
					$("#chatContent").text(eastContent);
				});
			}
			
			
			break;
			
		case "systeman":
			jsonMsg = JSON.parse(msg[1]);// 获得信息体 将信息转化为json
			//将信息添加在面板上 <li class="easy"><a class="easy_li">多喝热水 </a></li>
			$('.systemAnswer li').remove();
			
			for (var int2 = 0; int2 < jsonMsg.length; int2++) {
				var content = jsonMsg[int2];
				
				var li = document.createElement("li");
				li.className="easy";
				var a = document.createElement("a");
				a.className="easy_li";
				a.innerHTML = content;
				li.appendChild(a);
				$('.systemAnswer').append(li);
				$(".easy .easy_li").click(function() {
					var eastContent = $(this).text();
					$("#chatContent").text(eastContent);
				});
			}
			
			
			break;
			
		case "numMsgs":
			// 后台数字数据
			jsonMsg = JSON.parse(msg[1]);// 获得信息体 将信息转化为json
			//{"chatnumber":23,"customernumber":3,"onlinecustomer":0,"onlineserver":1,"servernumber":5}
			var chatnumber = jsonMsg[0].chatnumber; // 总会话数
			var onlinecustomer = jsonMsg[0].onlinecustomer; // 用户总量
			var customernumber = jsonMsg[0].customernumber; // 正在咨询人数
			var onlineserver = jsonMsg[0].onlineserver; // 在线客服人数
			var servernumber = jsonMsg[0].servernumber; // 客服总量

			$("h3.chatnumber").text(chatnumber);
			$("h3.customernumber").text(customernumber);
			$("h3.onlinecustomer").text(onlinecustomer);
			$("h3.onlineserver").text(onlineserver);
			$("h3.servernumber").text(servernumber);

			break;
		case "servermsgMsgs":
			jsonMsg = JSON.parse(msg[1]);// 获得信息体 将信息转化为json
			// {"msgnum":2,"serverid":"00HxVzYlw3OXQqsBAAwBtN3gPRg90J3UwvmXzyV4tgi5vdpXGCA5VqcrGF4xkihG","servermsgnum":1}

//			for (var i = 0; i < jsonMsg.length; i++) {
//				//var msgnum = jsonMsg[i].msgnum; /* 每个客服的消息数量（客户加客服） */
//				//var servermsgnum = jsonMsg[i].servermsgnum; /* 每个客服自己发出的的消息数量 */
//				//var serverid = jsonMsg[i].serverid.substring(0, 8) + "...";
//
//				var tr = document.createElement("tr");
//				tr.className = "host_table_tr1";
//
//				var td = new Array();
//				for (var int2 = 0; int2 < 8; int2++) {
//					td[int2] = document.createElement("td");
//					td[int2].className = "work_table_" + (i + 1) + "_"
//							+ (int2 + 1);
//					tr.appendChild(td[int2]);
//				}
//
//			}

			break;

		default:
			// 普通消息 即客户发来的聊天消息 此时msgTitle就是用户的id

			// 判断当前消息是由第几个用户发来的
			var nowSend = 0;
			for (var int = 0; int < customer.length; int++) {
				if (msgTitle == customer[int]) {
					nowSend = int;
					break;
				}
			}
			// 判断该消息是否是当前聊天客户所发来 如果是 则将信息显示在界面上 如果不是 则将信息条数保存在一个数组中
			// 并在相应的客户div显示出来
			if (nowSend != index_now) {
				// 不是当前用户 判断消息来源 于第几个客户 并将条数保存在一个数组中 动态的显示在对应div中
				msgNum[nowSend]++;// 第nowSend个用户未读数据+1
				// $('.badge .pull-right
				// .bg-green').eq(nowSend).text(msgNum[nowSend]);
				$('.noReadNum').eq(nowSend).html(msgNum[nowSend]);
				$('.haveNewMessage').text(msgNum[nowSend]);
				$('<p>来自客户的消息：<br>' + msg[1] + '</p>').notify();
				break;
			} else {
				// 就是当前用户发来的消息 直接显示
				getMessage(msg[1]);
				$('<p>来自客户的消息：<br>' + msg[1] + '</p>').notify();
				break;
			}
		}
	};

	ws.onclose = function(e) {
		// 客服下线
	};

	// 点击按钮发送消息
	$('.send').click(sendMessage);
	// 回车发送消息
	$('#chatContent').keydown(function(e) {
		if (e.keyCode == 13) {
			sendMessage();// 处理事件
		}
	});

	$('.nowData').click(function() {
		ws.send("adminMsg##");
	});
	// 选择了图片
	$('#send_file').change(function() {
		var inputElement = document.getElementById("send_file");
		var fileList = inputElement.files;

		for (var i = 0; i < fileList.length; i++) {
			console.log(fileList[i]);

			// 发送文件名
			// ws.send(fileList[i].name);
			// alert(fileList[i].name);
			// reader.readAsBinaryString(fileList[i]);
			// 读取文件
			var reader = new FileReader();
			reader.readAsArrayBuffer(fileList[i]);

			// 文件读取完毕后该函数响应
			reader.onload = function loaded(evt) {
				//var binaryString = evt.target.result;
				// Handle UTF-16 file dump
				// ws.send("photo"+"fileeeeee"+binaryString);
				// console.log(binaryString);
				// alert(binaryString);
			};
		}
		return false;
	});
	
	$('.transToHisChat').click(function () {
		ws.send("left_hischat");
	});
	
	$('.transToLea').click(function () {
		ws.send("left_leavemessage");
	});

	$('.left_set').click(function() {
		$('.chat').css('display', 'none');
		$('.info').css('display', 'none');
		$('.leave_message').css('display', 'none');
		$('.history_chat').css('display', 'none');
		$('.cusList').css('display', 'none');
		$('.back').css('display', 'block');

	});

	$('.left_nowchat').click(function() {
		$('.chat').css('display', 'none');
		$('.info').css('display', 'none');
		$('.leave_message').css('display', 'none');
		$('.history_chat').css('display', 'none');
		$('.back').css('display', 'none');
		$('.cusList').css('display', 'block');

	});
	$('.left_leavemessage').click(function() {
		$('.chat').css('display', 'none');
		$('.info').css('display', 'none');
		$('.cusList').css('display', 'none');
		$('.history_chat').css('display', 'none');
		$('.back').css('display', 'none');
		$('.leave_message').css('display', 'block');
		ws.send("left_leavemessage");
	});
	$('.left_hischat').click(function() {
		$('.chat').css('display', 'none');
		$('.info').css('display', 'none');
		$('.cusList').css('display', 'none');
		$('.back').css('display', 'none');
		$('.leave_message').css('display', 'none');
		$('.history_chat').css('display', 'block');
		ws.send("left_hischat");
	});

	$('#transToAdmin').bind('click', function() {
		$('#nowChat').css('display', 'none');
		$('.menu').css('display', 'block');
		$('#admin').css('display', 'block');
		$('.right').css('display', 'block');

		ws.send("adminMsg");
	});

	$(".public_easycontent .nLi h3").click(function() {
		if ($(this).parent(".nLi").hasClass("on")) {
			$(this).next(".sub").slideUp(300, function() {
				$(this).parent(".nLi").removeClass("on");
			});
		} else {
			$(this).next(".sub").slideDown(300, function() {
				$(this).parent(".nLi").addClass("on");
			});
		}
	});

	$(".list .nLi h3").click(function() {
		if ($(this).parent(".nLi").hasClass("on")) {
			$(this).next(".sub").slideUp(300, function() {
				$(this).parent(".nLi").removeClass("on");
			});
		} else {
			$(this).next(".sub").slideDown(300, function() {
				$(this).parent(".nLi").addClass("on");
			});
		}
	});
	$(".easy .easy_li").click(function() {
		var eastContent = $(this).text();
		$("#chatContent").text(eastContent);
	});

	$(".esaytitle-public").click(function() {
		$(".personal_easycontent").css('display', 'none');
		$(".public_easycontent").css('display', 'block');
	});

	$(".esaytitle-personal").click(function() {
		$(".public_easycontent").css('display', 'none');
		$(".personal_easycontent").css('display', 'block');
	});

	$('#show-easykey')
			.click(
					function() {
						document.getElementById('chat-dialog').className = 'chat-dialog col-md-8';

						document.getElementById('chat-easykey').className = 'chat-easykey col-md-4';
						document.getElementById('chat-easykey').style.display = 'block';
						document.getElementById('show-easykey').style.display = 'none';
						document.getElementById('remove-easykey').style.display = 'block';
					});

	$('#remove-easykey')
			.click(
					function() {
						document.getElementById('chat-easykey').style.display = 'none';
						document.getElementById('chat-easykey').className = 'chat-easykey col-md-0';
						document.getElementById('chat-dialog').className = 'chat-dialog col-md-12';
						;
						document.getElementById('remove-easykey').style.display = 'none';
						document.getElementById('show-easykey').style.display = 'block';
					});
	$.notifySetup({
		sound : '/CustomerServerSystem/resources/audio/notify.wav'
	});
	$('.emotion').qqFace({
		id : 'facebox', // 表情盒子的ID
		assign : 'chatContent', // 给那个控件赋值
		path : '/CustomerServerSystem/resources/face/' // 表情存放的路径
	});

	function sendToCustomer(msg) {
		ws.send(msg);
	}

	function sendMessage() {
		var msg = document.getElementById("chatContent").value;
		var RowDiv = null;
		var msgBodyDiv = null;
		if (msg.length > 0) {

			// 将信息显示在界面上
			msgBodyDiv = document.getElementById("message");
			RowDiv = document.createElement("div");
			RowDiv.className = "chat__msgRow";

			var mydiv = document.createElement("span");
			mydiv.className = "chat__message mine";
			mydiv.innerHTML = replace_em(msg);

			RowDiv.appendChild(mydiv);
			msgBodyDiv.appendChild(RowDiv);

			document.getElementById("chatContent").value = "";

			// 将消息传递到服务器，由服务器发送给客服
			sendToCustomer(msg);

		}
	}

	function getMessage(msg) {

		var msgBodyDiv = document.getElementById("message");
		var RowDiv = document.createElement("div");
		RowDiv.className = "chat__msgRow";

		var mydiv = document.createElement("div");
		mydiv.className = "chat__message notMine";
		mydiv.innerHTML = replace_em(msg);

		RowDiv.appendChild(mydiv);
		msgBodyDiv.appendChild(RowDiv);

	}

	// 将字符替换为图片
	function replace_em(str) {
		str = str.replace(/\</g, "&lt;");
		str = str.replace(/\>/g, '&gt;');
		str = str.replace(/\n/g, '<br/>');
		str = str.replace(/\[em_([0-9]*)\]/g,
				'<img src="../resources/face/$1.gif" border="0" />');
		return str;
	}

	function randomWord(randomFlag, min, max) {
		var str = "", range = min, arr = [ '0', '1', '2', '3', '4', '5', '6',
				'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
				'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
				'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
				'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z' ];

		// 随机产生
		if (randomFlag) {
			range = Math.round(Math.random() * (max - min)) + min;
		}
		for (var i = 0; i < range; i++) {
			pos = Math.round(Math.random() * (arr.length - 1));
			str += arr[pos];
		}
		return str;
	}
};
