package fr.imie.training.cdi13.dav.thread.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {

		ServerSocket server = new ServerSocket(8080);

		while (server.isClosed() == false) {
			try (Socket socket = server.accept()) {
				// new Thread( ).start()

				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter writer = new PrintWriter(socket.getOutputStream());
				
				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println("serveur - recu :" + line);

					switch (line) {
					case "bonjour":
						writer.println("coucou");
						writer.flush();
						break;
					case "au revoir":
						writer.println("salut");
						writer.flush();
						break;
					}
				
				}

			}
		}

	}

}
