package fr.imie.training.cdi13.dav.jdbc.bl;

import fr.imie.training.cdi13.dav.jdbc.bl.impl.AcademyService;
import fr.imie.training.cdi13.dav.jdbc.dal.DAOFactory;

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

	public Service getService(Service.SERVICE_TYPE serviceType) throws ServiceException {

		Service dao = null;

		if (serviceType == Service.SERVICE_TYPE.ACADEMIE) {
			dao = new AcademyService(DAOFactory.getInstance());
		} else {
			throw new ServiceException("DAO inexistant");
		}

		return dao;
	}
}
