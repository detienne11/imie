package fr.imie.training.cdi13.dav.tpinject.exo1;

public class EmailService {

	public void sendEmail(String msg, String sendTo) {
		System.out.println("Email sent to " + sendTo + " with	Message=" + msg);
	}
}