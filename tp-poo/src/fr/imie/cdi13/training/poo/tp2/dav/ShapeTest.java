package fr.imie.cdi13.training.poo.tp2.dav;

public class ShapeTest {
	
	public static void main(String[] args) {
		
		//Rectangle
		try {
			Rectangle rectangle = new Rectangle(20,10);
			ShapeTest.printAreaOf(rectangle);
			ShapeTest.printPerimeter(rectangle);
			
			rectangle = new Rectangle(0,10);
			ShapeTest.printAreaOf(rectangle);
			ShapeTest.printPerimeter(rectangle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		// Circle
		try {
			Circle  circle = new Circle(10);		
			ShapeTest.printAreaOf(circle);
			ShapeTest.printPerimeter(circle);
			
			circle = new Circle(-1);		
			ShapeTest.printAreaOf(circle);
			ShapeTest.printPerimeter(circle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// Square
		try {
			
			Square  square = new Square(0);		
			ShapeTest.printAreaOf(square);
			ShapeTest.printPerimeter(square);
			
			square = new Square(5);		
			ShapeTest.printAreaOf(square);
			ShapeTest.printPerimeter(square);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// Triangle
		try {
			Triangle triangle = new Triangle(10,5,10);		
			ShapeTest.printAreaOf(triangle);
			ShapeTest.printPerimeter(triangle);
			
			triangle = new Triangle(10,20,1);		
			ShapeTest.printAreaOf(triangle);
			ShapeTest.printPerimeter(triangle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// RegularPolygon
		try {
			//RectugalarPolygon
			RegularPolygon  regularPolygon = new RegularPolygon(8,2,5);		
			ShapeTest.printAreaOf(regularPolygon);
			ShapeTest.printPerimeter(regularPolygon);
			
			//RectugalarPolygon
			regularPolygon = new RegularPolygon(500,1);	
			ShapeTest.printAreaOf(regularPolygon);
			ShapeTest.printPerimeter(regularPolygon);
			
			//RectugalarPolygon
			regularPolygon = new RegularPolygon(2,1);	
			ShapeTest.printAreaOf(regularPolygon);
			ShapeTest.printPerimeter(regularPolygon);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void printAreaOf(final Shape s) {
		System.out.println(s.getClass().getName() + "  " + String.format("aire : %f", s.area()));
	}
	
	public static void printPerimeter(final Shape s) {
		System.out.println(String.format(s.getClass().getName() + "  " + "perimetre: %f", s.perimeter()));
	}
}
