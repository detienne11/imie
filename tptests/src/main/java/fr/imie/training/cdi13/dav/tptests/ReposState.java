package fr.imie.training.cdi13.dav.tptests;

public class ReposState extends State {

//	public ReposState() {
//		super(TelephoneIfc.ETAT.REPOS);
//	}

	public State next(TelephoneIfc.TRANSITION transition) {
		State state = this;
		
		// REPOS appel_entrant SONNERIE
		// REPOS decrocher DECROCHER
		// REPOS raccrocher REPOS
		// REPOS numeroter REPOS
		// REPOS decrocher INT REPOS
		// REPOS raccrocher INT REPOS
		// REPOS timeout REPOS
		
		if (TelephoneIfc.TRANSITION.APPEL_ENTRANT ==  transition) {
			state = this.createState(TelephoneIfc.ETAT.SONNERIE);
		}
		else if (TelephoneIfc.TRANSITION.DECROCHER ==  transition) {
			state = this.createState(TelephoneIfc.ETAT.DECROCHER);
		}
		return state;
	}
	
}
