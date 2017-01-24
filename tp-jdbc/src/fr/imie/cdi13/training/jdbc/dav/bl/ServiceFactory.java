package fr.imie.cdi13.training.jdbc.dav.bl;

import fr.imie.cdi13.training.jdbc.dav.bl.impl.ServiceImpl;

public class ServiceFactory {

	private static ServiceFactory instance = null;
	
	private ServiceFactory() {
		
	}
	
	public static ServiceFactory getInstance() {
		if (ServiceFactory.instance == null) {
			ServiceFactory.instance = new ServiceFactory();
		}
		return ServiceFactory.instance;
	}
	
	public Service getService(){
		return new ServiceImpl();
	}
}
