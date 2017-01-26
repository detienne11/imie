package fr.imie.training.cdi13.dav.jdbc.bl.impl;

import java.util.List;
import java.util.Map;

import fr.imie.training.cdi13.dav.jdbc.bl.Service;
import fr.imie.training.cdi13.dav.jdbc.bl.ServiceException;
import fr.imie.training.cdi13.dav.jdbc.dal.DALException;
import fr.imie.training.cdi13.dav.jdbc.dal.dao.DAO;
import fr.imie.training.cdi13.dav.jdbc.model.DTO;
import fr.imie.training.cdi13.dav.jdbc.model.dto.EtablissementDTO;

public class AcademyService implements Service {

	private Map<DAO.DAO_TYPE, DAO> daoMap;

	public AcademyService() {

	}

	@Override
	public void init(Map<DAO.DAO_TYPE, DAO> daoMap) {
		this.daoMap = daoMap;
	}

	@Override
	public DTO findById(Integer id) throws ServiceException {
		final DAO dao = this.getDao(DAO.DAO_TYPE.ETABLISSEMENT);
		DTO newDto;
		try {
			newDto = dao.findById(id);
		} catch (DALException e) {
			throw new ServiceException(e.getMessage());
		}
		return newDto;
	}

	private final DAO getDao(DAO.DAO_TYPE daoType) throws ServiceException {
		DAO dao = null;
		try {
			dao = this.daoMap.get(daoType);
		} catch (Exception e) {
			throw new ServiceException("DAO inexistant :" + e.getMessage());
		}
		return dao;
	}

	private final DAO getDao(DTO dto) throws ServiceException {

		DAO dao = null;

		if (dto instanceof EtablissementDTO) {
			dao = this.getDao(DAO.DAO_TYPE.ETABLISSEMENT);
		}

		return dao;
	}

	@Override
	public DTO create(DTO dto) throws ServiceException {
		final DAO dao = this.getDao(dto);
		final DTO newDto;
		try {
			newDto = dao.create(dto);
		} catch (DALException e) {
			throw new ServiceException(e);
		}
		return newDto;
	}

	@Override
	public void update(DTO dto) throws ServiceException {

		final DAO dao = this.getDao(dto);
		try {
			dao.update(dto);
		} catch (DALException e) {
			System.err.println("Business method update : Erreur DALException : " + e.getMessage());
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public void delete(DTO dto) throws ServiceException {

		final DAO dao = this.getDao(dto);
		try {
			dao.delete(dto);
		} catch (DALException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<DTO> listerEtablissement() throws ServiceException {
		final DAO dao = this.getDao(DAO.DAO_TYPE.ETABLISSEMENT);
		final List<DTO> liste;
		try {
			liste = dao.find();
		} catch (DALException e) {
			throw new ServiceException(e.getMessage());
		}
		return liste;
	}

}
