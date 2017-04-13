package fr.imie.training.cdi13.dav.tptests;

public class Contexte {

	private State currentState = null;
	
	private State.ACTION_TYPE currentAction = null;
	
	public Contexte() {
		currentState = new ReposState();
	}

	public void next(){
		currentState.next(currentAction);
	}
	
}
