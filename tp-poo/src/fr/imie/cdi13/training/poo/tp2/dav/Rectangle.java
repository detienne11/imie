package fr.imie.cdi13.training.poo.tp2.dav;

public class Rectangle extends Shape {

	private float width;
	
	private float height;
	
	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public Rectangle(float width, float height) {
		if (width <=0
				|| height <=0) {
			throw new IllegalArgumentException("Rectangle : Un rectangle a une largeur ou longueur supérieur à zéro");
			
		}
		this.width = width;
		this.height = height;
	}

	@Override
	public float area() {
		float area = this.getHeight() * this.getWidth();
		return area;
	}

	@Override
	public float perimeter() {
		float perimeter = (this.getHeight() + this.getWidth()) * 2;
		return perimeter;
	}

}
