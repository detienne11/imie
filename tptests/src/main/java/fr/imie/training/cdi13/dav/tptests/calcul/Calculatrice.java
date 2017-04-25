package fr.imie.training.cdi13.dav.tptests.calcul;

public interface Calculatrice {

	public Boolean appuiTouche(String touche);
	
	public String lire();
	
	public void reset();
	
	
}
