package fr.imie.cdi13.training.poo.tp2.dav;

public class ShapeTest {
	
	public static void main(String[] args) {
		
		Affichage.start();
		Affichage.stop();
		
	}
	
	public static String printAreaOf(final IShape s) {
		return String.format("aire = %f", s.area());
	}
	
	public static String printPerimeter(final IShape s) {
		return String.format("perimetre = %f", s.perimeter());
	}

}
