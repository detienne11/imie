package fr.imie.cdi13.training.poo.tp2.dav;

public enum EShape {
	
	RECTANGLE("Rectangle"),
	CIRCLE ("Circle"),
	SQUARE("Square"),
	TRIANGLE("Triangle"),
	REGULARPOLYGON("Regular Polygon");
	
	private final String nom;
	
	EShape(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	
}
