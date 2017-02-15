package fr.imie.training.cdi13.dav.appjee.bl;

import fr.imie.training.cdi13.dav.appjee.bl.service.Service;
import fr.imie.training.cdi13.dav.appjee.bl.service.UserService;

/**
 * 
 * @author detienne
 * 
 */
public class ServiceFactory {

	private static ServiceFactory instance = null;

	private ServiceFactory() {

	}

	public final static ServiceFactory getInstance() throws BusinessException {
		if (ServiceFactory.instance == null) {
			ServiceFactory.instance = new ServiceFactory();
		}
		return ServiceFactory.instance;
	}

	public UserService getUserService()  throws BusinessException {
		UserService service = (UserService) this.getService(Service.SERVICE_TYPE.USER);
		return service;
	}

	private final Service getService(Service.SERVICE_TYPE serviceType) throws BusinessException {
		
		String impl = null;
		
		if (serviceType == Service.SERVICE_TYPE.USER) {			
			impl = "fr.imie.training.cdi13.dav.appjee.bl.service.impl.UserServiceImpl";
		}
		else {
			throw new BusinessException("Business Layer : BusinessException - getService : serviceType invalid" );
		}
		
		Service service = null;
		try {
			service = (UserService) Class.forName(impl).newInstance();
		} catch (ReflectiveOperationException e) {
			System.err.println("Business Layer : ReflectiveOperationException - getService : " + e.getMessage());			
			throw new BusinessException(e);
		}

		return service;
	}

}
