package fr.imie.training.cdi13.dav.tpinject.cdi.service;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("Fb")
public class FBServiceImpl implements EnvoiMessageService {

	private final static Logger logger = LoggerFactory.getLogger(FBServiceImpl.class);
	
	@Override
	public void envoiMessage(String msg, String sendTo) {
		logger.debug(this.getClass().getName() + " : FB sent to " + sendTo + " with	Message=" + msg);
	}

}
