package fr.imie.training.cdi13.dav.tpjpa.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.imie.training.cdi13.dav.tpjpa.api.Person;
import fr.imie.training.cdi13.dav.tpjpa.api.PersonDAO;

public class PersonDAOImpl implements PersonDAO {

	EntityManagerFactory factory = null;

	public EntityManagerFactory getFactory() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("jpaEclipseLinkToTomcat");
		}
		return factory;
	}

	public EntityManager getEntityManager() {
		return getFactory().createEntityManager();
	}

	@Override
	public Person find(Person person) {
		return getEntityManager().find(Person.class, person.getId());
	}
	
	@Override
	public Person find(Integer id) {
		return getEntityManager().find(Person.class, id);
	}

	@Override
	public List<Person> find() {
		// List<Person> personList = new ArrayList<>();
		// Person person = new Person();
		// person.setFirstName("Dark");
		// person.setLastName("Vador");
		// liste.add(person);
//		List<Person> personList = getEntityManager().createQuery("from Person").getResultList();
		List<Person> personList = getEntityManager().createNamedQuery("Person.findAll").getResultList();
		return personList;
	}

	@Override
	public void persist(Person person) {
		getEntityManager().persist(person);
	}

	@Override
	public void delete(Person person) {
		getEntityManager().remove(person);
	}

}
