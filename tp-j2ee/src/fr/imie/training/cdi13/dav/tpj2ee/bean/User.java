package fr.imie.training.cdi13.dav.tpj2ee.bean;

public class User {

	private String nom;
	
	private String prenom;

	public User() {
		super();
		this.nom = "Dark";
		this.prenom = "Vador";
	}
	
	public User(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("User : Nom=");
		str.append(this.nom);
		str.append(", Prenom=");
		str.append(this.prenom);		
		return str.toString();
	}
	
	
	
}
