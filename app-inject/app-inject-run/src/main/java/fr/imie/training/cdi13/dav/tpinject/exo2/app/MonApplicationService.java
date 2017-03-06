package fr.imie.training.cdi13.dav.tpinject.exo2.app;

import fr.imie.training.cdi13.dav.tpinject.exo2.service.EnvoiMessageService;

public class MonApplicationService implements Consumer {

	private EnvoiMessageService envoiMessageService;

	public MonApplicationService(EnvoiMessageService envoiMessageService) {
		this.envoiMessageService = envoiMessageService;
	}

	@Override
	public void processMessages(String msg, String sendTo) {
		this.envoiMessageService.envoiMessage(msg, sendTo);
	}

}
