package fr.imie.training.cdi13.dav.tpjpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.imie.training.cdi13.dav.tpjpa.api.Airport;
import fr.imie.training.cdi13.dav.tpjpa.api.Cart;
import fr.imie.training.cdi13.dav.tpjpa.api.Flight;
import fr.imie.training.cdi13.dav.tpjpa.api.PersonDAO;
import fr.imie.training.cdi13.dav.tpjpa.api.Product;
import fr.imie.training.cdi13.dav.tpjpa.impl.PersonDAOImpl;

public class TestJPA {

	private static PersonDAO personDAO;

	public static PersonDAO getPersonDAO() {
		if (personDAO == null) {
			personDAO = new PersonDAOImpl();
		}
		return personDAO;
	}
	
	public static void main(String[] args) {

		String unit = null;
		
//		PersonDAO personDAO = TestJPA.getPersonDAO();
//
//		// FindAll
//		List<Person> personList = personDAO.find();
//		
//		for (Person person : personList) {
//			System.out.println(person);
//		}
//		
//		// create
//		Person person = new Person();
//		person.setFirstName("Luke5");
//		person.setLastName("Skywalker5");
//		
//		personDAO.create(person);
//		
//		person = personDAO.find(1);
//		person.setFirstName("yoda2");
//		person.setLastName("Vador2");
//		personDAO.update(person);
//				
//		person = personDAO.find(5);
//		System.out.println("Person à supprimer" + person);
////		personDAO.delete(person);
//		
//		personDAO.exception();
//		
//		personList = personDAO.find();
//		for (Person p : personList) {
//			System.out.println(p);
//		}
		
		// EclipseLink
		// unit = "jpaEclipseLinkToTomcat";

		// Hibernate
		unit = "jpaEclipseLinkToTomcat";

		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {

			emf = Persistence.createEntityManagerFactory(unit);
			em = emf.createEntityManager();
			em.getTransaction().begin();

			// CREATE
			Airport airport = new Airport();
			airport.setName("Nantes");
			Flight flight = new Flight();
			flight.setName("EasyJet");
			
			flight.addAirport(airport);
			
			em.persist(flight);
			em.persist(airport);

			System.out.println("Airport");
			List<Airport> list = em.createQuery("from Airport a").getResultList();
			for (Airport item : list) {
				System.out.println(item);
			}
			
			System.out.println("Flight");
			List<Flight> list2 = em.createQuery("from Flight a").getResultList();
			for (Flight item : list2) {
				System.out.println(item);
			}
			
			// 
//			Product product = new Product();
//			Cart cart = new Cart();
//			cart.addProduct(product);
//			
//			em.persist(product);
//			em.persist(cart);

			em.getTransaction().commit();
		} catch (Throwable e) {
			System.err.println("Entity Manager failed");
			e.printStackTrace();
			System.err.println("Exception : " + e.getMessage());
			em.getTransaction().rollback();
		} finally {
			em.close();
			emf.close();
		}

	}

}
