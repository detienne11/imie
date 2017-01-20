package fr.imie.cdi13.training.poo.tp2.dav;

import java.util.ArrayList;
import java.util.List;

public class Triangle extends Shape {

	private float side1;
	
	private float side2;
	
	private float side3;
	
	
	
	public float getSide1() {
		return side1;
	}

	public void setSide1(float side1) {
		this.side1 = side1;
	}

	public float getSide2() {
		return side2;
	}

	public void setSide2(float side2) {
		this.side2 = side2;
	}

	public float getSide3() {
		return side3;
	}

	public void setSide3(float side3) {
		this.side3 = side3;
	}

	public Triangle(float...value) {		
		this(value[0],value[1],value[2]);
	}
	
	private Triangle(float side1, float side2, float side3) {

		if (side1 <=0
				|| side2 <=0
				|| side3 <= 0) {
			throw new IllegalArgumentException("Triangle: Un triangle a des cotés supérieur à zéro");			
		}
		
		if ((side2 + side3) < side1
				|| (side1 + side3) < side2
				|| (side1 + side2) < side3) {
			throw new IllegalArgumentException("Triangle: Un coté ne peut etre supérieur à la la somme des 2 autres cotés");			
		}
		
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	@Override
	public float area() {
		float p = this.perimeter();
		float tmp = p * (p - this.getSide1())* (p - this.getSide2())* (p - this.getSide3());
		float area = (float) Math.sqrt(tmp);
		return area;
	}

	@Override
	public float perimeter() {
		float perimeter = (this.getSide1() + this.getSide2() + this.getSide3()) / 2;
		return perimeter;
	}

	public static List<String> parameters() {
		List<String> liste = new ArrayList<>();
		liste.add("side1");
		liste.add("side2");
		liste.add("side3");
		return liste;
	}
	
}
