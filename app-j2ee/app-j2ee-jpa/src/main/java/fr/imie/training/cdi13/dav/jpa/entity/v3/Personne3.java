package fr.imie.training.cdi13.dav.jpa.entity.v3;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the personnes2 database table.
 * 
 */
@Entity
@Table(name = "personnes3")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "persontype")
@DiscriminatorValue("1")
@NamedQuery(name = "Personne3.findAll", query = "SELECT p FROM Personne3 p")
public class Personne3 implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;

	private String nom;

	private String prenom;

	// //bi-directional many-to-one association to Eleves2
	// @OneToMany(mappedBy="personnes2")
	// private List<Eleve3> eleves2s;
	//
	// //bi-directional many-to-one association to Parents2
	// @OneToMany(mappedBy="personnes2")
	// private List<Parent3> parents2s;

	public Personne3() {
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

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	// public List<Eleve3> getEleves2s() {
	// return this.eleves2s;
	// }
	//
	// public void setEleves2s(List<Eleve3> eleves2s) {
	// this.eleves2s = eleves2s;
	// }
	//
	// public Eleve3 addEleves2(Eleve3 eleves2) {
	// getEleves2s().add(eleves2);
	// eleves2.setPersonnes2(this);
	//
	// return eleves2;
	// }
	//
	// public Eleve3 removeEleves2(Eleve3 eleves2) {
	// getEleves2s().remove(eleves2);
	// eleves2.setPersonnes2(null);
	//
	// return eleves2;
	// }

	// public List<Parent3> getParents2s() {
	// return this.parents2s;
	// }
	//
	// public void setParents2s(List<Parent3> parents2s) {
	// this.parents2s = parents2s;
	// }
	//
	// public Parent3 addParents2(Parent3 parents2) {
	// getParents2s().add(parents2);
	// parents2.setPersonnes2(this);
	//
	// return parents2;
	// }
	//
	// public Parent3 removeParents2(Parent3 parents2) {
	// getParents2s().remove(parents2);
	// parents2.setPersonnes2(null);
	//
	// return parents2;
	// }

}