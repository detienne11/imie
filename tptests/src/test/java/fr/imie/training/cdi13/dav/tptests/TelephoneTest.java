package fr.imie.training.cdi13.dav.tptests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TelephoneTest {

	private Telephone phone = null;
	
	private static int count = 0;

	private TelephoneIfc.TRANSITION[] transitionList = TelephoneIfc.TRANSITION.values();

	@BeforeClass
	public static void init2() {
		count = 0;
	}
	
	@Before
	public void init() {

	}

	@Test
	public void testRepos() {

		System.out.println("===================== Repos =====================");
		
		// REPOS appel_entrant SONNERIE
		// REPOS decrocher DECROCHER
		// REPOS raccrocher REPOS
		// REPOS numeroter REPOS
		// REPOS decrocher INT REPOS
		// REPOS raccrocher INT REPOS
		// REPOS timeout REPOS

		for (TelephoneIfc.TRANSITION transition : this.transitionList) {

			this.phone = new Telephone();
			System.out.println("Cas " + ++count + ": " + this.phone.getState().getStatus());			
			this.phone.next(transition);
			TelephoneIfc.ETAT state = this.phone.getState().getStatus();
			System.out.println("Transition : " + transition + ", Etat: " + state);

			if (transition == TelephoneIfc.TRANSITION.APPEL_ENTRANT) {
				assertEquals(TelephoneIfc.ETAT.SONNERIE, state);
			} else if (transition == TelephoneIfc.TRANSITION.DECROCHER) {
				assertEquals(TelephoneIfc.ETAT.DECROCHER, state);
			} else {
				assertEquals(TelephoneIfc.ETAT.REPOS, state);
			}
		}
	}

	@Test
	public void testSonnerie() {

		System.out.println("===================== Sonnerie =====================");
		
		// SONNERIE appel_entrant SONNERIE
		// SONNERIE decrocher ENCONVERSATION
		// SONNERIE raccrocher SONNERIE
		// SONNERIE numeroter SONNERIE
		// SONNERIE decrocher INT SONNERIE
		// SONNERIE raccrocher INT SONNERIE
		// SONNERIE timeout REPOS

		for (TelephoneIfc.TRANSITION transition : this.transitionList) {

			this.phone = new Telephone();
			this.phone.setState(TelephoneIfc.ETAT.SONNERIE);
			
			System.out.println("Cas " + ++count + ": " + this.phone.getState().getStatus());			
			this.phone.next(transition);
			TelephoneIfc.ETAT state = this.phone.getState().getStatus();
			System.out.println("Transition : " + transition + ", Etat: " + state);
			
			if (transition == TelephoneIfc.TRANSITION.DECROCHER) {
				assertEquals(TelephoneIfc.ETAT.ENCONVERSATION, state);
			} else if (transition == TelephoneIfc.TRANSITION.TIMEOUT) {
				assertEquals(TelephoneIfc.ETAT.REPOS, state);
			} else {
				assertEquals(TelephoneIfc.ETAT.SONNERIE, state);
			}
		}
	}

	@Test
	public void testDecrocher() {

		System.out.println("===================== Decrocher =====================");
		
		// DECROCHER appel_entrant DECROCHER
		// DECROCHER decrocher DECROCHER
		// DECROCHER raccrocher REPOS
		// DECROCHER numeroter ENAPPEL
		// DECROCHER decrocher INT DECROCHER
		// DECROCHER raccrocher INT DECROCHER
		// DECROCHER timeout DECROCHER

		for (TelephoneIfc.TRANSITION transition : this.transitionList) {

			this.phone = new Telephone();
			this.phone.setState(TelephoneIfc.ETAT.DECROCHER);
			
			System.out.println("Cas " + ++count + ": " + this.phone.getState().getStatus());			
			this.phone.next(transition);
			TelephoneIfc.ETAT state = this.phone.getState().getStatus();
			System.out.println("Transition : " + transition + ", Etat: " + state);

			if (transition == TelephoneIfc.TRANSITION.RACCROCHER) {
				assertEquals(TelephoneIfc.ETAT.REPOS, state);
			} else if (transition == TelephoneIfc.TRANSITION.NUMEROTER) {
				assertEquals(TelephoneIfc.ETAT.ENAPPEL, state);
			} else {
				assertEquals(TelephoneIfc.ETAT.DECROCHER, state);
			}
		}
	}

	@Test
	public void testEnAppel() {

		System.out.println("===================== En Appel =====================");
		
		// ENAPPEL appel_entrant ENAPPEL
		// ENAPPEL decrocher ENAPPEL
		// ENAPPEL raccrocher REPOS
		// ENAPPEL numeroter ENAPPEL
		// ENAPPEL decrocher INT ENCONVERSATION
		// ENAPPEL raccrocher INT ENAPPEL
		// ENAPPEL timeout DECROCHER

		for (TelephoneIfc.TRANSITION transition : this.transitionList) {

			this.phone = new Telephone();
			this.phone.setState(TelephoneIfc.ETAT.ENAPPEL);
			
			System.out.println("Cas " + ++count + ": " + this.phone.getState().getStatus());			
			this.phone.next(transition);
			TelephoneIfc.ETAT state = this.phone.getState().getStatus();
			System.out.println("Transition : " + transition + ", Etat: " + state);
			
			if (transition == TelephoneIfc.TRANSITION.RACCROCHER) {
				assertEquals(TelephoneIfc.ETAT.REPOS, state);
			} else if (transition == TelephoneIfc.TRANSITION.DECROCHER_INT) {
				assertEquals(TelephoneIfc.ETAT.ENCONVERSATION, state);
			} else if (transition == TelephoneIfc.TRANSITION.TIMEOUT) {
				assertEquals(TelephoneIfc.ETAT.DECROCHER, state);
			} else {
				assertEquals(TelephoneIfc.ETAT.ENAPPEL, state);
			}
		}

	}

	@Test
	public void testEnConversation() {

		System.out.println("===================== En Conversation =====================");
		
		// ENCONVERSATION appel_entrant ENCONVERSATION
		// ENCONVERSATION decrocher ENCONVERSATION
		// ENCONVERSATION raccrocher REPOS
		// ENCONVERSATION numeroter ENCONVERSATION
		// ENCONVERSATION decrocher INT ENCONVERSATION
		// ENCONVERSATION raccrocher INT DECROCHER
		// ENCONVERSATION timeout ENCONVERSATION		

		for (TelephoneIfc.TRANSITION transition : this.transitionList) {
			
			this.phone = new Telephone();
			this.phone.setState(TelephoneIfc.ETAT.ENCONVERSATION);
			
			System.out.println("Cas " + ++count + ": " + this.phone.getState().getStatus());			
			this.phone.next(transition);
			TelephoneIfc.ETAT state = this.phone.getState().getStatus();
			System.out.println("Transition : " + transition + ", Etat: " + state);

			if (transition == TelephoneIfc.TRANSITION.RACCROCHER) {
				assertEquals(TelephoneIfc.ETAT.REPOS, state);
			} else if (transition == TelephoneIfc.TRANSITION.RACCROCHER_INT) {
				assertEquals(TelephoneIfc.ETAT.DECROCHER, state);
			} else {
				assertEquals(TelephoneIfc.ETAT.ENCONVERSATION, state);
			}
		}
	}

}
