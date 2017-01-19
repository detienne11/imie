/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package fr.imie.cdi13.dav.bibliotheque;

import java.util.ArrayList;
import java.util.List;

import fr.imie.cdi13.dav.bibliotheque.Personne;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Personnel.
 * 
 * @author david.cdi13
 */
public class Personnel extends Personne implements PersonnelInterface {
	/**
	 * Description of the property bibliothequeInterfaces.
	 */
	public List<BibliothequeInterface> bibliothequeInterfaces = new ArrayList<BibliothequeInterface>();

	// Start of user code (user defined attributes for Personnel)

	private String role = null;
	
	// End of user code

	/**
	 * The constructor.
	 */
	public Personnel() {
		// Start of user code constructor for Personnel)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Personnel)

	// End of user code
	/**
	 * Returns bibliothequeInterfaces.
	 * @return bibliothequeInterfaces 
	 */
	public List<BibliothequeInterface> getBibliothequeInterfaces() {
		return this.bibliothequeInterfaces;
	}
	
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(super.toString());
		str.append(", Personnel : ");
		str.append(this.getRole());
		return str.toString();
	}

}
