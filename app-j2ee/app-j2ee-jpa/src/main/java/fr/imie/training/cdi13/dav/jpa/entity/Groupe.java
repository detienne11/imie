package fr.imie.training.cdi13.dav.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the groupes database table.
 * 
 */
@Entity
@Table(name="groupes")
@NamedQuery(name="Groupe.findAll", query="SELECT g FROM Groupe g")
public class Groupe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nom;

	//bi-directional many-to-many association to Utilisateur
	@ManyToMany(mappedBy="groupes")
	private List<Utilisateur> utilisateurs;

	public Groupe() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

}