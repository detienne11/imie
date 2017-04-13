package fr.imie.training.cdi13.dav.tptests;

public class TonaliteState extends State {

	public State next(ACTION_TYPE action) {
		State state = this;
		
//		if (ACTION_TYPE.RECEVOIR_APPEL ==  action) {
//			state = new SonneState();
//		}
//		else if (ACTION_TYPE.RECEVOIR_APPEL ==  action) {
//			state = new TonaliteState();
//		}
		return state;
	}
	
}
