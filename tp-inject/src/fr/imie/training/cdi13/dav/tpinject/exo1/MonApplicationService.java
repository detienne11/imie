package fr.imie.training.cdi13.dav.tpinject.exo1;

public class MonApplicationService {

	// forte dependance avec EmailService
	private EmailService email = new EmailService();

	public void processMessages(String msg, String sendTo) {
		email.sendEmail(msg, sendTo);
	}
}
