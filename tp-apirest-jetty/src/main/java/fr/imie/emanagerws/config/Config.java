package fr.imie.emanagerws.config;

import io.dropwizard.Configuration;

public class Config extends Configuration{
	private String defaultName = "EManagerWS";

	public String getDefaultName() {
		return defaultName;
	}

	public void setDefaultName(String defaultName) {
		this.defaultName = defaultName;
	}
	
	
}
