package fr.imie.training.cdi13.dav.appjee.bl.service;

import java.util.List;

import fr.imie.training.cdi13.dav.appjee.bl.BusinessException;
import fr.imie.training.cdi13.dav.appjee.bl.domain.BO;
import fr.imie.training.cdi13.dav.appjee.bl.domain.User;

public interface UserService extends Service {

	public List<User> findUser() throws BusinessException;

	public User findUser(Integer id) throws BusinessException;

	public User persistUser(User user, BO.STATE state) throws BusinessException;

	public void checkUser(String login, String password) throws BusinessException;

}
