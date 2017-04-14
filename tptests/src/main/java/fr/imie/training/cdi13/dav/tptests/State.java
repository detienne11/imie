package fr.imie.training.cdi13.dav.tptests;

public abstract class State {

//	private TelephoneIfc.ETAT status = null;
	
	private DecrocherState decrocherState = null;
	
	private EnAppelState enAppelState = null;
	
	private EnConversationState enConversationState = null;
	
	private ReposState reposState = null;
	
	private SonnerieState sonnerieState = null;

//	public State(TelephoneIfc.ETAT status) {
//		this.status = status;
//	}

//	@Override
//	public boolean equals(Object obj) {
//
//		boolean equals = false;
//
//		if (obj != null && obj instanceof State && ((State) obj).status == this.status) {
//			equals = true;
//		}
//		return equals;
//	}

	public abstract State next(TelephoneIfc.TRANSITION transition);

	public State createState(TelephoneIfc.ETAT state) {

		State oState = null;

		if (state == TelephoneIfc.ETAT.DECROCHER) {
			
			if (this.decrocherState == null) {
				this.decrocherState = new DecrocherState();
			}
			oState = this.decrocherState;
			
		} else if (state == TelephoneIfc.ETAT.ENAPPEL) {
			
			if (this.enAppelState == null) {
				this.enAppelState = new EnAppelState();
			}
			oState = this.enAppelState;
			
		} else if (state == TelephoneIfc.ETAT.ENCONVERSATION) {
			
			if (this.enConversationState == null) {
				this.enConversationState = new EnConversationState();
			}
			oState = this.enConversationState;
			
		} else if (state == TelephoneIfc.ETAT.REPOS) {

			if (this.reposState == null) {
				this.reposState = new ReposState();
			}
			oState = this.reposState;
			
		} else if (state == TelephoneIfc.ETAT.SONNERIE) {
			
			if (this.sonnerieState == null) {
				this.sonnerieState = new SonnerieState();
			}
			oState = this.sonnerieState;

		}
		return oState;
	}

//	public TelephoneIfc.ETAT getStatus() {
//		return this.status;
//	}
	
	public TelephoneIfc.ETAT getStatus() {

		TelephoneIfc.ETAT state = null;

		if (this instanceof DecrocherState) {
			state = TelephoneIfc.ETAT.DECROCHER;
		} else if (this instanceof EnAppelState) {
			state = TelephoneIfc.ETAT.ENAPPEL;
		} else if (this instanceof EnConversationState) {
			state = TelephoneIfc.ETAT.ENCONVERSATION;
		} else if (this instanceof ReposState) {
			state = TelephoneIfc.ETAT.REPOS;
		} else if (this instanceof SonnerieState) {
			state = TelephoneIfc.ETAT.SONNERIE;
		}

		return state;
	}

}
