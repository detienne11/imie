package fr.imie.training.cdi13.dav.jdbc.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.imie.training.cdi13.dav.jdbc.dal.dao.DAO;
import fr.imie.training.cdi13.dav.jdbc.model.DTO;

public interface Datasource {

	public void init(String urlConnection);
	
	public Connection openConnection() throws SQLException;

	public void closeConnection(Connection connection, Statement stmt, ResultSet resultSet);
	
	public List<DTO> executeQuery(String query,DAO dao) throws SQLException;

}
