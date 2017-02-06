package fr.imie.training.cdi13.dav.thread.exo4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Exo4 {

	public static void main(String[] args) {

		final Random r = new Random();
		
		Map<Long, Fork> forkMap = new HashMap<>();

		int nbPerson = 5;

		List<Person> personList = new ArrayList<>();
		for (int i = 1; i < (nbPerson + 1); i++) {
			long id = Long.valueOf(i);
			final List<Fork> forkList = new ArrayList<>();

			for (int j = 0; j < 2; j++) {
				Fork f;
				long idFork = id + j;
				if (idFork > nbPerson) {
					idFork = 1;
				}
				if (!forkMap.containsKey(idFork)) {
					f = new Fork(idFork);
					forkMap.put(idFork, f);
				} else {
					f = forkMap.get(idFork);
				}
				forkList.add(f);
			}
			
			Person p = new Person(id, forkList.get(0), forkList.get(1), r.nextInt(3000), r.nextInt(3000) , r.nextInt(3000) ,Long.valueOf(nbPerson));
			personList.add(p);
		}

		List<Thread> threadList = new ArrayList<>();
		for (Person person : personList) {
			System.out.println(person.toString());
			Thread t = new Thread(person);
			threadList.add(t);
		}		
		for (Thread t : threadList) {
			t.start();
		}

	}

}
