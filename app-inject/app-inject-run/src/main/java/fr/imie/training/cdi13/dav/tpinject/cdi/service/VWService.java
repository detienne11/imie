package fr.imie.training.cdi13.dav.tpinject.cdi.service;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("VW")
public class VWService implements AutoService {

	private final static Logger logger = LoggerFactory.getLogger(VWService.class);

	@Override
	public String getService() {
		String msg = "Tres belle voiture moins cher: comme la mienne";
		logger.info(msg);
		return msg;
	}

}
