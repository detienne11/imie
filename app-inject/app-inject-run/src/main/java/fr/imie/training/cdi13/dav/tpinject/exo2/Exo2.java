package fr.imie.training.cdi13.dav.tpinject.exo2;

import fr.imie.training.cdi13.dav.tpinject.exo2.app.Consumer;
import fr.imie.training.cdi13.dav.tpinject.exo2.injector.EmailServiceInjector;
import fr.imie.training.cdi13.dav.tpinject.exo2.injector.FBServiceInjector;
import fr.imie.training.cdi13.dav.tpinject.exo2.injector.MessageServiceInjector;
import fr.imie.training.cdi13.dav.tpinject.exo2.injector.SmsServiceInjector;

public class Exo2 {

	public static void main(String[] args) {
		String msg = "Bonjour Toto";
		String email = "toto@imie.com";
		String phone = "0606060606";
		String fb = "pseudo";

		MessageServiceInjector injector = null;
		Consumer app = null;

		// Send email
		injector = new EmailServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, email);

		// Send SMS
		injector = new SmsServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, phone);
		
		// Send via FB
		injector = new FBServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, fb);

	}

}
