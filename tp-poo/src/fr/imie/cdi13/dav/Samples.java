package fr.imie.cdi13.dav;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Samples {

	public static void main(String[] args)  {
		
//		Samples.exo71();
//		Samples.exo72();
//		Samples.exo72bis();
		Samples.exo95();
	}
	
	public static void exo72()  {

		int tableau[] ={6,5,4,3,2,7,9,10,8};
		
		for (int x = 0; x < tableau.length-1; x++) {
			boolean arefaire = false;
			System.out.println(x);
			for (int i = 0; i < tableau.length; i++) {			
				if (i > 0) {
					if (tableau[i]<tableau[i-1]) {						
						arefaire = true;
						final int tmp = tableau[i-1];
						tableau[i-1]=tableau[i];
						tableau[i]=tmp;
					}
				}
			}
			if (!arefaire) {
				break;
			}
		}
		
		StringBuffer msg = new StringBuffer();
		for (int i : tableau) {
			msg.append(String.valueOf(i));
			msg.append(",");
		}
		System.out.println(msg);
	}
	
	public static void exo72bis()  {

		int tableau[] ={6,5,4,3,2,7,9,10,8};
		
		for (int i = 1; i < tableau.length; i++) {			
			if (tableau[i]<tableau[i-1]) {
				final int tmp = tableau[i-1];
				tableau[i-1]=tableau[i];
				tableau[i]=tmp;
				i=0;
			}
		}
		
		StringBuffer msg = new StringBuffer();
		for (int i : tableau) {
			msg.append(String.valueOf(i));
			msg.append(",");
		}
		System.out.println(msg);
	}
	
	public static void exo95() {		
		double value = Samples.factorielle(10);
		System.out.println(String.valueOf(value));
		
		float value2 = Samples.niemepuissance(5,-3);
		System.out.println(String.valueOf(value2));
	}
	
	public static float niemepuissance(float nombre,int puissance) {
		float result = nombre;
		if (puissance > 0) {
			float value = Samples.niemepuissance(nombre,puissance - 1);		
			result = nombre * value;
			System.out.println(String.valueOf(nombre) + " e " + String.valueOf(puissance-1) + " = " + String.valueOf(result));
		}
		else if (puissance < 0) {
			float value = Samples.niemepuissance(nombre,puissance + 1);		
			result = value / nombre;
			System.out.println(String.valueOf(nombre) + " e " + String.valueOf(puissance+1) + " = " + String.valueOf(result));
		}
		
		return result;
	}
	
	public static double factorielle(double nombre) {
		double result = 1;
		if (nombre > 1) {
			double value = Samples.factorielle(nombre - 1);		
			result = nombre * value;			
		}
		System.out.println(String.valueOf(nombre) + "! = " + String.valueOf(result));
		return result;				
	}
	
	public static void exo71()  {
				
		System.out.println("Excercice 7.1");
		
		final List<Integer> listeNombre = new ArrayList<Integer>();
		int i=0;
		boolean consecutif = true;
				
		try {
			
			LineNumberReader lineCounter = new LineNumberReader(new InputStreamReader(System.in));

		    String nextLine = null;
		    while ((nextLine = lineCounter.readLine()).indexOf("Q") == -1) {
		        if (nextLine == null)
		          break;
		        
		        if (nextLine.matches("^\\d*$")){
		        	listeNombre.add(Integer.valueOf(nextLine));
		        }
		        else {
		        	System.err.println("La saisie ne correspond pas à un entier");
		        }
		      }
			
			/*BufferedInputStream bis = new BufferedInputStream(System.in);
			
			int saisie = 0;
			while((saisie = bis.read()) != 'Q'){
				System.out.println((char)saisie);
				if (saisie !='\n') {
					
				}
				
			}*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Erreur");
		}

		while (i < listeNombre.size() && consecutif) {
			if (i >= 1
					&& (listeNombre.get(i)-1 != listeNombre.get(i-1))) {
				consecutif = false;
			}
			else{
				i++;
			}				
		}
		
		StringBuffer msg = new StringBuffer();
		for (Integer integer : listeNombre) {
			msg.append(String.valueOf(integer));
			msg.append(",");
		}
		System.out.println("Valeurs dans la liste : " + msg);
		
		if (listeNombre.size() <=1) {
			System.out.println("La liste ne contient pas assez d'éléments");
		}
		else if (consecutif) {
			System.out.println("La liste est consécutive");
		}
		else {
			System.out.println("La liste n'est pas consécutive");
		}

	}

}
