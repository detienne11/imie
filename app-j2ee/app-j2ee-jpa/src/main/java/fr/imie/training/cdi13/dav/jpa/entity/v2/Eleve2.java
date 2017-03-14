package fr.imie.training.cdi13.dav.jpa.entity.v2;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the eleves database table.
 * 
 */
@Entity
@Table(name = "eleves2")
@NamedQuery(name = "Eleve2.findAll", query = "SELECT e FROM Eleve2 e")
public class Eleve2 extends Personne2 implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nomclasse;

	public String getNomclasse() {
		return this.nomclasse;
	}

	public void setNomclasse(String nomclasse) {
		this.nomclasse = nomclasse;
	}

}