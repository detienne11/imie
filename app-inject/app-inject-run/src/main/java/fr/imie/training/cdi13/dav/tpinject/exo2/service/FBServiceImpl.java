package fr.imie.training.cdi13.dav.tpinject.exo2.service;

public class FBServiceImpl implements EnvoiMessageService {

	@Override
	public void envoiMessage(String msg, String sendTo) {
		System.out.println(this.getClass().getName() + " : FB sent to " + sendTo + " with	Message=" + msg);
	}

}
