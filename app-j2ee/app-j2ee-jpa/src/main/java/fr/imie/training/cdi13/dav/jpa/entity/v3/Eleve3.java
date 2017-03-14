package fr.imie.training.cdi13.dav.jpa.entity.v3;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the eleves2 database table.
 * 
 */
@Entity
@Table(name = "eleves3")
@DiscriminatorValue("3")
@NamedQuery(name = "Eleve3.findAll", query = "SELECT e FROM Eleve3 e")
public class Eleve3 extends Personne3 implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nomclasse;

	// bi-directional many-to-one association to Personnes2
	// @ManyToOne
	// @JoinColumn(name="person_id")
	// private Personne3 personnes2;

	public String getNomclasse() {
		return this.nomclasse;
	}

	public void setNomclasse(String nomclasse) {
		this.nomclasse = nomclasse;
	}

}