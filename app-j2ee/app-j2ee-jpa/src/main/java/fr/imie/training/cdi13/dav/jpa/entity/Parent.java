package fr.imie.training.cdi13.dav.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the parents database table.
 * 
 */
@Entity
@Table(name="parents")
@NamedQuery(name="Parent.findAll", query="SELECT p FROM Parent p")
public class Parent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String email;

	private String nom;

	private String prenom;

	public Parent() {
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