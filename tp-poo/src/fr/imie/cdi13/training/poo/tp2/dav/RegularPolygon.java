package fr.imie.cdi13.training.poo.tp2.dav;

import java.util.ArrayList;
import java.util.List;

public class RegularPolygon  implements IShape {
	
	private float nbCote;
	
	private Triangle triangle;
	
	public RegularPolygon() {
		
	}
	
//	private RegularPolygon(float...value) {
//		this(value[0],value[1],value[2]);
//	}
//	
//	private RegularPolygon(float nbCote, float longueurCote, float rayon) {
//		
//		if (nbCote < 3) {
//			throw new IllegalArgumentException("RegularPolygon : un polygone regulier a au moins 3 cotés !");
//			
//		}
//		
//		this.nbCote = nbCote;
//		this.triangle = new Triangle(rayon, rayon, longueurCote);		
//	}
	
//	private RegularPolygon(float nbCote, float rayon) {
//		this(nbCote, 2 * rayon * (float) Math.sin((Math.PI / nbCote)), rayon);
//	}

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

	public static List<String> parameters() {
		List<String> liste = new ArrayList<>();
		liste.add("nbCote");
		liste.add("longueurCote");
		liste.add("rayon");
		return liste;
	}
	
	@Override
	public List<String> listerParameters() {
		List<String> liste = new ArrayList<>();
		liste.add("nbCote=" + this.nbCote);
//		liste.add("longueurCote," + this.triangle.()));
		liste.add("rayon=" + this.triangle.getSide3());
		return liste;
	}
	
	@Override
	public void initShape(float... value) {
		this.nbCote=value[0];
		this.triangle=new Triangle();
		this.triangle.initShape(value[2],value[2],value[3]);
	}
}
