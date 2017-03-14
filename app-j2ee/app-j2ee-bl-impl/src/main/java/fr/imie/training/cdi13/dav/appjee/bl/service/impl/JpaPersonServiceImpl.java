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
import fr.imie.training.cdi13.dav.appjee.bl.service.PersonServiceEjb;
import fr.imie.training.cdi13.dav.appjee.dal.DALException;
import fr.imie.training.cdi13.dav.jpa.entity.v1.Eleve1;
import fr.imie.training.cdi13.dav.jpa.entity.v1.Parent1;
import fr.imie.training.cdi13.dav.jpa.entity.v1.Personne1;
import fr.imie.training.cdi13.dav.jpa.entity.v2.Eleve2;
import fr.imie.training.cdi13.dav.jpa.entity.v2.Parent2;
import fr.imie.training.cdi13.dav.jpa.entity.v2.Personne2;
import fr.imie.training.cdi13.dav.jpa.entity.v3.Eleve3;
import fr.imie.training.cdi13.dav.jpa.entity.v3.Parent3;
import fr.imie.training.cdi13.dav.jpa.entity.v3.Personne3;

@Stateless
public class JpaPersonServiceImpl implements PersonServiceEjb {

	@PersistenceContext(name = "fcpePG")
	private EntityManager entityManager;

