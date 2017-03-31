package fr.imie.training.cdi13.dav.tpuml.observer;

import java.util.Observable;

public class Piste extends Observable {

	public void changeState(String state){
		String str = "Piste Change State=" + state;
		System.out.println(str);
		this.setChanged();
		this.notifyObservers(state);
	}
	
}
