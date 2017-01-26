package fr.imie.training.cdi13.dav.jdbc.dal.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.imie.training.cdi13.dav.jdbc.dal.Datasource;
import fr.imie.training.cdi13.dav.jdbc.dal.dao.DAO;
import fr.imie.training.cdi13.dav.jdbc.model.DTO;

public class JDBCTPDatasource implements Datasource {

	private String urlConnection;

	public JDBCTPDatasource() {
		super();
	}

	@Override
	public void init(String urlConnection) {
		this.urlConnection = urlConnection;
	}

	public final Connection openConnection() throws SQLException {

		return DriverManager.getConnection(this.urlConnection, "postgres", "postgres");
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
	public List<DTO> executeQuery(String query, DAO dao) throws SQLException {

		List<DTO> records = null;
		Connection connection = null;
		Statement stmt = null;
		ResultSet results = null;

		try {
			connection = this.openConnection();
			stmt = connection.createStatement();
			results = stmt.executeQuery(query);
			records = dao.convertToDTO(results);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			this.closeConnection(connection, stmt, results);
		}
		return records;
	}

}