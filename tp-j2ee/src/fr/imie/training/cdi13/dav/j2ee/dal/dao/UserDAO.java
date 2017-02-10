package fr.imie.training.cdi13.dav.j2ee.dal.dao;

import fr.imie.training.cdi13.dav.j2ee.dal.DALException;
import fr.imie.training.cdi13.dav.j2ee.model.dto.UserDTO;

public interface UserDAO extends DAO<UserDTO> {
	
	public void checkUser(String  login, String password) throws DALException;

}
