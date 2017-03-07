package fr.imie.training.cdi13.dav.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the parents2 database table.
 * 
 */
@Entity
@Table(name="parents2")
@NamedQuery(name="Parents2.findAll", query="SELECT p FROM Parents2 p")
public class Parents2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String email;

	//bi-directional many-to-one association to Personnes2
	@ManyToOne
	@JoinColumn(name="person_id")
	private Personnes2 personnes2;

	public Parents2() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Personnes2 getPersonnes2() {
		return this.personnes2;
	}

	public void setPersonnes2(Personnes2 personnes2) {
		this.personnes2 = personnes2;
	}

}