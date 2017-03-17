package fr.imie.training.cdi13.dav.tpjpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.imie.training.cdi13.dav.tpjpa.api.Person;

public class TestJPA {

	public static void main(String[] args) {

		String unit = null;
		
		// EclipseLink
//		unit = "jpaEclipseLinkToTomcat";
		
		// Hibernate
		unit = "jpaEclipseLinkToTomcat";
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory(unit);
		EntityManager em = fac.createEntityManager();
		List<Person> personList = em.createNamedQuery("Person.findAll").getResultList();
		
		System.out.println(personList.size());
		em.close();
		fac.close();		
	}

}
