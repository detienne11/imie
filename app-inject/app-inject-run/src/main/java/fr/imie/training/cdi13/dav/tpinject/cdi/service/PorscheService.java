package fr.imie.training.cdi13.dav.tpinject.cdi.service;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("Porsche")
public class PorscheService implements AutoService {

	private final static Logger logger = LoggerFactory.getLogger(VWService.class);

	@Override
	public String getService() {
		String msg = "Tres belle voiture de luxe: pas comme la mienne";
		logger.info(msg);
		return msg;
	}

}
