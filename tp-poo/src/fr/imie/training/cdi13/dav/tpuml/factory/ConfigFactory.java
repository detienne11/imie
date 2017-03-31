package fr.imie.training.cdi13.dav.tpuml.factory;

public class ConfigFactory {

	private static ConfigFactory instance = null;

	private ConfigFactory() {
	}

	public final static ConfigFactory getInstance() {
		if (ConfigFactory.instance == null) {
			ConfigFactory.instance = new ConfigFactory();
		}
		return ConfigFactory.instance;
	}

	public Config createConfig(Config.CONFIG_TYPE type) {

		Config config = null;

		if (type == Config.CONFIG_TYPE.JSON) {
			config = new JsonConfig();
		} else if (type == Config.CONFIG_TYPE.XML) {
			config = new XmlConfig();
		} else {
			throw new IllegalArgumentException("Config type undefined");
		}

		return config;
	}

}
