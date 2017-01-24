package fr.imie.cdi13.training.jdbc.dav.bl.impl;

import java.util.List;

import fr.imie.cdi13.training.jdbc.dav.bl.Service;
import fr.imie.cdi13.training.jdbc.dav.bl.ServiceException;
import fr.imie.cdi13.training.jdbc.dav.dal.DAOFactory;
import fr.imie.cdi13.training.jdbc.dav.dal.dao.EtablissementDAO;
import fr.imie.cdi13.training.jdbc.dav.dto.DTO;

public class ServiceImpl implements Service {

	@Override
	public List<DTO> listerEtablissement() throws ServiceException {
		final DAOFactory daoFactory = DAOFactory.getInstance();
		final EtablissementDAO etablissementDao = daoFactory.getEtablissementDAO();
		final List<DTO> liste = etablissementDao.find();
		return liste;
	}

}
