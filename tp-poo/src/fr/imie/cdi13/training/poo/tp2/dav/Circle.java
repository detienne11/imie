package fr.imie.cdi13.training.poo.tp2.dav;

public class Circle extends Shape {

	private float radius;
	
	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	public Circle(float radius) {
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
		float perimeter = (float) (2 * Math.PI * this.getRadius());
		return perimeter;
	}

}
