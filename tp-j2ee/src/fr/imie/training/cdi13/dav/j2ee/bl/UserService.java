package fr.imie.training.cdi13.dav.j2ee.bl;

import fr.imie.training.cdi13.dav.j2ee.dal.dao.UserDAO;
import fr.imie.training.cdi13.dav.j2ee.model.dto.UserDTO;

public interface UserService extends Service<UserDTO> {

	public void checkUser(String  login, String password) throws ServiceException;
	
	public UserDAO getDao() throws ServiceException;
	
}
