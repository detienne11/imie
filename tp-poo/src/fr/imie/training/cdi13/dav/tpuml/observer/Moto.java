package fr.imie.training.cdi13.dav.tpuml.observer;

import java.util.Observable;

public class Moto extends Vehicle {

	public Moto(){
		super();
	}
	
	public Moto(Observable observable){
		super(observable);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Update Moto :" + arg);
	}

}
