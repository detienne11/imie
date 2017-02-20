package fr.imie.training.cdi13.dav.tpinject.exo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailService {

	private final static Logger logger = LoggerFactory.getLogger(EmailService.class);
	
	public void sendEmail(String msg, String sendTo) {
		logger.debug("Email sent to " + sendTo + " with	Message=" + msg);
	}
}