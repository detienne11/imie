package fr.imie.training.cdi13.dav.tpuml.observer;

import java.util.Observable;
import java.util.Observer;

public abstract class Vehicle implements Observer {
	
	public Vehicle(){}
	
	public Vehicle(Observable observable){
		observable.addObserver(this);
	}
	
	public abstract void update(Observable o, Object arg);
	

}
