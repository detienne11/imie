package fr.imie.training.cdi13.dav.tpwebsocket;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ApplicationScoped
@ServerEndpoint("/chat")
public class ChatWebSocket {

	@Inject
	private ChatHandler chatHandler;
	
	@OnOpen
	public void onOpen(Session session){
		System.out.println("Open session : id=" + session.getId());
		chatHandler.add(session);
	}
	
	@OnMessage
//	public void onMessage(String message, Session session){
//	System.out.println("Message received : msg=" + message + ", sessionid=" + session);
	public void onMessage(String message){
		System.out.println("Message received : " + message);		
		chatHandler.handleMessage(message);
	}
	
	@OnClose
	public void onClose(Session session){
		System.out.println("Close session id=" + session.getId());
		chatHandler.remove(session);
	}
}
