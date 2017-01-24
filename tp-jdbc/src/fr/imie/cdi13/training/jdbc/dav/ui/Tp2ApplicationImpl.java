package fr.imie.cdi13.training.jdbc.dav.ui;

import java.util.List;

import fr.imie.cdi13.training.jdbc.dav.Application;
import fr.imie.cdi13.training.jdbc.dav.ApplicationException;
import fr.imie.cdi13.training.jdbc.dav.bl.Service;
import fr.imie.cdi13.training.jdbc.dav.bl.ServiceException;
import fr.imie.cdi13.training.jdbc.dav.bl.ServiceFactory;
import fr.imie.cdi13.training.jdbc.dav.dal.DAOFactory;
import fr.imie.cdi13.training.jdbc.dav.dto.DTO;

public class Tp2ApplicationImpl implements Application {

	private DAOFactory daoFactory = null;

	public Tp2ApplicationImpl() {
	}

	@Override
	public String getNom() {
		return "TP2 via business layer";
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

		final Service service = ServiceFactory.getInstance().getService();
		try {
			List<DTO> liste = service.listerEtablissement();

			for (DTO dto : liste) {
				System.out.println(dto.toString());
			}

		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			throw new ApplicationException(e.getMessage());
		}

	}

}
