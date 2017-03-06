package fr.imie.training.cdi13.dav.appjee.dal.dao.jdbc;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import fr.imie.training.cdi13.dav.appjee.dal.DALException;
import fr.imie.training.cdi13.dav.appjee.dal.DAOFactory;
import fr.imie.training.cdi13.dav.appjee.dal.Datasource;
import fr.imie.training.cdi13.dav.appjee.dal.dao.RoleDAO;
import fr.imie.training.cdi13.dav.appjee.dal.dao.UserDAO;

/**
 * 
 * @author detienne
 *
 */
public class JDBCDAOFactory extends DAOFactory {

	@Override
	protected Datasource initDatasource() throws DALException {

		Properties properties = new Properties();
		try {
//			properties.load(getClass().getResourceAsStream("/jdbc.properties"));
			properties.load(getClass().getClassLoader().getResourceAsStream("jdbc.properties"));
			// properties.load(new FileReader("/jdbc.properties"));

		} catch (IOException e) {
			System.err.println("DataAccess Layer : IOException - initDatasource : " + e.getMessage());
			throw new DALException("File not find : jdbc.properties", e);
		}
		final String driverClass = properties.getProperty("postgresql.driverClass");
		final String url = properties.getProperty("postgresql.url");
		final String user = properties.getProperty("postgresql.user");
		final String password = properties.getProperty("postgresql.password");

		Datasource ds = new JDBCDatasource();
		ds.init(driverClass, url, user, password);
		return ds;
	}

	@Override
	public UserDAO getUserDAO() {
		final UserDAO dao = new UserDAOImpl();
		dao.init(this.getDatasource());
		return dao;
	}

	@Override
	public RoleDAO getRoleDAO() {
		final RoleDAO dao = new RoleDAOImpl();
		dao.init(this.getDatasource());
		return dao;
	}

}
