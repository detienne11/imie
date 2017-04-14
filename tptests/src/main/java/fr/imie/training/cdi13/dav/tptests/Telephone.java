package fr.imie.training.cdi13.dav.tptests;

public class Telephone {

	private State state = null;
	
	public Telephone() {
		this.state = new ReposState();
	}
	
	public State getState() {		
		return this.state;
	}

	public void setState(TelephoneIfc.ETAT state) {
		this.state = this.state.createState(state);
	}

	public void next(TelephoneIfc.TRANSITION transition){
		this.state = this.state.next(transition);
	}
	
}
