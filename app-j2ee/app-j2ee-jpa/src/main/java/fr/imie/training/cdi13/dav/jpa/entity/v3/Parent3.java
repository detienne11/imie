package fr.imie.training.cdi13.dav.jpa.entity.v3;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the parents2 database table.
 * 
 */
@Entity
@Table(name="parents3")
@DiscriminatorValue("2")
@NamedQuery(name="Parents2.findAll", query="SELECT p FROM Parent3 p")
public class Parent3 extends Personne3 implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String email;

	//bi-directional many-to-one association to Personnes2
//	@ManyToOne
//	@JoinColumn(name="person_id")
//	private Personne3 personnes2;

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}