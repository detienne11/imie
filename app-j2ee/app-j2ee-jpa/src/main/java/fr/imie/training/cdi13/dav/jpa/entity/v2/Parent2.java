package fr.imie.training.cdi13.dav.jpa.entity.v2;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the parents database table.
 * 
 */
@Entity
@Table(name = "parents2")
@NamedQuery(name = "Parent2.findAll", query = "SELECT p FROM Parent2 p")
public class Parent2 extends Personne2 implements Serializable {

	private static final long serialVersionUID = 1L;

	private String email;

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}