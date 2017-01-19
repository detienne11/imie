/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package fr.imie.cdi13.dav.bibliotheque;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Personne.
 * 
 * @author david.cdi13
 */
public class Personne {
	// Start of user code (user defined attributes for Personne)

	// End of user code

	/**
	 * The constructor.
	 */
	public Personne() {
		// Start of user code constructor for Personne)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Personne)

	private String nom = null;
	
	private String prenom = null;

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
		str.append("Personne : ");		
		str.append(this.getNom());
		str.append(" - ");
		str.append(this.getPrenom());
		return str.toString();
	}
	
	
	
	// End of user code

}
