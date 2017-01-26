package fr.imie.training.cdi13.dav.jdbc.ui.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;



public class Console {

	private static Scanner sc = new Scanner(System.in);
	
	public static String afficherMenu() {
		final StringBuffer str = new StringBuffer();
		str.append("\n------------------------------------------------------------------------------------\n");
		str.append("Quelle action voulez vous faire ?\n\n");
		
		str.append("\t- 1 : lister\n");
		str.append("\t- 2 : creer\n");
		str.append("\t- 3 : modifier\n");
		str.append("\t- 4 : supprimer\n");
		str.append("\t- q : exit\n");
		
		str.append("------------------------------------------------------------------------------------\n");
		str.append("Saisissez votre choix :");
		return str.toString();
	}
	
	public static boolean confirmer() {

		boolean confirm = false;
		String reponse = null;
		boolean selection = false;
		while (!selection) {

			System.err.println("Confirmez-vous ? Y/N");

			reponse = sc.nextLine();
			if (Pattern.matches("^[YNyn]$", reponse)) {
				selection = true;
				if (Pattern.matches("^[Yy]$", reponse)){
					confirm = true;
				}			
			} else {
				System.err.println("Réponse incorrecte, veuillez resaisir !");
			}

		}
		return confirm;
	}
	
	public static String demanderChoixUtilisateur(String patternReponse, String msg) {

		String reponse = null;
		boolean selection = false;
		while (!selection) {

			System.out.print(msg);

			reponse = sc.nextLine();
			if (Pattern.matches("^q$", reponse)) {
				selection = true;
				reponse = "exit";
			} else if (Pattern.matches(patternReponse, reponse)) {
				selection = true;
			} else {
				System.err.println("La réponse est incorrecte, veuillez resaisir !");
			}

		}
		return reponse;
	}

	public static String demanderParametreUtilisateur(String param) {
		List<String> params = new ArrayList<>();
		params.add(param);
		List<String> values = Console.demanderParametreUtilisateur(params);
		return values.get(0);
	}
	
	public static List<String> demanderParametreUtilisateur(List<String> listeParameters) {

		List<String> values = new ArrayList<>();
		for (int i = 0; i < listeParameters.size(); i++) {
			StringBuffer params = new StringBuffer();
			params.append("Parametre \"");
			params.append(listeParameters.get(i));
			params.append("\"= ");

			String reponse = Console.demanderChoixUtilisateur("^.*$", params.toString());
			values.add(reponse);
		}
		return values;
	}

}
