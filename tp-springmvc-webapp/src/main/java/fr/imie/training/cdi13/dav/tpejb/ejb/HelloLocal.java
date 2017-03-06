package fr.imie.training.cdi13.dav.tpejb.ejb;

import javax.ejb.Local;

@Local
public interface HelloLocal {

	public String message();
	
}
