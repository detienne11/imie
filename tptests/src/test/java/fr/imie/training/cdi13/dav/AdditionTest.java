package fr.imie.training.cdi13.dav;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fr.imie.training.cdi13.dav.tptests.Addition;

public class AdditionTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	private Addition addition;
	
	@BeforeClass
	public static void initClass() {
		System.out.println("Chargement de la classe");
	}
	
	@Before
	public void init() {
		System.out.println("Chargement du contexte");
		this.addition = null;
	}
	
	@After
	public void finish() {
		this.addition = null;
		System.out.println("Vidage du contexte");
	}
	
	@AfterClass
	public static void finishClass() {
		System.out.println("Vidage de la classe");
	}
	
	@Test
	public void testCalculer() {
		
		assertNull(this.addition);
//		
//		exception.expect(NullPointerException.class);
//		this.addition.calculer(5, 6);
		
		this.addition = new Addition();
		
		long result = this.addition.calculer(5, 6);
		assertEquals(11,result);
		assertTrue(result == 11);
	} 

	@Test
	public void testLireSymbole() {
		
		this.addition = new Addition();
		String result = this.addition.lireSymbole();
		assertEquals("-",result);
		
	}
	
	@Test(timeout=2000)
	public void testMethod2(){
		this.addition = new Addition();
		this.addition.method2();
	}
	
	@Test
	public void testMethod1(){
		this.addition = new Addition();
		long res = this.addition.method1(5);
		assertEquals(5, res);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMethod1Exception(){
		this.addition = new Addition();
		this.addition.method1(11);
		
//		try {
//			this.addition.method1();
//			fail("IllegalArgumentException attendu");
//		} catch (IllegalArgumentException e) {
//			
//		}
//		fail("IllegalArgumentException attendu");
		
	}


	public void testDateValide(){
		this.addition = new Addition();
		boolean res = this.addition.dateValide(11, 12, 2001);
		assertEquals(true, res);
	}
}
