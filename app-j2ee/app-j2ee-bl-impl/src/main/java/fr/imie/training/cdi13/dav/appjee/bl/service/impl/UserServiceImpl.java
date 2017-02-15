package fr.imie.training.cdi13.dav.appjee.bl.service.impl;

import java.util.ArrayList;
import java.util.List;

import fr.imie.training.cdi13.dav.appjee.bl.BusinessException;
import fr.imie.training.cdi13.dav.appjee.bl.domain.BO;
import fr.imie.training.cdi13.dav.appjee.bl.domain.User;
import fr.imie.training.cdi13.dav.appjee.bl.service.UserService;
import fr.imie.training.cdi13.dav.appjee.dal.DALException;
import fr.imie.training.cdi13.dav.appjee.dal.DAOFactory;
import fr.imie.training.cdi13.dav.appjee.dal.dao.UserDAO;
import fr.imie.training.cdi13.dav.appjee.dal.dto.UserDTO;

public class UserServiceImpl implements UserService {

	public UserServiceImpl() {
		super();
	}

	private UserDAO getUserDAO() throws DALException {
		UserDAO dao = null;
		try {
			final DAOFactory daoFactory = DAOFactory.getInstance();
			dao = daoFactory.getUserDAO();

		} catch (DALException e) {
			System.err.println("Business Layer : DALException - getUserDAO : " + e.getMessage());
			throw e;
		}

		return dao;
	}

	@Override
	public List<User> findUser() throws BusinessException {

		List<User> boList = null;
		try {
			final UserDAO dao = this.getUserDAO();
			List<UserDTO> dtoList = dao.find();

			if (dtoList != null) {
				boList = new ArrayList<>();
				for (UserDTO dto : dtoList) {
					final User user = new User();
					user.setFromDTO(dto);
					boList.add(user);
				}
			}

		} catch (DALException e) {
			System.err.println("Business Layer : DALException - findUser : " + e.getMessage());
			throw new BusinessException(e);
		}
		return boList;
	}

	@Override
	public User findUser(Integer id) throws BusinessException {

		User bo = null;
		try {
			final UserDAO dao = this.getUserDAO();
			final UserDTO dto = dao.findById(id);
			bo = new User();
			bo.setFromDTO(dto);
		} catch (DALException e) {
			System.err.println("Business Layer : DALException - findUser : " + e.getMessage());
			throw new BusinessException(e);
		}
		return bo;
	}

	@Override
	public User persistUser(User user, BO.STATE state) throws BusinessException {

		User bo = null;

		try {
			final UserDAO dao = this.getUserDAO();
			UserDTO dto = user.convertToDTO();
			if (state == BO.STATE.TO_INSERT) {
				dto = dao.create(dto);
				bo = new User();
				bo.setFromDTO(dto);
			} else if (state == BO.STATE.TO_UPDATE) {
				dao.update(dto);
				bo = user;
			} else if (state == BO.STATE.TO_REMOVE) {
				dao.delete(dto);
				bo = null;
			} else {
				throw new DALException("BO STATE invalid");
			}

		} catch (DALException e) {
			System.err.println("Business Layer : DALException - persistUser : " + e.getMessage());
			throw new BusinessException(e);
		}
		return bo;
	}

	@Override
	public void checkUser(String login, String password) throws BusinessException {
		
		try {
			final UserDAO dao = this.getUserDAO();
			dao.checkUser(login, password);
		} catch (DALException e) {
			System.err.println("Business Layer : DALException - checkUser : " + e.getMessage());
			throw new BusinessException(e);
		}

	}

}
