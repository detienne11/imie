package fr.imie.training.cdi13.dav.appjee.dal.dao.csv;

import fr.imie.training.cdi13.dav.appjee.dal.DAOFactory;
import fr.imie.training.cdi13.dav.appjee.dal.Datasource;
import fr.imie.training.cdi13.dav.appjee.dal.dao.RoleDAO;
import fr.imie.training.cdi13.dav.appjee.dal.dao.UserDAO;

public class CSVDAOFactory extends DAOFactory {

	@Override
	protected Datasource initDatasource() {
		return null;
	}

	@Override
	public UserDAO getUserDAO() {
		return new UserCSVDAOImpl();
	}

	@Override
	public RoleDAO getRoleDAO() {
		return new RoleCSVDAOImpl();
	}

}
