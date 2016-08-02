package cn.wlmb.css.socket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

public interface WebSocketInterface {

	@OnOpen
	public void onOpen(Session session);

	@OnClose
	public void onClose();

	@OnMessage
	public void onMessage(String message, Session session);

	@OnError
	public void onError(Session session, Throwable error);

}
