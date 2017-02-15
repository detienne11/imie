package fr.imie.training.cdi13.dav.appjee.dal.dao.csv;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.imie.training.cdi13.dav.appjee.dal.DALException;
import fr.imie.training.cdi13.dav.appjee.dal.Datasource;
import fr.imie.training.cdi13.dav.appjee.dal.dao.UserDAO;
import fr.imie.training.cdi13.dav.appjee.dal.dto.UserDTO;

public class UserCSVDAOImpl implements UserDAO {

	@Override
	public void init(Datasource datasource) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UserDTO> convertToDTO(ResultSet results) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> find() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO findById(Integer id) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO create(UserDTO dto) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UserDTO dto) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(UserDTO dto) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public void checkUser(String login, String password) throws DALException {
		// TODO Auto-generated method stub

	}

}
