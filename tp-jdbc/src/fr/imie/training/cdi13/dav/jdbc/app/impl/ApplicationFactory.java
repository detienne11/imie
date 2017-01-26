package fr.imie.training.cdi13.dav.jdbc.app.impl;

import fr.imie.training.cdi13.dav.jdbc.app.ApplicationException;
import fr.imie.training.cdi13.dav.jdbc.bl.Service;
import fr.imie.training.cdi13.dav.jdbc.bl.impl.AcademyProxyService;
import fr.imie.training.cdi13.dav.jdbc.dal.dao.DAO;
import fr.imie.training.cdi13.dav.jdbc.dal.dao.DAO.DAO_TYPE;
import fr.imie.training.cdi13.dav.jdbc.dal.dao.impl.EtablissementDAOImpl;
import fr.imie.training.cdi13.dav.jdbc.model.DTO;
import fr.imie.training.cdi13.dav.jdbc.model.dto.EtablissementDTO;
import fr.imie.training.cdi13.dav.jdbc.ui.UserInterface;
import fr.imie.training.cdi13.dav.jdbc.ui.impl.EtablissementUserInterface;

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

	public DAO getDAO(DAO.DAO_TYPE daoType) throws ApplicationException {

		DAO dao = null;

		if (daoType == DAO_TYPE.ETABLISSEMENT) {
			dao = new EtablissementDAOImpl();
		} else {
			throw new ApplicationException("DAO inexistant");
		}

		return dao;

	}

	public DAO getDAO(DTO dto) throws ApplicationException {

		DAO dao = null;

		if (dto instanceof EtablissementDTO) {
			dao = this.getDAO(DAO_TYPE.ETABLISSEMENT);
		} else {
			throw new ApplicationException("DAO inexistant");
		}

		return dao;
	}

	public Service getService(Service.SERVICE_TYPE serviceType) throws ApplicationException {

		Service srv = null;

		if (serviceType == Service.SERVICE_TYPE.ACADEMY) {
			srv = new AcademyProxyService();
		} else {
			throw new ApplicationException("Service inexistant");
		}

		return srv;
	}

	public UserInterface getUserInterface(UserInterface.USER_INTERFACE_TYPE uiType) throws ApplicationException {

		UserInterface ui = null;

		if (uiType == UserInterface.USER_INTERFACE_TYPE.ETABLISSEMENT) {
			ui = new EtablissementUserInterface();
		} else {
			throw new ApplicationException("User Interface inexistante");
		}

		return ui;
	}

}
