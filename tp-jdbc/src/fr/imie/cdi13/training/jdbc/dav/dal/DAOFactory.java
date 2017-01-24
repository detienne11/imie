package fr.imie.cdi13.training.jdbc.dav.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.imie.cdi13.training.jdbc.dav.dal.dao.DAO;
import fr.imie.cdi13.training.jdbc.dav.dal.dao.EtablissementDAO;
import fr.imie.cdi13.training.jdbc.dav.dal.dao.impl.EtablissementDAOImpl;

public class DAOFactory {

	public static enum LISTE_DAO {
		ETABLISSEMENT, ADMINISTRATEUR
	};

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
			if (this.connection == null
					|| this.connection.isClosed()) {

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

	public EtablissementDAO getEtablissementDAO() {
		return new EtablissementDAOImpl(this.getConnection());
	}

	public DAO getDAO(LISTE_DAO daoType) {

		DAO dao = null;

		switch (daoType) {
		case ETABLISSEMENT:
			dao = new EtablissementDAOImpl(this.getConnection());
			break;
		}
		return dao;
	}

}
