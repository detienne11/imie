package fr.imie.training.cdi13.dav.tpjpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJPA {

	public static void main(String[] args) {

		String unit = null;
		
		// EclipseLink
//		unit = "jpaEclipseLinkToTomcat";
		
		// Hibernate
		unit = "jpaHibernateToTomcat";
		
		EntityManagerFactory f = Persistence.createEntityManagerFactory(unit);
		f.close();		
	}

}
