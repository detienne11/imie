package fr.imie.training.cdi13.dav.j2ee.model.dto;

import fr.imie.training.cdi13.dav.j2ee.model.DTO;

public class UserDTO implements DTO {

	public final static String ID = "id";
	public final static String NOM = "nom";
	public final static String PRENOM = "prenom";
	public final static String ACTIF = "est_actif";
	public final static String CONNECTION_ID = "id_connexion";
	public final static String PASSWORD = "mot_de_passe";
	public final static String EMAIL = "email";

	private Integer id = null;

	private String nom = null;

	private String prenom = null;

	private Boolean actif = null;

	private String connectionId = null;

	private String password = null;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
