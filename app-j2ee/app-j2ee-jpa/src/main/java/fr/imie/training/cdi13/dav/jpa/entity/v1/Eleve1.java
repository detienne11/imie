package fr.imie.training.cdi13.dav.jpa.entity.v1;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * The persistent class for the eleves database table.
 * 
 */
@Entity
@DiscriminatorValue("3")
public class Eleve1 extends Personne1 implements Serializable {

	private String nomclasse;

	public String getNomclasse() {
		return this.nomclasse;
	}

	public void setNomclasse(String nomclasse) {
		this.nomclasse = nomclasse;
	}

}