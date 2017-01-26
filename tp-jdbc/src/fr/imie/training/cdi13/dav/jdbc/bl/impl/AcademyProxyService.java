package fr.imie.training.cdi13.dav.jdbc.bl.impl;

import java.util.List;
import java.util.Map;

import fr.imie.training.cdi13.dav.jdbc.bl.Service;
import fr.imie.training.cdi13.dav.jdbc.bl.ServiceException;
import fr.imie.training.cdi13.dav.jdbc.dal.dao.DAO;
import fr.imie.training.cdi13.dav.jdbc.model.DTO;

public class AcademyProxyService implements Service {

	private Map<DAO.DAO_TYPE, DAO> daoMap;

	private Service academyService;

	public AcademyProxyService() {

	}

	public Service getAcademyService() {
		if (this.academyService == null) {
			this.academyService = new AcademyService();
			this.academyService.init(this.daoMap);
		}
		return this.academyService;
	}

	@Override
	public void init(Map<DAO.DAO_TYPE, DAO> daoMap) {
		this.daoMap = daoMap;
	}

	@Override
	public DTO findById(Integer id) throws ServiceException {
		System.out.println("BL: finById");
		final DTO newDto;
		try {
			newDto = this.getAcademyService().findById(id);
		} catch (ServiceException e) {
			System.err.println("BL: Erreur finById");
			throw e;
		}
		return newDto;
	}

	@Override
	public DTO create(DTO dto) throws ServiceException {
		System.out.println("BL: create");
		final DTO newDto;
		try {
			newDto = this.getAcademyService().create(dto);
		} catch (ServiceException e) {
			System.err.println("BL: Erreur create");
			throw e;
		}
		return newDto;
	}

	@Override
	public void update(DTO dto) throws ServiceException {
		System.out.println("BL: update");
		try {
			this.getAcademyService().update(dto);
		} catch (ServiceException e) {
			System.err.println("BL: Erreur update");
			throw e;
		}
	}

	@Override
	public void delete(DTO dto) throws ServiceException {
		System.out.println("BL: delete");
		try {
			this.getAcademyService().delete(dto);
		} catch (ServiceException e) {
			System.err.println("BL: Erreur delete");
			throw e;
		}
	}

	@Override
	public List<DTO> listerEtablissement() throws ServiceException {
		System.out.println("BL: listerEtablissement");
		final List<DTO> liste;
		try {
			liste = this.getAcademyService().listerEtablissement();
		} catch (ServiceException e) {
			System.err.println("BL: Erreur listerEtablissement");
			throw e;
		}
		return liste;
	}

}
