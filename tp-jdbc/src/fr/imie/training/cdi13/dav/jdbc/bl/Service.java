package fr.imie.training.cdi13.dav.jdbc.bl;

import java.util.List;

import fr.imie.training.cdi13.dav.jdbc.model.DTO;

public interface Service {
	
	public enum SERVICE_TYPE {ACADEMIE};

	public List<DTO> listerEtablissement() throws ServiceException;

	public DTO findById(Integer id) throws ServiceException;
	
	public DTO create(DTO dto) throws ServiceException;

	public void update(DTO dto) throws ServiceException;

	public void delete(DTO dto) throws ServiceException;

}
