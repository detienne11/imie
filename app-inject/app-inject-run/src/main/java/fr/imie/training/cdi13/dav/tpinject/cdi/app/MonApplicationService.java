package fr.imie.training.cdi13.dav.tpinject.cdi.app;

import javax.inject.Inject;
import javax.inject.Named;

import fr.imie.training.cdi13.dav.tpinject.exo2.service.EnvoiMessageService;

public class MonApplicationService implements Consumer {

//	@Inject @Named("Fb") private EnvoiMessageService envoiMessageService;
	private EnvoiMessageService envoiMessageService;
//	public MonApplicationService(EnvoiMessageService envoiMessageService) {
//		this.envoiMessageService = envoiMessageService;
//	}

	@Override
	public void processMessages(String msg, String sendTo) {
		this.envoiMessageService.envoiMessage(msg, sendTo);
	}

}
