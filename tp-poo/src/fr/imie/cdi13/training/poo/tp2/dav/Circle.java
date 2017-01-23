package fr.imie.cdi13.training.poo.tp2.dav;

import java.util.ArrayList;
import java.util.List;

public class Circle implements IShape {

	private float radius;
	
	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	public Circle(float...value) {
		this(value[0]);
	}
	
	private Circle(float radius) {
		if (radius <=0) {
			throw new IllegalArgumentException("Circle : Un cercle ne peut avoir qu'un rayon supérieur à zéro");			
		}
		this.radius = radius;
	}

	@Override
	public float area() {
		float area = (float) (Math.PI * Math.pow(this.getRadius(), 2));
		return area;
	}

	@Override
	public float perimeter() {
		Double d = Double.valueOf(2 * Math.PI * this.getRadius());
		return d.floatValue();
	}
	
	public static List<String> parameters() {
		List<String> liste = new ArrayList<>();
		liste.add("radius");
		return liste;
	}
	
	@Override
	public List<String> listerParameters() {
		List<String> liste = new ArrayList<>();
		liste.add("radius=" + this.radius);
		return liste;
	}
	
	@Override
	public void initShape(float... value) {
		this.radius=value[0];
	}

}
