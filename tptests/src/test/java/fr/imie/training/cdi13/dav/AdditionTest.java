package fr.imie.training.cdi13.dav;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fr.imie.training.cdi13.dav.tptests.Addition;

public class AdditionTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	private Addition addition = null;
	
	@Before
	public void init() {
		Addition addition = null;
	}
	
	@Test
	public void testCalculer() {
		
		assertNull(this.addition);
		
		exception.expect(NullPointerException.class);
		this.addition.calculer(5, 6);
		
		this.addition = new Addition();
		
		long result = this.addition.calculer(5, 6);
		assertEquals(10,result);
		assertTrue(result == 11);
	} 

	@Test
	public void testLireSymbole() {
		fail("Not yet implemented");
	}

}
