package fr.imie.training.cdi13.dav.jdbc.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.imie.training.cdi13.dav.jdbc.dal.DAO.DAO_TYPE;
import fr.imie.training.cdi13.dav.jdbc.dal.dao.impl.EtablissementDAOImpl;
import fr.imie.training.cdi13.dav.jdbc.model.DTO;
import fr.imie.training.cdi13.dav.jdbc.model.dto.EtablissementDTO;

public class DAOFactory {

	private static DAOFactory instance = null;

	private Connection connection = null;

	private DAOFactory() {

	}

	private Connection getConnection() {
		return this.connection;
	}

	public final static DAOFactory getInstance() {
		if (DAOFactory.instance == null) {
			DAOFactory.instance = new DAOFactory();
		}
		return DAOFactory.instance;
	}

	public final void openConnection() {
		try {
			if (this.connection == null || this.connection.isClosed()) {

				this.connection = DriverManager.getConnection("jdbc:postgresql://10.1.2.72:5432/jdbcfcpe", "postgres",
						"postgres");

			}
		} catch (SQLException e) {
			this.closeConnection();
			System.err.println("Erreur Connexion DB : " + e.getMessage());
		}
	}

	public final void closeConnection() {
		try {
			if (this.connection != null && !this.connection.isClosed()) {
				this.connection.close();
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public DAO getDAO(DAO_TYPE daoType) throws DALException {

		DAO dao = null;

		if (daoType == DAO_TYPE.ETABLISSEMENT) {
			dao = new EtablissementDAOImpl(this.getConnection());
		} else {
			throw new DALException("DAO inexistant");
		}

		return dao;
	}

	public DAO getDAO(DTO dto) throws DALException {

		DAO dao = null;

		if (dto instanceof EtablissementDTO) {
			dao = this.getDAO(DAO_TYPE.ETABLISSEMENT);
		} else {
			throw new DALException("DAO inexistant");
		}

		return dao;
	}

}
