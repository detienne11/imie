package fr.imie.training.cdi13.dav.jdbc.ui;

import java.util.List;

import fr.imie.training.cdi13.dav.jdbc.Application;
import fr.imie.training.cdi13.dav.jdbc.ApplicationException;
import fr.imie.training.cdi13.dav.jdbc.dal.DALException;
import fr.imie.training.cdi13.dav.jdbc.dal.DAO;
import fr.imie.training.cdi13.dav.jdbc.dal.DAOFactory;
import fr.imie.training.cdi13.dav.jdbc.dal.dao.EtablissementDAO;
import fr.imie.training.cdi13.dav.jdbc.model.DTO;

public class Tp1ApplicationImpl implements Application {

	private DAOFactory daoFactory = null;

	public Tp1ApplicationImpl() {
	}

	@Override
	public String getNom() {
		return "TP1 via DTO";
	}

	@Override
	public void init() throws ApplicationException {
		daoFactory = DAOFactory.getInstance();
		daoFactory.openConnection();
	}

	@Override
	public void stop() throws ApplicationException {
		daoFactory.closeConnection();
	}

	@Override
	public void start() throws ApplicationException {

		final EtablissementDAO etablissementDao;
		try {
			etablissementDao = (EtablissementDAO) daoFactory.getDAO(DAO.DAO_TYPE.ETABLISSEMENT);

			List<DTO> listeEtablissements = etablissementDao.find();

			for (DTO dto : listeEtablissements) {
				System.out.println(dto.toString());
			}

		} catch (DALException e) {
			throw new ApplicationException(e.getMessage());
		}

	}

}
