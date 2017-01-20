package fr.imie.cdi13.training.poo.tp2.dav;

public class RegularPolygon extends Shape {
	
	private float nbCote;
	
	private Triangle triangle;
	
	public RegularPolygon(float...value) {
		this(value[0],value[1],value[2]);
	}
	
	private RegularPolygon(float nbCote, float longueurCote, float rayon) {
		
		if (nbCote < 3) {
			throw new IllegalArgumentException("RegularPolygon : un polygone regulier a au moins 3 cotés !");
			
		}
		
		this.nbCote = nbCote;
		this.triangle = new Triangle(rayon, rayon, longueurCote);		
	}
	
	public RegularPolygon(float nbCote, float rayon) {
		this(nbCote, 2 * rayon * (float) Math.sin((Math.PI / nbCote)), rayon);
	}

	@Override
	public float area() {
		float area = this.triangle.area() * this.nbCote;
		return area;
	}

	@Override
	public float perimeter() {
		float perimeter = this.triangle.getSide3()* this.nbCote;		
		return perimeter;
	}

}
