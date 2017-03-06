package fr.imie.training.cdi13.dav.tpinject.cdi.service;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("Sms")
public class SmsServiceImpl implements EnvoiMessageService {

	private final static Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);
	
	@Override
	public void envoiMessage(String msg, String sendTo) {
		logger.debug(this.getClass().getName() + " : Sms sent to " + sendTo + " with	Message=" + msg);
	}

}
