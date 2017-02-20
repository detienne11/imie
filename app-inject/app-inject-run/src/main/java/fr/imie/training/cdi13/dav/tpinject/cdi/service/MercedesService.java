package fr.imie.training.cdi13.dav.tpinject.cdi.service;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
public class MercedesService implements AutoService {

	private final static Logger logger = LoggerFactory.getLogger(MercedesService.class);

	@Override
	public String getService() {
		String msg = "Belle Voiture : pour les papys";
		logger.info(msg);
		return msg;
	}

}
