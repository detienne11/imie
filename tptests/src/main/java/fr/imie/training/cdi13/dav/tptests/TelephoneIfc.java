package fr.imie.training.cdi13.dav.tptests;

public interface TelephoneIfc {

	public enum TRANSITION {APPEL_ENTRANT,DECROCHER,NUMEROTER,RACCROCHER,DECROCHER_INT,RACCROCHER_INT,TIMEOUT};
	
	public enum ETAT {REPOS,DECROCHER,SONNERIE,ENAPPEL,ENCONVERSATION};
	
}
