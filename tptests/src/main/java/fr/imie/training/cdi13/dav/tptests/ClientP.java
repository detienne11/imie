package fr.imie.training.cdi13.dav.tptests;

public class ClientP extends Client {

	public ClientP(float encours) {
		super("P", encours);
	}

	public boolean accept(float montant) {
		
		boolean refuse = false;
		System.out.println("ClientP accept");
		
		if (montant > 5000 && this.encours > 3000) {
			refuse = true;
		}
		
		return !refuse;		
	}
	
}
