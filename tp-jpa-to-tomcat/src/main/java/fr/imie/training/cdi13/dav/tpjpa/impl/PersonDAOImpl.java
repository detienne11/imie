package fr.imie.training.cdi13.dav.tpjpa.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.imie.training.cdi13.dav.tpjpa.api.Person;
import fr.imie.training.cdi13.dav.tpjpa.api.PersonDAO;

public class PersonDAOImpl implements PersonDAO {

	public enum ACTION {
		CREATE, UPDATE, DELETE, EXCEPTION
	};

	private EntityManagerFactory emf = null;
	
	private EntityManagerFactory getFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("jpaEclipseLinkToTomcat");
		}
		return emf;
	}

	private EntityManager getEntityManager() {
		return getFactory().createEntityManager();
	}

	@Override
	public Person find(Person person) {
		return find(person.getId());
	}

	@Override
	public Person find(Integer id) {
		return getEntityManager().find(Person.class, id);
	}

	@Override
	public List<Person> find() {
		// List<Person> personList = getEntityManager().createQuery("from
		// Person").getResultList();
		List<Person> personList = getEntityManager().createNamedQuery("Person.findAll").getResultList();
		return personList;
	}

	private void persist(EntityManager em, Integer id) {
		Person person = getEntityManager().getReference(Person.class, id);
		this.persist(person, ACTION.DELETE);
	}
	
	private void persist(Person person, ACTION action) {
		System.out.println("Entity persistence " + String.valueOf(action));
		
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		try {
			if (ACTION.CREATE == action) {
				em.persist(person);
			} else if (ACTION.UPDATE == action) {
				em.merge(person);
			} else if (ACTION.DELETE == action) {
				final Person p = em.getReference(Person.class, person.getId());
				em.remove(p);
			}else if (ACTION.EXCEPTION == action) {
				throw new Exception("Erreur personnalisé");
			}
			
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Exception : " + e.getMessage());
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	@Override
	public void create(Person person) {
		this.persist(person, ACTION.CREATE);
	}

	@Override
	public void update(Person person) {
		this.persist(person, ACTION.UPDATE);
	}

	@Override
	public void delete(Integer id) {
		Person person = getEntityManager().getReference(Person.class, id);
		this.persist(person, ACTION.DELETE);
	}

	@Override
	public void delete(Person person) {
		this.delete(person.getId());
	}
	
	@Override
	public void exception() {
		this.persist(null, ACTION.EXCEPTION);
	}

}
