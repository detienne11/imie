package fr.imie.training.cdi13.dav.tpuml.observer;

import java.util.Observable;

public class Car extends Vehicle {

	public Car(){
		super();
	}
	
	public Car(Observable observable){
		super(observable);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Update Car :" + arg);		
	}
	
}
