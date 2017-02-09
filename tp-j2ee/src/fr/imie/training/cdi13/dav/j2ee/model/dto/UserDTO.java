package fr.imie.training.cdi13.dav.j2ee.model.dto;

import fr.imie.training.cdi13.dav.j2ee.model.DTO;

public class UserDTO implements DTO {

	private Integer id = null;
	
	private String nom = null;
	
	private String prenom = null;
	
	private Boolean actif = null;
	
	private String connectionId = null;
	
	private Boolean password = null;
	
	private String email = null;
	
	public UserDTO() {
		super();
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

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	public String getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(String connectionId) {
		this.connectionId = connectionId;
	}

	public Boolean getPassword() {
		return password;
	}

	public void setPassword(Boolean password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
