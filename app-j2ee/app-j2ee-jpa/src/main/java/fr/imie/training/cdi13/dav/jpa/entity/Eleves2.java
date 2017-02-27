package fr.imie.training.cdi13.dav.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the eleves2 database table.
 * 
 */
@Entity
@Table(name="eleves2")
@NamedQuery(name="Eleves2.findAll", query="SELECT e FROM Eleves2 e")
public class Eleves2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nomclasse;

	//bi-directional many-to-one association to Personnes2
	@ManyToOne
	@JoinColumn(name="person_id")
	private Personnes2 personnes2;

	public Eleves2() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomclasse() {
		return this.nomclasse;
	}

	public void setNomclasse(String nomclasse) {
		this.nomclasse = nomclasse;
	}

	public Personnes2 getPersonnes2() {
		return this.personnes2;
	}

	public void setPersonnes2(Personnes2 personnes2) {
		this.personnes2 = personnes2;
	}

}