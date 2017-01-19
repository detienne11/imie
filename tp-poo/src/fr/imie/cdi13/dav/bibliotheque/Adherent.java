/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package fr.imie.cdi13.dav.bibliotheque;

import java.util.List;
import java.util.ArrayList;

import fr.imie.cdi13.dav.bibliotheque.Personne;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Adherent.
 * 
 * @author david.cdi13
 */
public class Adherent extends Personne implements AdherentInterface {
	/**
	 * Description of the property empruntInterfaces.
	 */
	public List<EmpruntInterface> empruntInterfaces = new ArrayList<EmpruntInterface>();

	/**
	 * Description of the property bibliothequeInterfaces.
	 */
	public List<BibliothequeInterface> bibliothequeInterfaces = new ArrayList<BibliothequeInterface>();

	// Start of user code (user defined attributes for Adherent)

	private Integer numero = null;
	
	// End of user code

	/**
	 * The constructor.
	 */
	public Adherent() {
		// Start of user code constructor for Adherent)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Adherent)

	// End of user code
	/**
	 * Returns empruntInterfaces.
	 * @return empruntInterfaces 
	 */
	public List<EmpruntInterface> getEmpruntInterfaces() {
		return this.empruntInterfaces;
	}

	/**
	 * Returns bibliothequeInterfaces.
	 * @return bibliothequeInterfaces 
	 */
	public List<BibliothequeInterface> getBibliothequeInterfaces() {
		return this.bibliothequeInterfaces;
	}
	
	
	
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(super.toString());
		str.append(", Adherent : ");
		str.append(this.getNumero());
		return str.toString();
	}

}
