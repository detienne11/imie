package fr.imie.training.cdi13.dav.tpinject.cdi.service;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("Email")
public class EmailServiceImpl implements EnvoiMessageService {

	private final static Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);
	
	@Override
	public void envoiMessage(String msg, String sendTo) {
		logger.debug(this.getClass().getName() + " : Email sent to " + sendTo + " with	Message=" + msg);
	}

}
