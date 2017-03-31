package fr.imie.training.cdi13.dav.tpuml.factory;

import fr.imie.training.cdi13.dav.tpuml.factory.Config.CONFIG_TYPE;

public class Client {

	public static void main(String[] args) {
		
		ConfigFactory factory = ConfigFactory.getInstance();
		Config conf = factory.createConfig(CONFIG_TYPE.JSON);		
		System.out.println(conf.getName());
		
		conf = factory.createConfig(CONFIG_TYPE.XML);		
		System.out.println(conf.getName());

	}

}
