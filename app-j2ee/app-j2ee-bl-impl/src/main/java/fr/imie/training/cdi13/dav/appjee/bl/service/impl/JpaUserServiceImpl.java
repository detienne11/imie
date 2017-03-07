package fr.imie.training.cdi13.dav.appjee.bl.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.imie.training.cdi13.dav.appjee.bl.BusinessException;
import fr.imie.training.cdi13.dav.appjee.bl.domain.BO;
import fr.imie.training.cdi13.dav.appjee.bl.domain.Role;
import fr.imie.training.cdi13.dav.appjee.bl.domain.User;
import fr.imie.training.cdi13.dav.appjee.bl.service.UserServiceEjb;
import fr.imie.training.cdi13.dav.appjee.dal.DALException;
import fr.imie.training.cdi13.dav.jpa.entity.Utilisateur;

@Stateless
public class JpaUserServiceImpl implements UserServiceEjb {

	@PersistenceContext(name = "fcpePG")
	private EntityManager entityManager;

	@Override
	public List<User> findUser() throws BusinessException {

		// List<User> boList = new ArrayList<>();

		// EntityManagerFactory emf =
		// Persistence.createEntityManagerFactory("fcpePG");
		// this.entityManager = emf.createEntityManager();
		// EntityTransaction trans = em.getTransaction();
		// trans.begin();
		//
		//
		// transac.commit();

		List<User> boList = null;
		final List<Utilisateur> dtoList = this.entityManager.createNamedQuery("Utilisateur.findAll").getResultList();

		if (dtoList != null) {
			boList = new ArrayList<>();
			for (Utilisateur dto : dtoList) {
				final User user = new User();
				user.setFromDTO(dto);
				boList.add(user);
			}
		}

		// this.entityManager.close();
		//
		// emf.close();
		//
		return boList;

	}

	@Override
	public User findUser(Integer id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User persistUser(User user) throws BusinessException {
		User bo = null;

		try {

			if (user.getState() == BO.STATE.TO_INSERT) {
				Utilisateur entity = new Utilisateur();
				user.populateToEntity(entity);
				this.entityManager.persist(entity);
			} else if (user.getState() == BO.STATE.TO_UPDATE) {
				// Utilisateur entity =
				// this.entityManager.getReference(Utilisateur.class,
				// user.getId());
				Utilisateur entity = this.entityManager.find(Utilisateur.class, user.getId());
				user.populateToEntity(entity);
				// this.entityManager.persist(entity);
			} else if (user.getState() == BO.STATE.TO_REMOVE) {
				Utilisateur entity = this.entityManager.find(Utilisateur.class, user.getId());
				this.entityManager.remove(entity);
			} else {
				throw new DALException("BO STATE invalid");
			}

		} catch (DALException e) {
			System.err.println("Business Layer : DALException - persistUser : " + e.getMessage());
			throw new BusinessException(e);
		}
		return bo;
	}

	@Override
	public void checkUser(String login, String password) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Role> findRole() throws BusinessException {
		List<Role> boList = null;
		final List<fr.imie.training.cdi13.dav.jpa.entity.Role> entityList = this.entityManager.createNamedQuery("Role.findAll").getResultList();

		if (entityList != null) {
			boList = new ArrayList<>();
			for (fr.imie.training.cdi13.dav.jpa.entity.Role entity : entityList) {
				final Role bo = new Role();
				bo.setId(entity.getId());
				bo.setNom(entity.getNom());
				boList.add(bo);
			}
		}
		return boList;
	}

}
