package fr.imie.training.cdi13.dav.appjee.bl.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.imie.training.cdi13.dav.appjee.bl.BusinessException;
import fr.imie.training.cdi13.dav.appjee.bl.domain.BO;
import fr.imie.training.cdi13.dav.appjee.bl.domain.Eleve;
import fr.imie.training.cdi13.dav.appjee.bl.domain.Parent;
import fr.imie.training.cdi13.dav.appjee.bl.domain.Person;
import fr.imie.training.cdi13.dav.appjee.bl.domain.Person.PERSON_TYPE;
import fr.imie.training.cdi13.dav.appjee.bl.service.PersonServiceEjb;
import fr.imie.training.cdi13.dav.appjee.dal.DALException;
import fr.imie.training.cdi13.dav.jpa.entity.Personne;
import fr.imie.training.cdi13.dav.jpa.entity.Personnes2;

@Stateless
public class JpaPersonServiceImpl implements PersonServiceEjb {

	@PersistenceContext(name = "fcpePG")
	private EntityManager entityManager;

	@Override
	public List<Person> find() throws BusinessException {
		List<Person> boList = null;
		final List<Personne> dtoList = this.entityManager.createNamedQuery("Personne.findAll").getResultList();

		if (dtoList != null) {
			boList = new ArrayList<>();
			for (Personne entity : dtoList) {
				Person bo;

				if (entity.getPersontype() == 2) {
					bo = new Parent();
					((Parent) bo).setEmail(entity.getEmail());
					bo.setType(PERSON_TYPE.PARENT);
				} else if (entity.getPersontype() == 3) {
					bo = new Eleve();
					((Eleve) bo).setNomClasse(entity.getNomclasse());
					bo.setType(PERSON_TYPE.ELEVE);
				} else {
					bo = new Person();
					bo.setType(PERSON_TYPE.PERSON);
				}

				bo.setId(entity.getId());
				bo.setNom(entity.getNom());
				bo.setPrenom(entity.getPrenom());

				boList.add(bo);
			}
		}

		return boList;
	}

	@Override
	public void persist(Person person) throws BusinessException {

		try {

			// transformation du bo en entity
			Personne entity;

			if (person.getState() == BO.STATE.TO_UPDATE
					|| person.getState() == BO.STATE.TO_REMOVE) {
				entity = this.entityManager.find(Personne.class, person.getId());
			} else if (person.getState() == BO.STATE.TO_INSERT) {
				entity = new Personne();
			} else {
				throw new DALException("BO STATE invalid");
			}

			entity.setId(person.getId());
			entity.setNom(person.getNom());
			entity.setPrenom(person.getPrenom());

			if (person instanceof Parent) {
				entity.setPersontype(Integer.valueOf(2));
				entity.setEmail(((Parent) person).getEmail());
			} else if (person instanceof Eleve) {
				entity.setPersontype(Integer.valueOf(3));
				entity.setNomclasse(((Eleve) person).getNomClasse());
			} else {
				entity.setPersontype(Integer.valueOf(1));
			}

			// Persistence
			if (person.getState() == BO.STATE.TO_REMOVE) {
				this.entityManager.remove(entity);
			} else if (person.getState() == BO.STATE.TO_INSERT) {
				this.entityManager.persist(entity);
			}

		} catch (DALException e) {
			System.err.println("Business Layer : DALException - persistUser : " + e.getMessage());
			throw new BusinessException(e);
		}

	}

	@Override
	public List<Person> find2() throws BusinessException {
		List<Person> boList = null;
//		final List<Personnes2> entityList = this.entityManager.createNamedQuery("Personnes2.findAll").getResultList();
//
//		if (entityList != null) {
//			boList = new ArrayList<>();
//			for (Personnes2 entity : entityList) {
//				Person bo;
//
//				if (entity.getPersontype() == 2) {
//					bo = new Parent();
//					((Parent) bo).setEmail(entity.getEmail());
//					bo.setType(PERSON_TYPE.PARENT);
//				} else if (entity.getPersontype() == 3) {
//					bo = new Eleve();
//					((Eleve) bo).setNomClasse(entity.getNomclasse());
//					bo.setType(PERSON_TYPE.ELEVE);
//				} else {
//					bo = new Person();
//					bo.setType(PERSON_TYPE.PERSON);
//				}
//
//				bo.setId(entity.getId());
//				bo.setNom(entity.getNom());
//				bo.setPrenom(entity.getPrenom());
//
//				boList.add(bo);
//			}
//		}

		return boList;
	}

	@Override
	public void persist2(Person person) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	
	
}
