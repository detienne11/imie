/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package fr.imie.cdi13.dav.bibliotheque;

import java.time.LocalDate;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Emprunt.
 * 
 * @author david.cdi13
 */
public class Emprunt {
	/**
	 * Description of the property date.
	 */
	private LocalDate date = null;

	/**
	 * Description of the property livreInterfaces.
	 */
	public LivreInterface livre = null;

	/**
	 * Description of the property adherents.
	 */
	public AdherentInterface adherent = null;

	/**
	 * Description of the property personnels.
	 */
	public PersonnelInterface personnel = null;

	// Start of user code (user defined attributes for Emprunt)

	// End of user code

	/**
	 * The constructor.
	 */
	public Emprunt() {
		// Start of user code constructor for Emprunt)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Emprunt)

	// End of user code
	/**
	 * Returns date.
	 * @return date 
	 */
	public LocalDate getDate() {
		return this.date;
	}

	/**
	 * Sets a value to attribute date. 
	 * @param newDate 
	 */
	public void setDate(LocalDate newDate) {
		this.date = newDate;
	}

	/**
	 * Returns livreInterfaces.
	 * @return livreInterfaces 
	 */
	public LivreInterface getLivre() {
		return this.livre;
	}

	/**
	 * Returns adherents.
	 * @return adherents 
	 */
	public AdherentInterface getAdherent() {
		return this.adherent;
	}

	/**
	 * Sets a value to attribute adherents. 
	 * @param newAdherents 
	 */
	public void setAdherent(AdherentInterface newAdherent) {
		this.adherent = newAdherent;
	}

	/**
	 * Returns personnels.
	 * @return personnels 
	 */
	public PersonnelInterface getPersonnel() {
		return this.personnel;
	}

	/**
	 * Sets a value to attribute personnels. 
	 * @param newPersonnels 
	 */
	public void setPersonnel(PersonnelInterface newPersonnels) {
		this.personnel = newPersonnels;
	}

}
