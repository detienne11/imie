package fr.imie.cdi13.training.poo.tp2.dav;

import java.util.ArrayList;
import java.util.List;

public class RegularPolygon extends Shape {
	
	private List<Triangle> listeTriangle;
	
	public RegularPolygon(float nbCote, float longueurCote, float rayon) {
		listeTriangle = new ArrayList<>();
		
		for (int i = 0; i < nbCote; i++) {
			Triangle triangle = new Triangle(rayon, rayon, longueurCote);
			listeTriangle.add(triangle);
		}		
	}
	
	public RegularPolygon(float nbCote, float rayon) {
		
		if (nbCote < 3) {
			throw new IllegalArgumentException("RegularPolygon : un polygone regulier a au moins 3 cotés !");
			
		}
		
		listeTriangle = new ArrayList<>();
		
		float s = 2 * rayon * (float) Math.sin((Math.PI / nbCote));
		
		for (int i = 0; i < nbCote; i++) {
			Triangle triangle = new Triangle(rayon, rayon, s);
			listeTriangle.add(triangle);
		}		
	}

	@Override
	public float area() {
		float area = 0;
		for (Triangle triangle : listeTriangle) {
			area += triangle.area();
		}
		return area;
	}

	@Override
	public float perimeter() {
		float perimeter = 0;
		for (Triangle triangle : listeTriangle) {
			perimeter += triangle.getSide3();
		}
		return perimeter;
	}

}
