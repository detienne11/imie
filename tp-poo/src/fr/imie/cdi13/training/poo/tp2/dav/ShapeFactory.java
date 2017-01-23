package fr.imie.cdi13.training.poo.tp2.dav;

import java.util.List;

public class ShapeFactory {
	
	
	private static ShapeFactory instance = null;
	
	private ShapeFactory() {
		
	}
	
	public static ShapeFactory getInstance() {
		if (ShapeFactory.instance == null){
			ShapeFactory.instance = new ShapeFactory();
		}
		return ShapeFactory.instance;
	}

	public IShape creerShape(EShape typeShape, float[] values) throws ShapeException {

		IShape shape = null;

		switch (typeShape.ordinal()) {
		case 0:
			// Rectangle
			shape = new Rectangle();
			break;

		case 1:
			// Circle
			shape = new Circle();
			break;

		case 2:
			// Square
			shape = new Square();
			break;

		case 3:
			// Triangle
			shape = new Triangle();
			break;

		case 4:
			// Regular Polygon
			shape = new RegularPolygon();
			break;

		}

		shape.initShape(values);
		return shape;

	}

	public List<String> listerParameters(EShape typeShape) {

		List<String> listeParameters = null;

		switch (typeShape.ordinal()) {
		case 0:
			// Rectangle
			listeParameters = Rectangle.parameters();
			break;

		case 1:
			// Circle
			listeParameters = Circle.parameters();
			break;

		case 2:
			// Square
			listeParameters = Square.parameters();
			break;

		case 3:
			// Triangle
			listeParameters = Triangle.parameters();
			break;

		case 4:
			// Regular Polygon
			listeParameters = RegularPolygon.parameters();
			break;

		}
		return listeParameters;

	}

}
