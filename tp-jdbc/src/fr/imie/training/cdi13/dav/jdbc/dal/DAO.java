package fr.imie.training.cdi13.dav.jdbc.dal;

import java.util.List;

import fr.imie.training.cdi13.dav.jdbc.model.DTO;

public interface DAO {

	public static enum DAO_TYPE {
		ETABLISSEMENT, ADMINISTRATEUR
	};

	public List<DTO> find();

	public DTO findById(Integer id);

	public DTO create(DTO dto);

	public void update(DTO dto);

	public void delete(DTO dto);

}
