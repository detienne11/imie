/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package fr.imie.cdi13.dav.bibliotheque;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of BibliothequeInterface.
 * 
 * @author david.cdi13
 */
public interface BibliothequeInterface {
	// Start of user code (user defined attributes for BibliothequeInterface)

	// End of user code

	/**
	 * Description of the method rechercherLivre.
	 */
	public void rechercherLivre();

	/**
	 * Description of the method listerEmprunts.
	 */
	public void listerEmprunts();

	/**
	 * Description of the method demanderReserverLivre.
	 */
	public void demanderReserverLivre();

	// Start of user code (user defined methods for BibliothequeInterface)

	public void ajouterLivre(LivreInterface livre);
	
	// End of user code

}
