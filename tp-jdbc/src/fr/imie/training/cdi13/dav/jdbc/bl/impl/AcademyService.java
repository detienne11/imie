package fr.imie.training.cdi13.dav.jdbc.bl.impl;

import java.util.List;

import fr.imie.training.cdi13.dav.jdbc.bl.Service;
import fr.imie.training.cdi13.dav.jdbc.bl.ServiceException;
import fr.imie.training.cdi13.dav.jdbc.dal.DALException;
import fr.imie.training.cdi13.dav.jdbc.dal.DAO;
import fr.imie.training.cdi13.dav.jdbc.dal.DAOFactory;
import fr.imie.training.cdi13.dav.jdbc.model.DTO;

public class AcademyService implements Service {

	private final DAOFactory daoFactory;

	public AcademyService(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public DTO findById(Integer id) throws ServiceException {
		final DAO dao;
		final DTO newDto;
		try {
			dao = this.daoFactory.getDAO(DAO.DAO_TYPE.ETABLISSEMENT);
			newDto = dao.findById(id);
		} catch (DALException e) {
			throw new ServiceException(e.getMessage());
		}
		return newDto;
	}

	
	@Override
	public DTO create(DTO dto) throws ServiceException {
		final DAO dao;
		final DTO newDto;
		try {
			dao = this.daoFactory.getDAO(dto);
			newDto = dao.create(dto);
		} catch (DALException e) {
			throw new ServiceException(e.getMessage());
		}
		return newDto;
	}

	@Override
	public void update(DTO dto) throws ServiceException {

		final DAO dao;
		try {
			dao = this.daoFactory.getDAO(dto);
			dao.update(dto);
		} catch (DALException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public void delete(DTO dto) throws ServiceException {

		final DAO dao;
		try {
			dao = this.daoFactory.getDAO(dto);
			dao.delete(dto);
		} catch (DALException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<DTO> listerEtablissement() throws ServiceException {
		final DAO dao;
		final List<DTO> liste;
		try {
			dao = this.daoFactory.getDAO(DAO.DAO_TYPE.ETABLISSEMENT);
			liste = dao.find();
		} catch (DALException e) {
			throw new ServiceException(e.getMessage());
		}
		return liste;
	}

}
