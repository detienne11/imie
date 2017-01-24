package fr.imie.cdi13.training.jdbc.dav.ui;

import java.util.List;

import fr.imie.cdi13.training.jdbc.dav.Application;
import fr.imie.cdi13.training.jdbc.dav.ApplicationException;
import fr.imie.cdi13.training.jdbc.dav.dal.DAOFactory;
import fr.imie.cdi13.training.jdbc.dav.dal.dao.EtablissementDAO;
import fr.imie.cdi13.training.jdbc.dav.dto.DTO;

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

		EtablissementDAO etablissementDao = daoFactory.getEtablissementDAO();
		List<DTO> listeEtablissements = etablissementDao.find();

		for (DTO dto : listeEtablissements) {
			System.out.println(dto.toString());
		}

	}

}
