window.onload=function(){
	ws = new  WebSocket("ws://localhost:8080/CustomerServerSystem/connectwebsocket");
	var server;
	chatsocket = null;
	
	ws.onopen = function(e){
		if(localStorage.customerNum == null){
			localStorage.customerNum=randomWord(false,64,64);
		}
		
		ws.send("iamcid##"+localStorage.customerNum);
	};
		
	ws.onmessage = function(e){
		// 连接一建立 服务器会立即发送客户的信息给客服 在这里处理接收到的信息
		var str = e.data;
		// 处理客服请求服务器的信息 将服务器传来的json转化并处理
		var msg = str.split("###");// 将服务器传来的信息分成两部分--信息头和信息体
		var msgTitle = msg[0];// 获得信息头 判断发来的是哪种信息

		switch (msgTitle) {
		case "onlineServer":
			var jsonMsg = JSON.parse(msg[1]);// 获得信息体 将信息转化为json
			server = new Array(jsonMsg.length);
			$('div.sidebar-content .server').remove();
			for (var i = 0; i < jsonMsg.length; i++) {
				
				// 获得需要的信息
				// var cuCreatimeDate = jsonMsg[i].cuCreatime.date;
				// var cuCreatimeDate = jsonMsg[i].cuCreatime.date;

				 var serveridMsg = jsonMsg[i].serverid;
				 server[i] = serveridMsg;
				// var customersocketidMsg = jsonMsg[i].customersocketid;
				// var ipMsg = jsonMsg[i].ip;
				// var locationMsg = jsonMsg[i].location;
				// var stateMsg = jsonMsg[i].state;

				// 将信息展示在界面上
				// <div class="contact"> -->
				//      <img src="/CustomerServerSystem/resources/img/1.png" alt="" class="contact__photo" />
				//      <span class="contact__name">Ethan Hawke</span>
				//      <span class="contact__status online"></span>
				// </div>
				var newSer = null;
				var serverHead = null;
				var nameSpan = null;
				var statuSpan = null;
				var serverDiv = document.getElementById("sidebar-content");		
				newSer = document.createElement("div");
				newSer.className = "contact server";
				//newSer.onclick=connect;
				
				
				serverHead = document.createElement("img");
				serverHead.src="/CustomerServerSystem/resources/img/1.png";
				serverHead.className = "contact__photo";
				
				nameSpan = document.createElement("span");
				nameSpan.className = "contact__name";
				nameSpan.innerHTML = serveridMsg.substring(0, 8)+"...";
				
				statuSpan = document.createElement("span");
				statuSpan.className = "contact__status online";
					
				serverDiv.appendChild(newSer);
				newSer.appendChild(serverHead);
				newSer.appendChild(nameSpan);
				newSer.appendChild(statuSpan);
			}
			//用来建立聊天socket的方法
			$('div.sidebar-content>.contact').click(function(){
				//chatsocket = new  WebSocket("ws://localhost:8080/CustomerServerSystem/customerwebsocket");
				var index=$('div.sidebar-content>.contact').index(this);
				var sid = server[index];//所选的 客服的id
				ws.send("chattosid##"+sid);
			});
			break;
			

		default:
			//普通的对话消息
			getMessage(str);
			//$('.notify right-notify').setStyle('success').show(str);
			$('<p>来自客服的消息：<br>'+str+'</p>').notify();
			break;
		};
	};
	
	
	
};


//将字符替换为图片
function replace_em(str){
	str = str.replace(/\</g,"&lt;");
	str = str.replace(/\>/g,'&gt;');
	str = str.replace(/\n/g,'<br/>');
	str = str.replace(/\[em_([0-9]*)\]/g,'<img src="../resources/face/$1.gif" border="0" />');
	return str;
}

function sendToServer(msg){
	ws.send(msg);
}

document.getElementById("send").onclick = function (){
	var msg = document.getElementById("text").value;

	if (msg.length > 0) {

		var msgBodyDiv = document.getElementById("msg_body");
		var RowDiv = document.createElement("div");
		RowDiv.className = "chat__msgRow";

		var mydiv = document.createElement("div");
		mydiv.className = "chat__message notMine";
		mydiv.innerHTML=replace_em(msg);

		
		RowDiv.appendChild(mydiv);
		msgBodyDiv.appendChild(RowDiv);
		
		document.getElementById("text").value = "";
		
		//����Ϣ���͸��������
		sendToServer(msg);
		
	};
};
function sendMessage(){
	var msg = $('#text').val();
	if (msg != null) {

		var msgBodyDiv = document.getElementById("msg_body");
		var RowDiv = document.createElement("div");
		RowDiv.className = "chat__msgRow";

		var mydiv = document.createElement("div");
		mydiv.className = "chat__message notMine";
		mydiv.innerHTML=replace_em(msg);

		
		RowDiv.appendChild(mydiv);
		msgBodyDiv.appendChild(RowDiv);
		
		document.getElementById("text").value = "";
		
		//����Ϣ���͸��������
		sendToServer(msg);
		
	}
};

function getMessage(msg){
	
	
	if (msg.length >0) {

		var msgBodyDiv = document.getElementById("msg_body");
		var RowDiv = document.createElement("div");
		RowDiv.className = "chat__msgRow";

		var mydiv = document.createElement("div");
		mydiv.className = "chat__message mine";
		mydiv.innerHTML=replace_em(msg);
		
		RowDiv.appendChild(mydiv);
		msgBodyDiv.appendChild(RowDiv);
	
	}
};

$('#text').keydown(function(e) {
	if (e.keyCode == 13) {
		sendMessage() ;// 处理事件
	}
});

$('.chat__back').click(function(){

	$('.chat__msgRow').remove();
	//ws.send("chatover");
	
	$('#dialog').dialogBox({
		width : 400,
		hasClose : true,
		effect : 'fade',
		hasBtn : true,
		type : 'correct',
		confirm : function() {
//			$("#message").dialogBox({
//				content : '感谢使用',
//				hasClose : true
//			});
			ws.send("chatover##5");
		},
		cancel : function() {
			ws.send("chatover##0");
		},
		title : '评价',
		content : '您对本次服务满意吗？'
	});
	
});

//点击了机器人
$('#wl_robot').click(function() {
	ws.send("chatToRobot");
});

function randomWord(randomFlag, min, max){
    var str = "",
        range = min,
        arr = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];
 
    // 随机产生
    if(randomFlag){
        range = Math.round(Math.random() * (max-min)) + min;
    }
    for(var i=0; i<range; i++){
        pos = Math.round(Math.random() * (arr.length-1));
        str += arr[pos];
    }
    return str;
}
