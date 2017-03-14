package fr.imie.training.cdi13.dav.jpa.entity.v2;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the personnes database table.
 * 
 */
@Entity
@Table(name="personnes2")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@NamedQuery(name="Personne2.findAll", query="SELECT p FROM Personne2 p")
public class Personne2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer id;

	private String nom;
	
	private String prenom;

	public Personne2() {
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
	
}