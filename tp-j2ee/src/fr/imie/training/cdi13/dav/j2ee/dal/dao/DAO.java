package fr.imie.training.cdi13.dav.j2ee.dal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.imie.training.cdi13.dav.j2ee.dal.DALException;
import fr.imie.training.cdi13.dav.j2ee.dal.Datasource;

public interface DAO<T> {

	public static enum DAO_TYPE {
		USER
	};

	public void init(Datasource datasource);

	public List<T> convertToDTO(ResultSet results) throws SQLException;

	public List<T> find() throws DALException;

	public T findById(Integer id) throws DALException;

	public T create(T dto) throws DALException;

	public void update(T dto) throws DALException;

	public void delete(T dto) throws DALException;

}
