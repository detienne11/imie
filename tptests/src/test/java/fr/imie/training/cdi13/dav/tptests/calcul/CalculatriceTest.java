package fr.imie.training.cdi13.dav.tptests.calcul;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculatriceTest {

	@Mock
	private Engine engineMock;
	
	@Spy
	@InjectMocks
	private CalculatriceImpl calculatrice;
	
	@Before
	public void init() {
//		Engine engineMock = Mockito.mock(Engine.class);
		Mockito.when(engineMock.setCharacter("1")).thenReturn(Boolean.TRUE);
		Mockito.when(engineMock.setCharacter("2")).thenReturn(Boolean.TRUE);
		Mockito.when(engineMock.setCharacter("E")).thenReturn(Boolean.FALSE);		
		Mockito.when(engineMock.getDisplay()).thenReturn("1").thenReturn("12").thenReturn("ERREUR");
		
//		CalculatriceImpl calculatrice = Mockito.spy(CalculatriceImpl.class);
//		calculatrice.setEngine(engineMock);
	}
	
	@Test
	public void testScenario1() {

		Mockito.when(engineMock.getDisplay()).thenReturn("1").thenReturn("ERREUR");
		
		Boolean res = calculatrice.appuiTouche("1");
		assertEquals(Boolean.TRUE, res);
		Mockito.verify(engineMock, Mockito.times(1)).setCharacter(Mockito.anyString());
		assertEquals("1", calculatrice.lire());
		Mockito.verify(engineMock, Mockito.times(1)).getDisplay();

		res = calculatrice.appuiTouche("E");
		assertEquals(Boolean.FALSE, res);
		Mockito.verify(engineMock, Mockito.times(2)).setCharacter(Mockito.anyString());
		assertEquals("ERREUR", calculatrice.lire());
		Mockito.verify(engineMock, Mockito.times(1)).getDisplay();

		res = calculatrice.appuiTouche("1");
		assertEquals(Boolean.FALSE, res);
		Mockito.verify(engineMock, Mockito.times(2)).setCharacter(Mockito.anyString());
		assertEquals("ERREUR", calculatrice.lire());
		Mockito.verify(engineMock, Mockito.times(1)).getDisplay();

		res = calculatrice.appuiTouche("2");
		assertEquals(Boolean.FALSE, res);
		Mockito.verify(engineMock, Mockito.times(2)).setCharacter(Mockito.anyString());
		assertEquals("ERREUR", calculatrice.lire());
		Mockito.verify(engineMock, Mockito.times(1)).getDisplay();

	}

	@Test
	public void testScenario2() {

		Boolean res = calculatrice.appuiTouche("1");
		assertEquals(Boolean.TRUE, res);
		Mockito.verify(engineMock, Mockito.times(1)).setCharacter(Mockito.anyString());
		assertEquals("1", calculatrice.lire());
		Mockito.verify(engineMock, Mockito.times(1)).getDisplay();

		res = calculatrice.appuiTouche("2");
		assertEquals(Boolean.TRUE, res);
		Mockito.verify(engineMock, Mockito.times(2)).setCharacter(Mockito.anyString());
		assertEquals("12", calculatrice.lire());
		Mockito.verify(engineMock, Mockito.times(2)).getDisplay();

		res = calculatrice.appuiTouche("E");
		assertEquals(Boolean.FALSE, res);
		Mockito.verify(engineMock, Mockito.times(3)).setCharacter(Mockito.anyString());
		assertEquals("ERREUR", calculatrice.lire());
		Mockito.verify(engineMock, Mockito.times(2)).getDisplay();

		res = calculatrice.appuiTouche("1");
		assertEquals(Boolean.FALSE, res);
		Mockito.verify(engineMock, Mockito.times(3)).setCharacter(Mockito.anyString());
		assertEquals("ERREUR", calculatrice.lire());
		Mockito.verify(engineMock, Mockito.times(2)).getDisplay();

		res = calculatrice.appuiTouche("2");
		assertEquals(Boolean.FALSE, res);
		Mockito.verify(engineMock, Mockito.times(3)).setCharacter(Mockito.anyString());
		assertEquals("ERREUR", calculatrice.lire());
		Mockito.verify(engineMock, Mockito.times(2)).getDisplay();
	}

	@Test
	public void testScenario3() {

		Boolean res = calculatrice.appuiTouche("1");
		assertEquals(Boolean.TRUE, res);
		Mockito.verify(engineMock, Mockito.times(1)).setCharacter(Mockito.anyString());
		assertEquals("1", calculatrice.lire());
		Mockito.verify(engineMock, Mockito.times(1)).getDisplay();

		res = calculatrice.appuiTouche("2");
		assertEquals(Boolean.TRUE, res);
		Mockito.verify(engineMock, Mockito.times(2)).setCharacter(Mockito.anyString());
		assertEquals("12", calculatrice.lire());
		Mockito.verify(engineMock, Mockito.times(2)).getDisplay();

		res = calculatrice.appuiTouche("E");
		assertEquals(Boolean.FALSE, res);
		Mockito.verify(engineMock, Mockito.times(3)).setCharacter(Mockito.anyString());
		assertEquals("ERREUR", calculatrice.lire());
		Mockito.verify(engineMock, Mockito.times(2)).getDisplay();

		res = calculatrice.appuiTouche("1");
		assertEquals(Boolean.FALSE, res);
		Mockito.verify(engineMock, Mockito.times(3)).setCharacter(Mockito.anyString());
		assertEquals("ERREUR", calculatrice.lire());
		Mockito.verify(engineMock, Mockito.times(2)).getDisplay();

		res = calculatrice.appuiTouche("2");
		assertEquals(Boolean.FALSE, res);
		Mockito.verify(engineMock, Mockito.times(3)).setCharacter(Mockito.anyString());
		assertEquals("ERREUR", calculatrice.lire());
		Mockito.verify(engineMock, Mockito.times(2)).getDisplay();

		calculatrice.reset();
				
		Mockito.when(engineMock.getDisplay()).thenReturn("1").thenReturn("12").thenReturn("ERREUR");

		res = calculatrice.appuiTouche("1");
		assertEquals(Boolean.TRUE, res);
		Mockito.verify(engineMock, Mockito.times(4)).setCharacter(Mockito.anyString());
		assertEquals("1", calculatrice.lire());
		Mockito.verify(engineMock, Mockito.times(3)).getDisplay();

		res = calculatrice.appuiTouche("2");
		assertEquals(Boolean.TRUE, res);
		Mockito.verify(engineMock, Mockito.times(5)).setCharacter(Mockito.anyString());
		assertEquals("12", calculatrice.lire());
		Mockito.verify(engineMock, Mockito.times(4)).getDisplay();

		res = calculatrice.appuiTouche("E");
		assertEquals(Boolean.FALSE, res);
		Mockito.verify(engineMock, Mockito.times(6)).setCharacter(Mockito.anyString());
		assertEquals("ERREUR", calculatrice.lire());
		Mockito.verify(engineMock, Mockito.times(4)).getDisplay();

		res = calculatrice.appuiTouche("1");
		assertEquals(Boolean.FALSE, res);
		Mockito.verify(engineMock, Mockito.times(6)).setCharacter(Mockito.anyString());
		assertEquals("ERREUR", calculatrice.lire());
		Mockito.verify(engineMock, Mockito.times(4)).getDisplay();

		res = calculatrice.appuiTouche("2");
		assertEquals(Boolean.FALSE, res);
		Mockito.verify(engineMock, Mockito.times(6)).setCharacter(Mockito.anyString());
		assertEquals("ERREUR", calculatrice.lire());
		Mockito.verify(engineMock, Mockito.times(4)).getDisplay();

	}

}
