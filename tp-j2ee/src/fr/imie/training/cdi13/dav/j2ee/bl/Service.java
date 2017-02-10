package fr.imie.training.cdi13.dav.j2ee.bl;

import java.util.List;
import java.util.Map;

import fr.imie.training.cdi13.dav.j2ee.dal.dao.DAO;

public interface Service<T> {

	public enum SERVICE_TYPE {
		USER
	};

	public void init(Map<DAO.DAO_TYPE, DAO<?>> daoMap);

	public List<T> find() throws ServiceException;

	public T findById(Integer id) throws ServiceException;

	public T create(T DTO) throws ServiceException;

	public void update(T dto) throws ServiceException;

	public void delete(T dto) throws ServiceException;

}
