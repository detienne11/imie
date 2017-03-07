package fr.imie.training.cdi13.dav.jpa.entity.v1;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * The persistent class for the parents database table.
 * 
 */
@Entity
@DiscriminatorValue("2")
public class Parent1 extends Personne1 implements Serializable {

	private String email;

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}