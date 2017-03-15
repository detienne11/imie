package fr.imie.training.cdi13.dav.tpjpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory f = Persistence.createEntityManagerFactory("tpJpaToTomcat");
		f.close();		
	}

}
