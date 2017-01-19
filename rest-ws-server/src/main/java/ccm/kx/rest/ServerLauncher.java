package ccm.kx.rest;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Logger;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class ServerLauncher {

    public static void main(String[] args) throws IOException {
        URI uri = URI.create("http://localhost:8080/");
        ResourceConfig configuration = new ResourceConfig().packages("ccm.kx.rest");
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, configuration);

        Logger.getGlobal().info("\n\tPress Enter to shutdown server.\n");
        System.in.read();

        server.shutdownNow();
    }
}
