package fr.imie.cdi13.training.jdbc.dav.bl;

import java.util.List;

import fr.imie.cdi13.training.jdbc.dav.dto.DTO;

public interface Service {

	public List<DTO> listerEtablissement() throws ServiceException;
	
}
