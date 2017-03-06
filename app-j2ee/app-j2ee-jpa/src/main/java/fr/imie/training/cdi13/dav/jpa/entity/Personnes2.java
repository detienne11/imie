package fr.imie.training.cdi13.dav.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the personnes2 database table.
 * 
 */
@Entity
@Table(name="personnes2")
@NamedQuery(name="Personnes2.findAll", query="SELECT p FROM Personnes2 p")
public class Personnes2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nom;

	private String prenom;

	//bi-directional many-to-one association to Eleves2
	@OneToMany(mappedBy="personnes2")
	private List<Eleves2> eleves2s;

	//bi-directional many-to-one association to Parents2
	@OneToMany(mappedBy="personnes2")
	private List<Parents2> parents2s;

	public Personnes2() {
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

	public List<Eleves2> getEleves2s() {
		return this.eleves2s;
	}

	public void setEleves2s(List<Eleves2> eleves2s) {
		this.eleves2s = eleves2s;
	}

	public Eleves2 addEleves2(Eleves2 eleves2) {
		getEleves2s().add(eleves2);
		eleves2.setPersonnes2(this);

		return eleves2;
	}

	public Eleves2 removeEleves2(Eleves2 eleves2) {
		getEleves2s().remove(eleves2);
		eleves2.setPersonnes2(null);

		return eleves2;
	}

	public List<Parents2> getParents2s() {
		return this.parents2s;
	}

	public void setParents2s(List<Parents2> parents2s) {
		this.parents2s = parents2s;
	}

	public Parents2 addParents2(Parents2 parents2) {
		getParents2s().add(parents2);
		parents2.setPersonnes2(this);

		return parents2;
	}

	public Parents2 removeParents2(Parents2 parents2) {
		getParents2s().remove(parents2);
		parents2.setPersonnes2(null);

		return parents2;
	}

}