package fr.imie.training.cdi13.dav.jdbc.bl;

import fr.imie.training.cdi13.dav.jdbc.dal.DAOFactory;

/**
 * 
 * @author detienne
 * @deprecated
 */
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

		Service srv = null;

		if (serviceType == Service.SERVICE_TYPE.ACADEMY) {
//			dao = new AcademyService(DAOFactory.getInstance());
			try {				
				srv = (Service) Class.forName("fr.imie.training.cdi13.dav.jdbc.bl.impl.AcademyService").newInstance();
//				srv.init(DAOFactory.getInstance());
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				throw new ServiceException("Service implementation inexistante");
			}
		} else {
			throw new ServiceException("Service inexistant");
		}

		return srv;
	}
}
