package fr.imie.training.cdi13.dav.tptests;

public abstract class State {
	
	public enum ACTION_TYPE {RECEVOIR_APPEL,DECROCHER,RACCROCHER,SAISIR};
	
	public abstract State next(ACTION_TYPE action);

}
