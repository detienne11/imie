package fr.imie.training.cdi13.dav.tpwebsocket;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.Session;

@ApplicationScoped
public class ChatHandler {

	private Set<Session> sessionSet = new HashSet<Session>();
	
	public void add(Session session){
		this.sessionSet.add(session);
	}
	
	public void remove(Session session){
		this.sessionSet.remove(session);
	}
	
	public void handleMessage(String message){
		
		JsonObject json = Json.createReader(new StringReader(message)).readObject();
		
		for (Session session : sessionSet) {
			try {
				session.getBasicRemote().sendText(json.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
