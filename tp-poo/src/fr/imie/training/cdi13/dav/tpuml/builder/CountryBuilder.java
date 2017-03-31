package fr.imie.training.cdi13.dav.tpuml.builder;

public class CountryBuilder {

	private Country country = null;
	
	public CountryBuilder(){
		country = new Country();
	}
	
	public Country build(){
		return this.country;
	}
	
	public CountryBuilder widthName(String name){
		this.country.setName(name);
		return this;
	}
	
	public CountryBuilder widthArea(long area) {
		this.country.setArea(area);
		return this;
	}
	
	public CountryBuilder widthPeopleNumber(int peopleNumber) {
		this.country.setPeopleNumber(peopleNumber);
		return this;
	}
	
}
