package fr.imie.training.cdi13.dav.tpinject.exo2.injector;

import fr.imie.training.cdi13.dav.tpinject.exo2.app.Consumer;
import fr.imie.training.cdi13.dav.tpinject.exo2.app.MonApplicationService;
import fr.imie.training.cdi13.dav.tpinject.exo2.service.EmailServiceImpl;

public class EmailServiceInjector implements MessageServiceInjector {

	@Override
	public Consumer getConsumer() {
		Consumer app = new MonApplicationService(new EmailServiceImpl());
		return app;
	}

}
