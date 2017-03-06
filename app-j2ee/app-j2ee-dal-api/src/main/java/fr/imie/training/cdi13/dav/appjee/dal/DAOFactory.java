package fr.imie.training.cdi13.dav.appjee.dal;

import fr.imie.training.cdi13.dav.appjee.dal.dao.RoleDAO;
import fr.imie.training.cdi13.dav.appjee.dal.dao.UserDAO;

/**
 * 
 * @author detienne
 * 
 */
public abstract class DAOFactory {

	private static DAOFactory instance = null;

	protected Datasource datasource = null;

	public static enum DAL_TYPE {
		JDBC, CSV
	};

	protected DAOFactory() {

	}

	protected Datasource getDatasource() {
		return this.datasource;
	}

	private void setDatasource(Datasource datasource) {
		this.datasource = datasource;
	}

	protected abstract Datasource initDatasource() throws DALException;

	public final static DAOFactory getInstance() throws DALException {
		return DAOFactory.getInstance(DAL_TYPE.JDBC);
	}

	public final static DAOFactory getInstance(DAL_TYPE dalType) throws DALException {
		String impl = "fr.imie.training.cdi13.dav.appjee.dal.dao.jdbc.JDBCDAOFactory";
		if (dalType == DAL_TYPE.CSV) {
			impl = "fr.imie.training.cdi13.dav.appjee.dal.dao.csv.CSVDAOFactory";
		}
		return DAOFactory.getInstance(impl);
	}

	private final static DAOFactory getInstance(String impl) throws DALException {
		if (DAOFactory.instance == null) {
			try {
				instance = (DAOFactory) Class.forName(impl).newInstance();
				instance.setDatasource(instance.initDatasource());
			} catch (ReflectiveOperationException e) {
				System.err.println("DataAccess Layer : ReflectiveOperationException - getInstance : " + e.getMessage());
				throw new DALException("DAOFactory implementation failed",e);
			}

		}
		return DAOFactory.instance;
	}

	public abstract UserDAO getUserDAO();

	public abstract RoleDAO getRoleDAO();

}
