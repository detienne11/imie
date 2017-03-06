package fr.imie.training.cdi13.dav.appjee.bl.domain;

import fr.imie.training.cdi13.dav.jpa.entity.Personne;

public class Person {
		
	public enum PERSON_TYPE {
		PERSON, PARENT, ELEVE
	};

	private BO.STATE state = null;
	
	private Integer id;

	private PERSON_TYPE type;
	
	private String nom;

	private String prenom;

	private Address address;

	public PERSON_TYPE getPersonType() {
		return type;
	}
	
	public Integer getType() {
		if (this.type == PERSON_TYPE.ELEVE) {
			return 3;
		}
		else if (this.type == PERSON_TYPE.PARENT) {
			return 2;
		}
		else {
			return 1;
		}		
	}

	public void setType(PERSON_TYPE type) {
		this.type = type;
	}

	public BO.STATE getState() {
		return state;
	}

	public void setState(BO.STATE state) {
		this.state = state;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getNomClasse() {
		return null;
	}
	
	public String getEmail() {
		return null;
	}
	
}
