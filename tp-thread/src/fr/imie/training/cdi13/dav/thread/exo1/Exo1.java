package fr.imie.training.cdi13.dav.thread.exo1;

import java.util.ArrayList;
import java.util.List;

public class Exo1 {

	public static void main(String[] args) {

		List<Counter> terminateList = new ArrayList<>();

		Thread t1 = new Counter("Compteur 1", 20, terminateList);
		Thread t2 = new Counter("Compteur 2", 10, terminateList);
		Thread t3 = new Counter("Compteur 3", 15, terminateList);
		
		t1.start();
		t2.start();
		t3.start();

		while (t1.isAlive() || t2.isAlive() || t3.isAlive()) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Ordre des FINISH");
		for (Counter counter : terminateList) {
			System.out.println(counter.getNom());
		}
	}

}
