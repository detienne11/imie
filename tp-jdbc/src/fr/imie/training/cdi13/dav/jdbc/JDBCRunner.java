package fr.imie.training.cdi13.dav.jdbc;

import fr.imie.training.cdi13.dav.jdbc.ui.TP0ApplicationImpl;
import fr.imie.training.cdi13.dav.jdbc.ui.Tp1ApplicationImpl;
import fr.imie.training.cdi13.dav.jdbc.ui.Tp2ApplicationImpl;

public class JDBCRunner {

	public static void main(String[] args) {

//		JDBCRunner.runApp(new TP0ApplicationImpl());
//		
//		JDBCRunner.runApp(new Tp1ApplicationImpl());
		
		JDBCRunner.runApp(new Tp2ApplicationImpl());

	}

	public static void runApp(Application app) {

		System.out.println("=====================================================");
		System.out.println("\tApplication : " + app.getNom());
		System.out.println("-----------------------------------------------------");		
		try {
			app.init();
			app.start();
			app.stop();
		} catch (Throwable e) {
			System.err.println("Erreur Application : " + e.getMessage());
		}		
		System.out.println("=====================================================");
	}
}
