package fr.imie.training.cdi13.dav.j2ee.bl.impl;

import java.util.List;
import java.util.Map;

import fr.imie.training.cdi13.dav.j2ee.bl.ServiceException;
import fr.imie.training.cdi13.dav.j2ee.bl.UserService;
import fr.imie.training.cdi13.dav.j2ee.dal.DALException;
import fr.imie.training.cdi13.dav.j2ee.dal.dao.DAO;
import fr.imie.training.cdi13.dav.j2ee.dal.dao.DAO.DAO_TYPE;
import fr.imie.training.cdi13.dav.j2ee.dal.dao.UserDAO;
import fr.imie.training.cdi13.dav.j2ee.model.dto.UserDTO;

public class UserServiceImpl implements UserService {

	private Map<DAO.DAO_TYPE, DAO<?>> daoMap;

	public UserServiceImpl() {
		super();
	}

	@Override
	public void init(Map<DAO_TYPE, DAO<?>> daoMap) {
		this.daoMap = daoMap;
	}

	@Override
	public UserDAO getDao() throws ServiceException {
		final UserDAO dao = (UserDAO) this.getDao(DAO.DAO_TYPE.USER);
		return dao;
	}

	private final DAO<?> getDao(DAO.DAO_TYPE daoType) throws ServiceException {
		DAO<?> dao = null;
		try {
			dao = this.daoMap.get(daoType);
		} catch (Exception e) {
			System.err.println("Business method getDao : Erreur Exception : " + e.getMessage());
			throw new ServiceException("DAO inexistant :" + e.getMessage());
		}
		return dao;
	}

	// private final DAO<UserDTO> getDao(UserDTO dto) throws ServiceException {
	//
	// DAO<UserDTO> dao = null;
	//
	// if (dto instanceof UserDTO) {
	// dao = (DAO<UserDTO>) this.getDao(DAO.DAO_TYPE.USER);
	// }
	//
	// return dao;
	// }

	@Override
	public List<UserDTO> find() throws ServiceException {
		final UserDAO dao = this.getDao();
		final List<UserDTO> liste;
		try {
			liste = dao.find();
		} catch (DALException e) {
			System.err.println("Business method find : Erreur DALException : " + e.getMessage());
			throw new ServiceException(e.getMessage());
		}
		return liste;
	}

	@Override
	public UserDTO findById(Integer id) throws ServiceException {
		final UserDAO dao = this.getDao();
		UserDTO dto;
		try {
			dto = dao.findById(id);
		} catch (DALException e) {
			System.err.println("Business method findById : Erreur DALException : " + e.getMessage());
			throw new ServiceException(e.getMessage());
		}
		return dto;
	}

	@Override
	public UserDTO create(UserDTO dto) throws ServiceException {
		final UserDAO dao = this.getDao();
		final UserDTO newdto;
		try {
			newdto = dao.create(dto);
		} catch (DALException e) {
			System.err.println("Business method create : Erreur DALException : " + e.getMessage());
			throw new ServiceException(e);
		}
		return newdto;
	}

	@Override
	public void update(UserDTO dto) throws ServiceException {

		final UserDAO dao = this.getDao();
		try {
			dao.update(dto);
		} catch (DALException e) {
			System.err.println("Business method update : Erreur DALException : " + e.getMessage());
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public void delete(UserDTO dto) throws ServiceException {

		final UserDAO dao = this.getDao();
		try {
			dao.delete(dto);
		} catch (DALException e) {
			System.err.println("Business method delete : Erreur DALException : " + e.getMessage());
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public void checkUser(String login, String password) throws ServiceException {
		final UserDAO dao = this.getDao();
		try {
			dao.checkUser(login, password);
		} catch (DALException e) {
			System.err.println("Business method delete : Erreur DALException : " + e.getMessage());
			throw new ServiceException(e.getMessage());
		}
		
	}
	
	

}
