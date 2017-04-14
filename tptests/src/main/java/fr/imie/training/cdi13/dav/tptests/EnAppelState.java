package fr.imie.training.cdi13.dav.tptests;

public class EnAppelState extends State {

//	public EnAppelState() {
//		super(TelephoneIfc.ETAT.ENAPPEL);
//	}

	public State next(TelephoneIfc.TRANSITION transition) {
		State state = this;

		// ENAPPEL appel_entrant ENAPPEL
		// ENAPPEL decrocher ENAPPEL
		// ENAPPEL raccrocher REPOS
		// ENAPPEL numeroter ENAPPEL
		// ENAPPEL decrocher INT ENCONVERSATION
		// ENAPPEL raccrocher INT ENAPPEL
		// ENAPPEL timeout DECROCHER

		if (TelephoneIfc.TRANSITION.RACCROCHER == transition) {
			state = this.createState(TelephoneIfc.ETAT.REPOS);
		} else if (TelephoneIfc.TRANSITION.DECROCHER_INT == transition) {
			state = this.createState(TelephoneIfc.ETAT.ENCONVERSATION);
		} else if (TelephoneIfc.TRANSITION.TIMEOUT == transition) {
			state = this.createState(TelephoneIfc.ETAT.DECROCHER);
		}
		return state;
	}

}
