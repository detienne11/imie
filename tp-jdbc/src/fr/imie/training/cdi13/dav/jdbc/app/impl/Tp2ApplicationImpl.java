package fr.imie.training.cdi13.dav.jdbc.app.impl;

import java.util.HashMap;
import java.util.Map;

import fr.imie.training.cdi13.dav.jdbc.app.Application;
import fr.imie.training.cdi13.dav.jdbc.app.ApplicationException;
import fr.imie.training.cdi13.dav.jdbc.bl.Service;
import fr.imie.training.cdi13.dav.jdbc.dal.Datasource;
import fr.imie.training.cdi13.dav.jdbc.dal.dao.DAO;
import fr.imie.training.cdi13.dav.jdbc.dal.dao.impl.JDBCTPDatasource;
import fr.imie.training.cdi13.dav.jdbc.ui.UserInterface;
import fr.imie.training.cdi13.dav.jdbc.ui.UserInterfaceException;

public class Tp2ApplicationImpl implements Application {

	private String urlConnection;

	public Tp2ApplicationImpl() {
	}

	@Override
	public String getNom() {
		return "TP8";
	}

	@Override
	public void init() throws ApplicationException {
		this.urlConnection = "jdbc:postgresql://10.1.2.72:5432/jdbcfcpe";
	}

	@Override
	public void stop() throws ApplicationException {

	}

	@Override
	public void start() throws ApplicationException {

		// Datasource
		final Datasource ds = new JDBCTPDatasource();
		ds.init(this.urlConnection);

		// DAL : construction des DAOs de l'application
		final Map<DAO.DAO_TYPE, DAO> daoMap = new HashMap<>();
		DAO dao = ApplicationFactory.getInstance().getDAO(DAO.DAO_TYPE.ETABLISSEMENT);
		dao.init(ds);
		daoMap.put(DAO.DAO_TYPE.ETABLISSEMENT, dao);

		// BL : construction des Services de l'application
		final Map<Service.SERVICE_TYPE, Service> serviceMap = new HashMap<>();
		Service service = ApplicationFactory.getInstance().getService(Service.SERVICE_TYPE.ACADEMY);
		service.init(daoMap);
		serviceMap.put(Service.SERVICE_TYPE.ACADEMY, service);

		// UI : construction des IHM de l'appli
		final Map<UserInterface.USER_INTERFACE_TYPE, UserInterface> uiMap = new HashMap<>();
		UserInterface ui = ApplicationFactory.getInstance()
				.getUserInterface(UserInterface.USER_INTERFACE_TYPE.ETABLISSEMENT);
		ui.init(serviceMap);
		uiMap.put(UserInterface.USER_INTERFACE_TYPE.ETABLISSEMENT, ui);

		try {
			ui.execute();
		} catch (UserInterfaceException e) {
			System.err.println("UserInterfaceException : " + e.getMessage());
			throw new ApplicationException(e.getMessage());
		}

	}

}
