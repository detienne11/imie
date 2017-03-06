package fr.imie.training.cdi13.dav.appjee.dal.dao.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.imie.training.cdi13.dav.appjee.dal.DALException;
import fr.imie.training.cdi13.dav.appjee.dal.Datasource;
import fr.imie.training.cdi13.dav.appjee.dal.dao.DAO;

public class JDBCDatasource implements Datasource {

	private String urlConnection;

	private String user;

	private String password;

	public JDBCDatasource() {
		super();
	}

	@Override
	public void init(String driverClass, String urlConnection, String user, String password) throws DALException {

		this.urlConnection = urlConnection;
		this.user = user;
		this.password = password;

		try {
			Driver driver = (Driver) Class.forName(driverClass).newInstance();
			DriverManager.registerDriver(driver);
		} catch (Exception e) {
			System.err.println("DAL method openConnection : Erreur ReflectiveOperationException : " + e.getMessage());
			throw new DALException(e);
		}

	}

	public String getUrlConnection() {
		return urlConnection;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public final Connection openConnection() throws SQLException {

		return DriverManager.getConnection(this.getUrlConnection(), this.getUser(), this.getPassword());
	}

	public final void closeConnection(Connection connection, Statement stmt, ResultSet resultSet) {

		try {
			if (resultSet != null && !resultSet.isClosed()) {
				resultSet.close();
			}
			if (stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}

	@Override
	public PreparedStatement prepareStatement(String query, int arg1) throws DALException {
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = this.openConnection();
			stmt = connection.prepareStatement(query, arg1);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			this.closeConnection(connection, stmt, null);
			throw new DALException(e);
		}

		return stmt;
	}

	@Override
	public PreparedStatement prepareStatement(String query) throws DALException {
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = this.openConnection();
			stmt = connection.prepareStatement(query);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			this.closeConnection(connection, stmt, null);
			throw new DALException(e);
		}

		return stmt;
	}

	// @Override
	// public List<DTO> executeQuery(String query, DAO dao) throws SQLException
	// {
	//
	// List<DTO> records = null;
	// Connection connection = null;
	// Statement stmt = null;
	// ResultSet results = null;
	//
	// try {
	// connection = this.openConnection();
	// stmt = connection.prepareStatement(query);
	// results = stmt.executeQuery(query);
	// records = dao.convertToDTO(results);
	// } catch (SQLException e) {
	// System.err.println(e.getMessage());
	// this.closeConnection(connection, stmt, results);
	// } finally {
	//
	// }
	// return records;
	// }

	@Override
	public List<?> executeQuery(PreparedStatement stmt, DAO<?> dao) throws DALException {

		List<?> records = null;
		Connection connection = null;
		ResultSet results = null;

		try {
			connection = stmt.getConnection();
			results = stmt.executeQuery();
			records = dao.convertToDTO(results);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DALException(e);
		} finally {
			this.closeConnection(connection, stmt, results);
		}
		return records;
	}

	@Override
	public int executeUpdate(PreparedStatement stmt) throws DALException {

		int results = 0;
		Connection connection = null;

		try {
			connection = stmt.getConnection();
			results = stmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DALException(e);
		} finally {
			this.closeConnection(connection, stmt, null);
		}
		return results;

	}

	@Override
	public Integer executeCreate(PreparedStatement stmt) throws DALException {

		Integer id = null;
		Connection connection = null;
		ResultSet resultSet = null;

		try {
			connection = stmt.getConnection();
			int results = stmt.executeUpdate();

			resultSet = stmt.getGeneratedKeys();
			if (resultSet.next()) {
				id = Integer.valueOf(resultSet.getInt("id"));
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DALException(e);
		} finally {
			this.closeConnection(connection, stmt, resultSet);
		}
		return id;
	}

}