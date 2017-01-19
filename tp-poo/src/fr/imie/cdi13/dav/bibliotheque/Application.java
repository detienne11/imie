package fr.imie.cdi13.dav.bibliotheque;

public class Application {

	public static void main(String[] args) {

		
		// creation Bibliotheque
		Bibliotheque bibliotheque = Application.creerBibliotheque("Formation Imie");
		
		// creation Adherent
		Application.creerAdherent(bibliotheque, Integer.valueOf(1), "nom 1", "prenom 1");
		Application.creerAdherent(bibliotheque, Integer.valueOf(2), "nom 2", "prenom 2");		
		Application.creerAdherent(bibliotheque, Integer.valueOf(2), "nom 3", "prenom 3");
		
		// creation Personnel
		Application.creerPersonnel(bibliotheque, "responsable littérature", "nom 4", "prenom 4");
		Application.creerPersonnel(bibliotheque, "responsable sciences", "nom 5", "prenom 5");
		
		// creation Livre
		Application.creerLivre(bibliotheque,Integer.valueOf(1), "Titre 1", "Bob");
		Application.creerLivre(bibliotheque,Integer.valueOf(1), "Titre 2", "Luke");
		Application.creerLivre(bibliotheque,Integer.valueOf(1), "Titre 3", "Luke");
		
		System.out.println(bibliotheque);
//		BibliothequeInterface b = new Bibliotheque();
//		
//		b.listerEmprunts();
//		b.demanderReserverLivre();
//		b.rechercherLivre();
		

	}
	
	public static Bibliotheque creerBibliotheque(String nom) {		
		Bibliotheque bibliotheque = new Bibliotheque();
		bibliotheque.setNom(nom);
		return bibliotheque;
	}
	
	public static void creerAdherent(Bibliotheque bibliotheque,Integer numero,String nom,String prenom) {		
		Adherent adherent = new Adherent();
		adherent.setNumero(numero);
		adherent.setNom(nom);
		adherent.setPrenom(prenom);
		bibliotheque.getAdherents().add(adherent);
	}
	
	public static void creerPersonnel(Bibliotheque bibliotheque,String role,String nom,String prenom) {		
		Personnel personnel = new Personnel();
		personnel.setRole(role);
		personnel.setNom(nom);
		personnel.setPrenom(prenom);
		bibliotheque.getPersonnels().add(personnel);
		
	}
	
	public static void creerLivre(Bibliotheque bibliotheque,Integer isbn, String titre, String auteur) {		
		Livre livre = new Livre();
		livre.setAuteur(auteur);
		livre.setIsbn(isbn);
		livre.setTitre(titre);		
		bibliotheque.getLivres().add(livre);		
	}

}