	@Override
	public List<Person> find() throws BusinessException {
		List<Person> boList = null;
		final List<Personne1> dtoList = this.entityManager.createNamedQuery("Personne1.findAll").getResultList();

		if (dtoList != null) {
			boList = new ArrayList<>();
			for (Personne1 entity : dtoList) {
				Person bo;

				if (entity instanceof Parent1) {
					bo = new Parent();
					((Parent) bo).setEmail(((Parent1) entity).getEmail());
				} else if (entity instanceof Eleve1) {
					bo = new Eleve();
					((Eleve) bo).setNomClasse(((Eleve1) entity).getNomclasse());
				} else {
					bo = new Person();
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
			Personne1 entity = null;
			
			if (person instanceof Parent) {
				Parent1 entity1 = null;
				if (person.getState() == BO.STATE.TO_UPDATE || person.getState() == BO.STATE.TO_REMOVE) {
					entity1 = this.entityManager.find(Parent1.class, person.getId());					
				}
				else if (person.getState() == BO.STATE.TO_INSERT) {
					entity1 = new Parent1();
				}
				else {
					throw new DALException("BO STATE invalid");
				}
				entity1.setEmail(((Parent) person).getEmail());
				entity = entity1;
			}
			else if (person instanceof Eleve) {
				Eleve1 entity1 = null;
				if (person.getState() == BO.STATE.TO_UPDATE || person.getState() == BO.STATE.TO_REMOVE) {
					entity1 = this.entityManager.find(Eleve1.class, person.getId());
					
				}
				else if (person.getState() == BO.STATE.TO_INSERT) {
					entity1 = new Eleve1();
				}
				else {
					throw new DALException("BO STATE invalid");
				}
				entity1.setNomclasse(((Eleve) person).getNomClasse());
				entity = entity1;
			}
			else {
				if (person.getState() == BO.STATE.TO_UPDATE || person.getState() == BO.STATE.TO_REMOVE) {
					entity = this.entityManager.find(Personne1.class, person.getId());
				}
				else if (person.getState() == BO.STATE.TO_INSERT) {
					entity = new Personne1();
				}
				else {
					throw new DALException("BO STATE invalid");
				} 
			}
			
			entity.setId(person.getId());
			entity.setNom(person.getNom());
			entity.setPrenom(person.getPrenom());

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
		final List<Personne2> entityList = this.entityManager.createNamedQuery("Personne2.findAll").getResultList();

		if (entityList != null) {
			boList = new ArrayList<>();
			for (Personne2 entity : entityList) {
				Person bo;

				if (entity instanceof Parent2) {
					bo = new Parent();
					((Parent) bo).setEmail(((Parent2) entity).getEmail());
				} else if (entity instanceof Eleve2) {
					bo = new Eleve();
					((Eleve) bo).setNomClasse(((Eleve2) entity).getNomclasse());
				} else {
					bo = new Person();
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
	public void persist2(Person person) throws BusinessException {
		try {

			// transformation du bo en entity
			Personne2 entity = null;
			
			if (person instanceof Parent) {
				Parent2 entity2 = null;
				if (person.getState() == BO.STATE.TO_UPDATE || person.getState() == BO.STATE.TO_REMOVE) {
					entity2 = this.entityManager.find(Parent2.class, person.getId());					
				}
				else if (person.getState() == BO.STATE.TO_INSERT) {
					entity2 = new Parent2();
				}
				else {
					throw new DALException("BO STATE invalid");
				}
				entity2.setEmail(((Parent) person).getEmail());
				entity = entity2;
			}
			else if (person instanceof Eleve) {
				Eleve2 entity2 = null;
				if (person.getState() == BO.STATE.TO_UPDATE || person.getState() == BO.STATE.TO_REMOVE) {
					entity2 = this.entityManager.find(Eleve2.class, person.getId());
					
				}
				else if (person.getState() == BO.STATE.TO_INSERT) {
					entity2 = new Eleve2();
				}
				else {
					throw new DALException("BO STATE invalid");
				}
				entity2.setNomclasse(((Eleve) person).getNomClasse());
				entity = entity2;
			}
			else {
				if (person.getState() == BO.STATE.TO_UPDATE || person.getState() == BO.STATE.TO_REMOVE) {
					entity = this.entityManager.find(Personne2.class, person.getId());
				}
				else if (person.getState() == BO.STATE.TO_INSERT) {
					entity = new Personne2();
				}
				else {
					throw new DALException("BO STATE invalid");
				} 
			}
			
			entity.setId(person.getId());
			entity.setNom(person.getNom());
			entity.setPrenom(person.getPrenom());

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
	public List<Person> find3() throws BusinessException {
		List<Person> boList = null;
		final List<Personne3> entityList = this.entityManager.createNamedQuery("Personne3.findAll").getResultList();

		if (entityList != null) {
			boList = new ArrayList<>();
			for (Personne3 entity : entityList) {
				Person bo;

				if (entity instanceof Parent3) {
					bo = new Parent();
					((Parent) bo).setEmail(((Parent3) entity).getEmail());
				} else if (entity instanceof Eleve3) {
					bo = new Eleve();
					((Eleve) bo).setNomClasse(((Eleve3) entity).getNomclasse());
				} else {
					bo = new Person();
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
	public void persist3(Person person) throws BusinessException {
		try {

			// transformation du bo en entity
			Personne3 entity = null;
			
			if (person instanceof Parent) {
				Parent3 entity3 = null;
				if (person.getState() == BO.STATE.TO_UPDATE || person.getState() == BO.STATE.TO_REMOVE) {
					entity3 = this.entityManager.find(Parent3.class, person.getId());					
				}
				else if (person.getState() == BO.STATE.TO_INSERT) {
					entity3 = new Parent3();
				}
				else {
					throw new DALException("BO STATE invalid");
				}
				entity3.setEmail(((Parent) person).getEmail());
				entity = entity3;
			}
			else if (person instanceof Eleve) {
				Eleve3 entity3 = null;
				if (person.getState() == BO.STATE.TO_UPDATE || person.getState() == BO.STATE.TO_REMOVE) {
					entity3 = this.entityManager.find(Eleve3.class, person.getId());
					
				}
				else if (person.getState() == BO.STATE.TO_INSERT) {
					entity3 = new Eleve3();
				}
				else {
					throw new DALException("BO STATE invalid");
				}
				entity3.setNomclasse(((Eleve) person).getNomClasse());
				entity = entity3;
			}
			else {
				if (person.getState() == BO.STATE.TO_UPDATE || person.getState() == BO.STATE.TO_REMOVE) {
					entity = this.entityManager.find(Personne3.class, person.getId());
				}
				else if (person.getState() == BO.STATE.TO_INSERT) {
					entity = new Personne3();
				}
				else {
					throw new DALException("BO STATE invalid");
				} 
			}
			
			entity.setId(person.getId());
			entity.setNom(person.getNom());
			entity.setPrenom(person.getPrenom());

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

}
