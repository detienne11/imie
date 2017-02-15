package fr.imie.training.cdi13.dav.appjee.dal.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.imie.training.cdi13.dav.appjee.dal.DALException;
import fr.imie.training.cdi13.dav.appjee.dal.Datasource;
import fr.imie.training.cdi13.dav.appjee.dal.dao.RoleDAO;
import fr.imie.training.cdi13.dav.appjee.dal.dto.RoleDTO;

public class RoleDAOImpl implements RoleDAO {

	@Override
	public void init(Datasource datasource) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<RoleDTO> convertToDTO(ResultSet results) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleDTO> find() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleDTO findById(Integer id) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleDTO create(RoleDTO dto) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(RoleDTO dto) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(RoleDTO dto) throws DALException {
		// TODO Auto-generated method stub

	}

}
