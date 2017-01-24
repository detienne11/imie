package fr.imie.cdi13.training.jdbc.dav.dal.dao;

import java.util.List;

import fr.imie.cdi13.training.jdbc.dav.dto.DTO;

public interface DAO {
	
	public List<DTO> find();
	
	public void create(DTO dto);
	
	public void update(DTO dto);
	
	public void delete(DTO dto);
	
}
