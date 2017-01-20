package fr.imie.cdi13.training.poo.tp2.dav;

public class ShapeTest {
	
	public static void main(String[] args) {
		
		Affichage.start();
		
	}
	
	public static void printAreaOf(final IShape s) {
		System.out.println(s.getClass().getSimpleName() + "  " + String.format("aire : %f", s.area()));
	}
	
	public static void printPerimeter(final IShape s) {
		System.out.println(String.format(s.getClass().getSimpleName() + "  " + "perimetre: %f", s.perimeter()));
	}
}
