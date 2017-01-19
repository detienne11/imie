/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package fr.imie.cdi13.dav.bibliotheque;

import java.util.ArrayList;
import java.util.List;


// Start of user code (user defined imports)

// End of user code

/**
 * Description of Livre.
 * 
 * @author david.cdi13
 */
public class Livre implements LivreInterface {
	/**
	 * Description of the property isbn.
	 */
	private Integer isbn = null;

	/**
	 * Description of the property auteur.
	 */
	private String auteur = null;

	/**ArrayList
	 * Description of the property titre.
	 */
	private String titre = null;

	/**
	 * Description of the property emprunts.
	 */
	public List<EmpruntInterface> emprunts = new ArrayList<EmpruntInterface>();

	// Start of user code (user defined attributes for Livre)

	// End of user code

	/**
	 * The constructor.
	 */
	public Livre() {
		// Start of user code constructor for Livre)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Livre)

	// End of user code
	/**
	 * Returns isbn.
	 * @return isbn 
	 */
	public Object getIsbn() {
		return this.isbn;
	}

	/**
	 * Sets a value to attribute isbn. 
	 * @param newIsbn 
	 */
	public void setIsbn(Integer newIsbn) {
		this.isbn = newIsbn;
	}

	/**
	 * Returns auteur.
	 * @return auteur 
	 */
	public Object getAuteur() {
		return this.auteur;
	}

	/**
	 * Sets a value to attribute auteur. 
	 * @param newAuteur 
	 */
	public void setAuteur(String newAuteur) {
		this.auteur = newAuteur;
	}

	/**
	 * Returns titre.
	 * @return titre 
	 */
	public Object getTitre() {
		return this.titre;
	}

	/**
	 * Sets a value to attribute titre. 
	 * @param newTitre 
	 */
	public void setTitre(String newTitre) {
		this.titre = newTitre;
	}

	/**
	 * Returns emprunts.
	 * @return emprunts 
	 */
	public List<EmpruntInterface> getEmprunts() {
		return this.emprunts;
	}

	@Override
	public void estDisponible() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void emprunterLivre() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("Livre : ");
		str.append(this.getIsbn());
		str.append(" - ");
		str.append(this.getTitre());
		str.append(" - ");
		str.append(this.getAuteur());
		return str.toString();
	}
	
	
	

}
