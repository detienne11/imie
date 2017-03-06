package fr.imie.training.cdi13.dav.tpejb.ejb;

import javax.ejb.Remote;

@Remote
public interface HelloRemote {

	public String message();
	
}
