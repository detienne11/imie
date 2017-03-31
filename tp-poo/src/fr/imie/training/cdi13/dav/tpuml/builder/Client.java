package fr.imie.training.cdi13.dav.tpuml.builder;

public class Client {

	public static void main(String[] args) {		
		CountryBuilder builder = new CountryBuilder();
		
		builder.widthName("Nantes").widthArea(10);
		Country country = builder.build();
		System.out.println(country);
	}

}
