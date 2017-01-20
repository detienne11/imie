package fr.imie.cdi13.training.poo.tp2.dav;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Affichage {

	public static void start() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Quel forme voulez vous créer ?");
		for (EShape elt : EShape.values()) {
			System.out.println("\t- " + elt.ordinal() + " : " + elt.getNom());
		}

		boolean selection = false;
		while (!selection) {

			String reponse = sc.nextLine();

			List<String> listeParameters = null;

			if (Pattern.matches("^\\d+$", reponse)) {

				switch (Integer.valueOf(reponse).intValue()) {
				case 1:
					// Rectangle
					listeParameters = Rectangle.parameters();
					break;

				case 2:
					// Circle
					// listeParameters = Circle.parameters();
					break;

				case 3:
					// Square
					listeParameters = Square.parameters();
					break;

				case 4:
					// Triangle
					listeParameters = Triangle.parameters();
					break;

				case 5:
					// Regular Polygon
					// listeParameters = RegularPolygon.parameters();
					break;
				}
			}

			if (listeParameters != null) {
				selection = true;
				StringBuffer str = new StringBuffer();
				for (String param : listeParameters) {
					str.append("param : ");
					str.append(param);
					str.append("\n");
					System.out.println(str.toString());
				}
			} else {
				System.err.println("Le choix est incorrect");
			}
		}
		
		sc.close();

		List<IShape> listeShapes = new ArrayList<>();

		try {
			listeShapes.add(new Rectangle(20, 10));
			listeShapes.add(new Rectangle(0, 10));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			listeShapes.add(new Circle(1));
			listeShapes.add(new Circle(-1));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			listeShapes.add(new Square(0));
			listeShapes.add(new Square(5));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			listeShapes.add(new Triangle(10, 5, 10));
			listeShapes.add(new Triangle(10, 20, 1));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			listeShapes.add(new RegularPolygon(8, 2, 5));
			listeShapes.add(new RegularPolygon(500, 1));
			listeShapes.add(new RegularPolygon(2, 1));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		for (IShape shape : listeShapes) {
			ShapeTest.printAreaOf(shape);
			ShapeTest.printPerimeter(shape);
		}

		Affichage.printAreaSum(listeShapes);

	}

	public static void printAreaSum(final List<IShape> listeShape) {

		float somme = 0;
		for (IShape shape : listeShape) {
			somme += shape.area();
		}

		System.out.println("Somme des aires des Formes = " + String.valueOf(somme));
	}

}
