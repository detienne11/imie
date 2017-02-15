package fr.imie.training.cdi13.dav.appjee.bl.domain;

import fr.imie.training.cdi13.dav.appjee.bl.BusinessException;

public interface BO<T> {

	public static enum STATE {
		TO_INSERT, TO_UPDATE, TO_REMOVE
	};

	public T convertToDTO();

	// public List<T> convertToListDTO();

	public void setFromDTO(T dto) throws BusinessException;
}
