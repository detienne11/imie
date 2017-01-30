package fr.imie.training.cdi13.dav.thread.exo1;

import java.util.List;
import java.util.Random;

public class Counter extends Thread {

	private String nom;

	private long nbMax;

	private List<Counter> terminateList;

	public Counter(String nom, long nbMax, List<Counter> terminateList) {
		super();
		this.nom = nom;
		this.nbMax = nbMax;
		this.terminateList = terminateList;
	}

	public String getNom() {
		return nom;
	}

	private long getNbMax() {
		return nbMax;
	}

	@Override
	public void run() {

		System.out.println(this.getName() + ", nom=" + this.getNom() + " STARTED");

		final Random r = new Random();
		int time;

		while (!isInterrupted()) {
			try {
				for (int i = 1; i <= this.getNbMax(); i++) {
					time = r.nextInt(1000);
					Thread.sleep(time);
					System.out.println(this.getName() + ", nom=" + this.getNom() + ", valeur = " + String.valueOf(i));
				}
				break;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		System.out.println(this.getName() + ", nom=" + this.getNom() + " FINISHED");

		terminateList.add(this);

	}

}
