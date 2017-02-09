package fr.imie.training.cdi13.dav.tpj2ee.bean;

import java.util.ArrayList;
import java.util.List;

public class ListBean {

	private List<Object> liste = new ArrayList<>();
	
	public void setChild(Object obj){
		this.liste.add(obj);
	}
	
	public Object [] toArray() {
		return this.liste.toArray();
	}
	
}
