package fr.imie.training.cdi13.dav.j2ee;

import fr.imie.training.cdi13.dav.j2ee.bl.Service;
import fr.imie.training.cdi13.dav.j2ee.bl.impl.UserServiceImpl;
import fr.imie.training.cdi13.dav.j2ee.dal.dao.DAO;
import fr.imie.training.cdi13.dav.j2ee.dal.dao.DAO.DAO_TYPE;
import fr.imie.training.cdi13.dav.j2ee.dal.dao.impl.UserDAOImpl;
import fr.imie.training.cdi13.dav.j2ee.model.DTO;
import fr.imie.training.cdi13.dav.j2ee.model.dto.UserDTO;

public class ApplicationFactory {

	private static ApplicationFactory instance = null;

	private ApplicationFactory() {

	}

	public final static ApplicationFactory getInstance() {
		if (ApplicationFactory.instance == null) {
			ApplicationFactory.instance = new ApplicationFactory();
		}
		return ApplicationFactory.instance;
	}

	public DAO<?> getDAO(DAO.DAO_TYPE daoType) throws ApplicationException {

		DAO<?> dao = null;

		if (daoType == DAO_TYPE.USER) {
			dao = new UserDAOImpl();
		} else {
			throw new ApplicationException("DAO inexistant");
		}

		return dao;

	}

	public DAO<?> getDAO(DTO dto) throws ApplicationException {

		DAO<?> dao = null;

		if (dto instanceof UserDTO) {
			dao = this.getDAO(DAO_TYPE.USER);
		} else {
			throw new ApplicationException("DAO inexistant");
		}

		return dao;
	}

	public Service<?> getService(Service.SERVICE_TYPE serviceType) throws ApplicationException {

		Service<?> srv = null;

		if (serviceType == Service.SERVICE_TYPE.USER) {
			srv = new UserServiceImpl();
		} else {
			throw new ApplicationException("Service inexistant");
		}

		return srv;
	}

	// public UserInterface getUserInterface(UserInterface.USER_INTERFACE_TYPE
	// uiType) throws ApplicationException {
	//
	// UserInterface ui = null;
	//
	// if (uiType == UserInterface.USER_INTERFACE_TYPE.U) {
	// ui = new EtablissementUserInterface();
	// } else {
	// throw new ApplicationException("User Interface inexistante");
	// }
	//
	// return ui;
	// }

}
