package fr.imie.training.cdi13.dav.tpinject.exo1;

public class ApplicationTest {

	public static void main(String[] args) {
		// forte dependance avec MonApplicationService
		MonApplicationService app = new MonApplicationService();
		app.processMessages("Hello", "david.etienne@nantes.imie.fr");
	}
	
}
