package fr.imie.training.cdi13.dav.appjee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.imie.training.cdi13.dav.appjee.dal.dao.DAO;
import fr.imie.training.cdi13.dav.appjee.dal.dto.DTO;

public interface Datasource {

	public void init(String driverClass,String urlConnection,String user,String password) throws DALException;

	public Connection openConnection() throws SQLException;

	public void closeConnection(Connection connection, Statement stmt, ResultSet resultSet);

	public PreparedStatement prepareStatement(String query) throws DALException;
	
	public PreparedStatement prepareStatement(String query,int arg1) throws DALException;

	// public List<DTO> executeQuery(String query, DAO dao) throws SQLException;

	public List<?> executeQuery(PreparedStatement stmt, DAO<?> dao) throws DALException;

	public Integer executeCreate(PreparedStatement stmt) throws DALException;
	
	public int executeUpdate(PreparedStatement stmt) throws DALException;
	
	

}
