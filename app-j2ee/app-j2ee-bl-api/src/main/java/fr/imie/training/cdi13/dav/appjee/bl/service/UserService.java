package fr.imie.training.cdi13.dav.appjee.bl.service;

import java.util.List;

import fr.imie.training.cdi13.dav.appjee.bl.BusinessException;
import fr.imie.training.cdi13.dav.appjee.bl.domain.Role;
import fr.imie.training.cdi13.dav.appjee.bl.domain.User;

public interface UserService extends Service {

	public List<User> findUser() throws BusinessException;

	public User findUser(Integer id) throws BusinessException;

	public User persistUser(User user) throws BusinessException;

	public void checkUser(String login, String password) throws BusinessException;
	
	public List<Role> findRole() throws BusinessException;

}
