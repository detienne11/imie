package fr.imie.training.cdi13.dav.jpa.entity.v1;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the personnes database table.
 * 
 */
@Entity
@Table(name = "personnes1")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "persontype")
@DiscriminatorValue("1")
@NamedQuery(name = "Personne1.findAll", query = "SELECT p FROM Personne1 p")
public class Personne1 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String codepostal;

	private String nom;

	private String prenom;

	private String rue;

	private String ville;

	public Personne1() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodepostal() {
		return this.codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
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

	public String getRue() {
		return this.rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}