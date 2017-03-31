package fr.imie.training.cdi13.dav.tpuml.observer;

public class Client {

	public static void main(String[] args) {
		
		System.out.println("Observable Pattern : Observable instancie Observer");
		Piste piste = new Piste();
		piste.addObserver(new Moto());
		piste.addObserver(new Car());		
		piste.changeState("Piste mouillée");		
		piste.changeState("Piste sèche");
		
		System.out.println("\nObservable Pattern : Observer instancie Observable");
		Piste piste2 = new Piste();
		new Moto(piste2);		
		new Car(piste2);
		piste2.changeState("Piste mouillée");		
		piste2.changeState("Piste sèche");
		
	}

}
