package fr.imie.training.cdi13.dav.tptests;

public class EnConversationState extends State {

//	public EnConversationState() {
//		super(TelephoneIfc.ETAT.ENCONVERSATION);
//	}

	public State next(TelephoneIfc.TRANSITION transition) {
		State state = this;

		// ENCONVERSATION appel_entrant ENCONVERSATION
		// ENCONVERSATION decrocher ENCONVERSATION
		// ENCONVERSATION raccrocher REPOS
		// ENCONVERSATION numeroter ENCONVERSATION
		// ENCONVERSATION decrocher INT ENCONVERSATION
		// ENCONVERSATION raccrocher INT DECROCHER
		// ENCONVERSATION timeout ENCONVERSATION

		if (TelephoneIfc.TRANSITION.RACCROCHER == transition) {
			state = this.createState(TelephoneIfc.ETAT.REPOS);
		} else if (TelephoneIfc.TRANSITION.RACCROCHER_INT == transition) {
			state = this.createState(TelephoneIfc.ETAT.DECROCHER);
		}
		return state;
	}

}
