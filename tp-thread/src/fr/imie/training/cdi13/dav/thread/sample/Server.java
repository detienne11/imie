package fr.imie.training.cdi13.dav.thread.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {

	private Socket socket;

	public Server(Socket socket) {
		this.socket = socket;
	}

	public static void main(String[] args) {

		try (ServerSocket server = new ServerSocket(8080);) {

			while (server.isClosed() == false) {
				System.out.format("Waiting client ...\n");
				Socket socket = server.accept();
				Thread t = new Thread(new Server(socket));
				t.start();
			}

		} catch (IOException e) {
			System.err.println("Exception : Server Side ");
			e.printStackTrace();
		} finally {
			System.out.format("Serveur Stopped !\n");
		}

	}

	@Override
	public void run() {
		
		System.out.println("Client connected :" + this.socket.getRemoteSocketAddress().toString());
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
				PrintWriter writer = new PrintWriter(this.socket.getOutputStream());) {

			String request = null;
			String response = null;

			while ((request = reader.readLine()) != null) {
				System.out.format("Server receive : %s\n", request);

				// response = "message recu";
				// writer.println(response);
				// writer.flush();
				// System.out.format("Server response : %s\n", response);

			}

		} catch (IOException e) {
			System.err.println("Exception : Server Side ");
			e.printStackTrace();
		}

	}

}
