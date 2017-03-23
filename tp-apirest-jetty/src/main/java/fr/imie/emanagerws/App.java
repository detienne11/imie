package fr.imie.emanagerws;

import fr.imie.emanagerws.config.Config;
import fr.imie.emanagerws.resource.ContactResource;
import fr.imie.emanagerws.service.Service;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class App extends Application<Config>{

    // The service layer
    private final Service service;

    public App(){
        // Getting the service layer
        this.service = new Service();
    }

    @Override
    public void initialize(final Bootstrap<Config> config) {
        
    }

    @Override
    public void run(final Config config, final Environment environment) throws Exception {
    	ContactResource contactResource = new ContactResource(service);
    	environment.jersey().register(contactResource);
    }

    public static void main (String args []) throws Exception {
        new App().run(args);
    }
}
