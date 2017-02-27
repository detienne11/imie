package fr.imie.training.cdi13.dav.appjee.bl.domain;

public class Eleve extends Person {
	
	private Integer eleve_id;

	private String nomClasse;

	public Integer getEleve_id() {
		return eleve_id;
	}

	public void setEleve_id(Integer eleve_id) {
		this.eleve_id = eleve_id;
	}

	public String getNomClasse() {
		return nomClasse;
	}

	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}

	
	
}
