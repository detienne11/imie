package fr.imie.training.cdi13.dav.jdbc;

import fr.imie.training.cdi13.dav.jdbc.app.Application;

public class JDBCRunner {

	public static void main(String[] args) {

		// JDBCRunner.runApp(new TP0ApplicationImpl());
		//
		// JDBCRunner.runApp(new Tp1ApplicationImpl());

		try {
			Application app = (Application) Class.forName("fr.imie.training.cdi13.dav.jdbc.app.impl.Tp2ApplicationImpl")
					.newInstance();
			JDBCRunner.runApp(app);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.err.println("Erreur Load Application : " + e.getMessage());
		}

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
