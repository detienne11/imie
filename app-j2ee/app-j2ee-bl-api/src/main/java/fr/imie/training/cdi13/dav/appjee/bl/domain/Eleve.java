package fr.imie.training.cdi13.dav.appjee.bl.domain;

public class Eleve extends Person {

	private String nomClasse;

	public String getNomClasse() {
		return nomClasse;
	}

	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}
	
	public Integer getType() {
		return Integer.valueOf(3);
	}
	
}
