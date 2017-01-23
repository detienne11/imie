package fr.imie.cdi13.training.poo.tp2.dav;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Affichage {

	public static Scanner sc = new Scanner(System.in);
	
	public static String demanderChoixUtilisateur(String patternReponse,String msg) {
		
		String reponse = null;
		boolean selection = false;
		while (!selection) {
		
			System.out.println(msg);
			
			reponse = sc.nextLine();
			if (Pattern.matches("^q$", reponse)) {
				selection = true;
				reponse = "exit";
			}
			else if (Pattern.matches(patternReponse, reponse)) {
				selection = true;
			}
			else {
				System.err.println("La réponse est incorrecte, veuillez resaisir !\n");
			}
		
		}
		return reponse;
	}
	
	
	public static float[] demanderParametreUtilisateur(List<String> listeParameters) {
		
		float[] values = new float[listeParameters.size()];
		for (int i = 0; i < listeParameters.size(); i++) {
			StringBuffer params = new StringBuffer();
			params.append("Parametre \"");
			params.append(listeParameters.get(i));
			params.append("\"= ");

			String reponse = Affichage.demanderChoixUtilisateur("^\\d+$", params.toString());
			values[i] = Float.valueOf(reponse).floatValue();						
		}
		return values;
	}
	
	public static void stop() {
		Affichage.sc.close();
		System.out.println("Bye Bye !!!");
	}
		
	
	public static void start() {
		
		System.out.println("******************************************************************\n");
		System.out.println("\tApplication : Creer Dynamiquement une FORME\n");
		System.out.println("******************************************************************\n");
		
		final List<IShape> listeShapes = new ArrayList<>();
		final ShapeFactory shapeFactory = ShapeFactory.getInstance();
		
		final StringBuffer str = new StringBuffer();
		str.append("\n------------------------------------------------------------------------------------\n");
		str.append("Quelle forme voulez vous créer ?\n\n");
		for (EShape elt : EShape.values()) {
			str.append("\t- " + (elt.ordinal() + 1 ) + " : " + elt.getNom());
			str.append("\n");
		}
		str.append("------------------------------------------------------------------------------------\n");
		str.append("Saisissez votre choix :");
		
		boolean exit = false;
		while (!exit) {
			String reponse = Affichage.demanderChoixUtilisateur("^[1-5]$", str.toString());
			if (reponse.equals("exit")) {
				exit = true;
			}
			else {
				System.out.println("Saisissez les parametres de la forme sélectionnée :");
				
				float[] values = null;
//				IShape shape = null;
				EShape typeShape = null;
				
				switch (Integer.valueOf(reponse).intValue()) {
				case 1:
					// Rectangle
					typeShape = EShape.RECTANGLE;
//					System.out.print("Rectangle :");
//					values = Affichage.demanderParametreUtilisateur(Rectangle.parameters());
//					shape = new Rectangle();
					break;

				case 2:
					// Circle
					typeShape = EShape.CIRCLE;
//					System.out.print("Circle :");
//					values = Affichage.demanderParametreUtilisateur(Circle.parameters());
//					shape = new Circle();
//					listeShapes.add(new Circle(values));
					break;

				case 3:
					// Square
					typeShape = EShape.SQUARE;
//					System.out.print("Square :");
//					values = Affichage.demanderParametreUtilisateur(Square.parameters());
//					shape = new Square();
//					listeShapes.add(new Square(values));
					break;

				case 4:
					// Triangle
					typeShape = EShape.TRIANGLE;
//					System.out.print("Triangle :");
//					values = Affichage.demanderParametreUtilisateur(Triangle.parameters());
//					shape = new Triangle();
//					listeShapes.add(new Triangle(values));
					break;

				case 5:
					// Regular Polygon
					typeShape = EShape.REGULARPOLYGON;
//					System.out.print("Regular Polygon :");
//					values = Affichage.demanderParametreUtilisateur(RegularPolygon.parameters());
//					shape = new RegularPolygon();
					break;
	
				}
				
//				shape.initShape(values);
				System.out.print(typeShape.getNom() + " : ");
				values = Affichage.demanderParametreUtilisateur(shapeFactory.listerParameters(typeShape));
				IShape shape;
				try {
					shape = shapeFactory.creerShape(typeShape, values);
					listeShapes.add(shape);
				} catch (ShapeException e) {
					System.err.println("Problème creation shape :" + e.getMessage());
				}
				
			}

			Affichage.afficherFormes(listeShapes);
			
					
		}
		
//		try {
//			listeShapes.add(new Rectangle(20, 10));
//			listeShapes.add(new Rectangle(0, 10));
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//		try {
//			listeShapes.add(new Circle(1));
//			listeShapes.add(new Circle(-1));
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//		try {
//			listeShapes.add(new Square(0));
//			listeShapes.add(new Square(5));
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//		try {
//			listeShapes.add(new Triangle(10, 5, 10));
//			listeShapes.add(new Triangle(10, 20, 1));
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//		try {
//			listeShapes.add(new RegularPolygon(8, 2, 5));
//			listeShapes.add(new RegularPolygon(500, 1));
//			listeShapes.add(new RegularPolygon(2, 1));
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		

	}

	public static void afficherFormes(final List<IShape> listeShape) {
		
		StringBuffer str = new StringBuffer();
		
		str.append("======================================================================================\n");
		
		float somme = 0;
		for (IShape shape : listeShape) {
			str.append(shape.getClass().getSimpleName());
			str.append(" : ( ");
			for (String param  : shape.listerParameters()) {
				str.append(param);
				str.append(" ");
			}
			str.append("), ");
			str.append(ShapeTest.printPerimeter(shape));
			str.append(", ");
			str.append(ShapeTest.printAreaOf(shape));
			str.append("\n");
			somme += shape.area();
		}

		str.append("\nSomme des aires des Formes = ");
		str.append(String.valueOf(somme));
		str.append("\n======================================================================================\n");
		System.err.println(str.toString());
	}

}
