package fr.imie.cdi13.training.poo.tp2.dav;

import java.util.ArrayList;
import java.util.List;

public class Square extends Rectangle {

	public Square() {
		
	}
	
//	private Square(float...value) {
//		super(value[0], value[0]);
//	}
	
//	public Square(float width) {
//		super(width, width);
//	}

	public static List<String> parameters() {
		List<String> liste = new ArrayList<>();
		liste.add("width");
		return liste;
	}

	@Override
	public List<String> listerParameters() {
		List<String> liste = new ArrayList<>();
		liste.add("width=" + this.getWidth());
		return liste;
	}
	
	@Override
	public void initShape(float... value) {
		this.setWidth(value[0]);
		this.setHeight(value[0]);
	}
	
}
