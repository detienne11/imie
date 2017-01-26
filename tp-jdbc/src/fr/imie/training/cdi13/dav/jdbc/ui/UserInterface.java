package fr.imie.training.cdi13.dav.jdbc.ui;

import java.util.Map;

import fr.imie.training.cdi13.dav.jdbc.bl.Service;
import fr.imie.training.cdi13.dav.jdbc.bl.Service.SERVICE_TYPE;

public interface UserInterface {

	public enum USER_INTERFACE_TYPE {
		ETABLISSEMENT
	};

	public void init(Map<SERVICE_TYPE, Service> serviceMap);

	public void execute() throws UserInterfaceException;

}
