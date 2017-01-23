package fr.imie.cdi13.training.poo.tp2.dav;

import java.util.List;

public interface IShape {

	public float area();
	
	public float perimeter();
	
	public List<String> listerParameters();
	
	public void initShape(float...value);
	
}
