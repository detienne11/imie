package fr.imie.training.cdi13.dav.tptests.calcul;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DiagnosticImplTest {

	@Mock
	private Acquisition acq;
	
	@Spy
	@InjectMocks
	private DiagnosticImpl diag;
	
	@Before
	public void init() {

		Mockito.when(acq.lirePression(Integer.valueOf(0))).thenReturn(Float.valueOf(5.5f));
		Mockito.when(acq.lirePression(Integer.valueOf(1))).thenReturn(Float.valueOf(5.4f));
		Mockito.when(acq.lirePression(Integer.valueOf(2))).thenReturn(Float.valueOf(5.6f));
		
	}
	
	@Test
	public void test() {
		
		diag.setNbBuses(Integer.valueOf(3));
		diag.acquerir(Float.valueOf(5.5f));
		
		assertEquals(Float.valueOf(5.5f), diag.buseList.get(0).getPression());
		assertEquals(Float.valueOf(5.4f), diag.buseList.get(1).getPression());
		assertEquals(Float.valueOf(5.6f), diag.buseList.get(2).getPression());
	}
	
	@Test
	public void test2() {
		
		diag.setNbBuses(Integer.valueOf(3));
		diag.acquerir(Float.valueOf(5.5f));
		
		assertEquals(true,diag.state);
		
	}

}
