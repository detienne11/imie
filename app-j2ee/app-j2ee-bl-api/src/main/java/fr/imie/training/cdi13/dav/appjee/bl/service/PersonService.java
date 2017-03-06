package fr.imie.training.cdi13.dav.appjee.bl.service;

import java.util.List;

import fr.imie.training.cdi13.dav.appjee.bl.BusinessException;
import fr.imie.training.cdi13.dav.appjee.bl.domain.Person;

public interface PersonService extends Service {

	public List<Person> find() throws BusinessException;

	public void persist(Person person) throws BusinessException;
	
	public List<Person> find2() throws BusinessException;

	public void persist2(Person person) throws BusinessException;
	
}
