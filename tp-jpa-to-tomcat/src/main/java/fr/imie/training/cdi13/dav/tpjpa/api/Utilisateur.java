package fr.imie.training.cdi13.dav.tpjpa.api;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@Table(name="utilisateur")
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String email;

	@Column(name="est_actif")
	private Boolean estActif;

	@Column(name="id_connexion")
	private String idConnexion;

	@Column(name="mot_de_passe")
	private String motDePasse;

	private String nom;

	private String prenom;

	public Utilisateur() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEstActif() {
		return this.estActif;
	}

	public void setEstActif(Boolean estActif) {
		this.estActif = estActif;
	}

	public String getIdConnexion() {
		return this.idConnexion;
	}

	public void setIdConnexion(String idConnexion) {
		this.idConnexion = idConnexion;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}