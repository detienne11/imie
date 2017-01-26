package fr.imie.training.cdi13.dav.jdbc.dal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.imie.training.cdi13.dav.jdbc.dal.DALException;
import fr.imie.training.cdi13.dav.jdbc.dal.Datasource;
import fr.imie.training.cdi13.dav.jdbc.model.DTO;

public interface DAO {

	public static enum DAO_TYPE {
		ETABLISSEMENT, ADMINISTRATEUR
	};

	public void init(Datasource datasource);
	
	public  List<DTO> convertToDTO(ResultSet results) throws SQLException;

	public List<DTO> find() throws DALException;

	public DTO findById(Integer id) throws DALException;

	public DTO create(DTO dto) throws DALException;

	public void update(DTO dto) throws DALException;

	public void delete(DTO dto) throws DALException;

}
