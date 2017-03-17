package fr.imie.training.cdi13.dav.tpwebsocket;

import java.io.IOException;
import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/demo")
public class DemoWebSocket {

	@OnOpen
	public void onOpen(Session session){
		System.out.println("Open session : id=" + session.getId());
		try {
			
			String str = Json.createObjectBuilder()
					.add("c", 50)
					.add("d", "test")
					.build().toString();
			
			session.getBasicRemote().sendText(str);
			
//			session.getBasicRemote().sendText("Server is opened ..");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@OnMessage
	public void onMessage(String message){
		System.out.println("Message : " + message);
		JsonObject json = Json.createReader(new StringReader(message)).readObject();
		json.getInt("a");
		json.getString("b");
	}
	
	@OnClose
	public void onClose(Session session){
		System.out.println("Close ...");
	}
}
