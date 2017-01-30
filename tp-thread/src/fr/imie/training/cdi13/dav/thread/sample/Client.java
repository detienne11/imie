package fr.imie.training.cdi13.dav.thread.sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception {

		try (Socket socket = new Socket("127.0.0.1", 8080)) {

			PrintWriter writer = new PrintWriter(socket.getOutputStream());

			writer.println("bonjour");
			writer.println("au revoir");
			writer.flush();

			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println("client à recu du serveur : " + line);

				switch (line) {
				case "coucou":
//					writer.println("");
//					writer.flush();
					break;
				case "salut":
					// writer.println("");
					// writer.flush();
					break;
				}
			
			}

		}

	}

}
