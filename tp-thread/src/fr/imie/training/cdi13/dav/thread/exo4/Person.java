package fr.imie.training.cdi13.dav.thread.exo4;

import java.util.Random;

public class Person implements Runnable {

	private long id;

	private Fork fork1;

	private Fork fork2;

	private long timeThinking;

	private long timeWaiting;

	private long timeEating;
	
	private Long nbPersonLaunch;
	
	private static long countPerson;

	private enum PERSON_STATE {
		INIT, THINK, HUNGRY, EAT
	};

	public PERSON_STATE state;

	public Person(long id, Fork fork1, Fork fork2, long timeThinking, long timeWaiting, long timeEating,Long nbPersonLaunch) {
		super();
		this.id = id;
		this.fork1 = fork1;
		this.fork2 = fork2;
		this.timeThinking = timeThinking;
		this.timeWaiting = timeWaiting;
		this.timeEating = timeEating;
		this.state = PERSON_STATE.INIT;
		this.nbPersonLaunch = nbPersonLaunch;
	}

	@Override
	public void run() {
		System.out.println("PERSON " + this.id + " START LAUNCH...");
		try {
			while (this.state != PERSON_STATE.EAT) {
				this.nextState();
			}
		} catch (InterruptedException e) {

		}
		System.out.println("PERSON " + this.id + "STOP LAUNCH ");
	}

	private synchronized void nextState() throws InterruptedException {
		switch (this.state) {
		case INIT:
			Person.countPerson++;
			if (Person.countPerson < this.nbPersonLaunch){
				Thread.sleep(100);
			}else {
				this.think();
			}
			break;
		case THINK:
			this.hungry();
			break;
		case HUNGRY:
			boolean fork1Free = fork1.isFree();
			boolean fork2Free = fork2.isFree();
			if (fork1Free && fork2Free) {
				this.eat();								
			} else {				
				if (!fork1Free) {
					System.err.println("FORK USE "  + this.fork1.toString());
				}
				if (!fork2Free) {
					System.err.println("FORK USE "  + this.fork2.toString());
				}
				this.hungry();
			}
			break;
		case EAT:
			System.out.println("PERSON " + this.id + " : GoodBye");
			break;

		default:
			this.think();
			break;
		}
	}
	
	private synchronized void think() throws InterruptedException {
		this.state = PERSON_STATE.THINK;
		final Random r = new Random();

		long time = this.timeThinking;

		System.out.println("PERSON " + this.id + ": Thinking ... " + String.valueOf(time) + " ms");
		Thread.sleep(time);
		System.out.println("PERSON " + this.id + ": STOP Thinking");
	}

	private synchronized void hungry() throws InterruptedException {
		this.state = PERSON_STATE.HUNGRY;
		long time = this.timeWaiting;
		System.out.println("PERSON " + this.id + ": Waiting for launch ... " + String.valueOf(time) + " ms");
		Thread.sleep(time);
		System.out.println("PERSON " + this.id + ": STOP Waiting");
	}

	private synchronized void eat() throws InterruptedException {
		this.state = PERSON_STATE.EAT;
		long time = this.timeEating;
		System.out.println("PERSON " + this.id + ": Eating ... " + String.valueOf(time) + " ms");
		fork1.using();
		fork2.using();		
		Thread.sleep(time);
		fork1.setFree();
		fork2.setFree();
		System.out.println("PERSON " + this.id + ": STOP Eating");
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("Person ");
		str.append(this.id);
		str.append(" state ");
		str.append(this.state);
		str.append(", ");
		str.append(this.fork1.toString());
		str.append(", Fork2 :");
		str.append(this.fork2.toString());
		str.append("\n");
		return str.toString();
	}

}
