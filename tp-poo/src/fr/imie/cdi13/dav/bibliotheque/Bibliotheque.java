/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package fr.imie.cdi13.dav.bibliotheque;

import java.util.ArrayList;
import java.util.List;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Bibliotheque.
 * 
 * @author david.cdi13
 */
public class Bibliotheque implements BibliothequeInterface {
	/**
	 * Description of the property livres.
	 */
	public List<LivreInterface> livres = new ArrayList<LivreInterface>();

	/**
	 * Description of the property adherents.
	 */
	public List<AdherentInterface> adherents = new ArrayList<AdherentInterface>();

	/**
	 * Description of the property personnels.
	 */
	public List<PersonnelInterface> personnels = new ArrayList<PersonnelInterface>();

	// Start of user code (user defined attributes for Bibliotheque)

	private String nom = null;
	
	// End of user code

	/**
	 * The constructor.
	 */
	public Bibliotheque() {
		// Start of user code constructor for Bibliotheque)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Bibliotheque)

	// End of user code
	/**
	 * Returns livres.
	 * @return livres 
	 */
	public List<LivreInterface> getLivres() {
		return this.livres;
	}

	/**
	 * Returns adherents.
	 * @return adherents 
	 */
	public List<AdherentInterface> getAdherents() {
		return this.adherents;
	}

	/**
	 * Returns personnels.
	 * @return personnels 
	 */
	public List<PersonnelInterface> getPersonnels() {
		return this.personnels;
	}

	@Override
	public void rechercherLivre() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listerEmprunts() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void demanderReserverLivre() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouterLivre(LivreInterface livre) {

		this.getLivres().add(livre);
		
	}

	@Override
	public String toString() {

		StringBuffer str = new StringBuffer();
		str.append("Bibliothèque : ");
		str.append(this.getNom());
		
		str.append("\nListe Personnels :\n");
		for (PersonnelInterface personnel : this.getPersonnels()) {
			str.append(personnel);
			str.append("\n");
		}
		
		str.append("\nListe Adherents :\n");
		for (AdherentInterface adherent : this.getAdherents()) {
			str.append(adherent);
			str.append("\n");
		}
		
		str.append("\nListe Livres :\n");
		for (LivreInterface livre : this.getLivres()) {
			str.append(livre);
			str.append("\n");
		}
		return str.toString();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
