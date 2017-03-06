package fr.imie.training.cdi13.dav.appjee.dal.dao;

import fr.imie.training.cdi13.dav.appjee.dal.DALException;
import fr.imie.training.cdi13.dav.appjee.dal.dto.UserDTO;

public interface UserDAO extends DAO<UserDTO> {
	
	public void checkUser(String  login, String password) throws DALException;

}
