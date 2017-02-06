package fr.imie.training.cdi13.dav.thread.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {

		final Scanner sc = new Scanner(System.in);

		try (Socket socket = new Socket("127.0.0.1", 8080);
				PrintWriter writer = new PrintWriter(socket.getOutputStream());
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {

//			socket.setKeepAlive(true);

			String request = null;
			String response = null;
			while (!"exit".equals(request)) {
				System.out.print("Saisissez votre message : \n");
				request = sc.nextLine();
				writer.println(request);
				writer.flush();
	
				System.out.format("Client Request: %s\n", request);
			}

//			while ((response = reader.readLine()) != null) {
//				System.out.format("Server Response: %s\n", response);
//
//			}


		} catch (IOException e) {
			System.err.println("Exception : Client Side ");
			e.printStackTrace();
		} finally {
			System.out.format("Client Stopped !\n");
			sc.close();
		}
		

	}

}
