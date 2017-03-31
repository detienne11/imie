package fr.imie.training.cdi13.dav.tpuml.builder;

public class Country {

	private String name = null;
	
	private long area = 0;
	
	private int peopleNumber = 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getArea() {
		return area;
	}

	public void setArea(long area) {
		this.area = area;
	}

	public int getPeopleNumber() {
		return peopleNumber;
	}

	public void setPeopleNumber(int peopleNumber) {
		this.peopleNumber = peopleNumber;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", area=" + area + ", peopleNumber=" + peopleNumber + "]";
	}
	
	
}
