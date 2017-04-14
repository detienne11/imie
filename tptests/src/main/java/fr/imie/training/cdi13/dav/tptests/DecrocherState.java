package fr.imie.training.cdi13.dav.tptests;

public class DecrocherState extends State {

//	public DecrocherState() {
//		super(TelephoneIfc.ETAT.DECROCHER);
//	}

	public State next(TelephoneIfc.TRANSITION transition) {
		State state = this;

		// DECROCHER appel_entrant DECROCHER
		// DECROCHER decrocher DECROCHER
		// DECROCHER raccrocher REPOS
		// DECROCHER numeroter ENAPPEL
		// DECROCHER decrocher INT DECROCHER
		// DECROCHER raccrocher INT DECROCHER
		// DECROCHER timeout DECROCHER

		if (TelephoneIfc.TRANSITION.RACCROCHER == transition) {
			state = this.createState(TelephoneIfc.ETAT.REPOS);
		} else if (TelephoneIfc.TRANSITION.NUMEROTER == transition) {
			state = this.createState(TelephoneIfc.ETAT.ENAPPEL);
		}
		return state;
	}

}
