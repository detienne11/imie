package fr.imie.training.cdi13.dav.tpejb.ejb;

import javax.ejb.Stateless;

@Stateless
public class HelloEjb implements HelloLocal {

	@Override
	public String hello() {
		return "EJB local side said Bonjour";
	}

}
