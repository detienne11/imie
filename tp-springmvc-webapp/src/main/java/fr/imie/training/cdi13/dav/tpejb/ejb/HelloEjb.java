package fr.imie.training.cdi13.dav.tpejb.ejb;

import javax.ejb.Stateless;

@Stateless
public class HelloEjb implements HelloLocal,HelloRemote {

	@Override
	public String message() {
		return "EJB server side said Hello";
	}

}
