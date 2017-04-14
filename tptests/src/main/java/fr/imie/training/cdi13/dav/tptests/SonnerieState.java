package fr.imie.training.cdi13.dav.tptests;

public class SonnerieState extends State {

//	public SonnerieState() {
//		super(TelephoneIfc.ETAT.SONNERIE);
//	}

	public State next(TelephoneIfc.TRANSITION transition) {
		State state = this;

		// SONNERIE appel_entrant SONNERIE
		// SONNERIE decrocher ENCONVERSATION
		// SONNERIE raccrocher SONNERIE
		// SONNERIE numeroter SONNERIE
		// SONNERIE decrocher INT SONNERIE
		// SONNERIE raccrocher INT SONNERIE
		// SONNERIE timeout REPOS

		if (TelephoneIfc.TRANSITION.DECROCHER == transition) {
			state = this.createState(TelephoneIfc.ETAT.ENCONVERSATION);
		} else if (TelephoneIfc.TRANSITION.TIMEOUT == transition) {
			state = this.createState(TelephoneIfc.ETAT.REPOS);
		}
		return state;
	}

}
