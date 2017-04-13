package fr.imie.training.cdi13.dav;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.imie.training.cdi13.dav.tptests.Client;
import fr.imie.training.cdi13.dav.tptests.ClientN;
import fr.imie.training.cdi13.dav.tptests.ClientP;
import fr.imie.training.cdi13.dav.tptests.ClientS;

public class ClientTest {

	private Client client = null;

//	private String[] stringList = { "N", "P", "S", "M" };
//
//	private float[] commandeList = { -300, -1, 0, 1, 450, 999, 1000, 1001, 3000, 4999, 5000, 5001, 12500 };
//
//	private float[] encoursList = { -450, -1, 0, 1, 450, 999, 1000, 1001, 2054, 2999, 3000, 3001, 5000 };

	private Client createClient(String type,float encours) {
		
		Client client = null;
		
		if ("N".equals(type)) {
			client = new ClientN(encours);
		}
		else if ("P".equals(type)) {
			client = new ClientP(encours);
		}
		else if ("S".equals(type)) {
			client = new ClientS(encours);
		}
		
//		client = new Client(type, encours);
		
		return client;
	}
	
	@Test
	public void testAcceptS() {

		// S : C > 5000
		this.client = this.createClient("S", 1001);
		boolean res = this.client.accept(5001);
		assertFalse(res);

		// S : 1000 < C <= 5000 && e > 1000
		this.client = this.createClient("S", 1001);
		res = this.client.accept(5000);
		assertFalse(res);

		res = this.client.accept(1001);
		assertFalse(res);

		// S : 1000 < C <= 5000 && e <= 1000
		this.client = this.createClient("S", 1000);
		res = this.client.accept(5000);
		assertTrue(res);

		res = this.client.accept(1001);
		assertTrue(res);

		// S : c <= 1000
		this.client = this.createClient("S", 1001);
		res = this.client.accept(1000);
		assertTrue(res);
	}

	@Test
	public void testAcceptP() {

		// P : C > 5000 && E > 3000
		this.client = this.createClient("P", 3001);
		boolean res = this.client.accept(5001);
		assertFalse(res);

		// P : C <= 5000 && E > 3000
		this.client = this.createClient("P", 3001);
		res = this.client.accept(5000);
		assertTrue(res);

		// P : C <= 5000 && E <= 3000
		this.client = this.createClient("P", 3000);
		res = this.client.accept(5000);
		assertTrue(res);
	}

	@Test
	public void testAcceptN() {

		// N : E > 3000 && C > 1000
		this.client = this.createClient("N", 3001);
		boolean res = this.client.accept(1001);
		assertFalse(res);

		// N : E > 3000 && C <= 1000		
		this.client = this.createClient("N", 3001);
		res = this.client.accept(1000);
		assertTrue(res);
		
		// N : 1000 <= E <= 3000 && C > 5000		
		this.client = this.createClient("N", 1000);
		res = this.client.accept(5001);
		assertFalse(res);

		// N : 1000 <= E <= 3000 && C <= 5000
		this.client = this.createClient("N", 1001);
		res = this.client.accept(5000);
		assertTrue(res);

		//N : E < 1000
		this.client = this.createClient("N", 999);
		res = this.client.accept(5001);
		assertTrue(res);

	}

}
