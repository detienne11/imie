package fr.imie.training.cdi13.dav.appjee.bl.domain;

public class Parent extends Person {

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getType() {
		return Integer.valueOf(2);
	}
	
}
