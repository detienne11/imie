package fr.imie.training.cdi13.dav.tptests;

public class ClientS extends Client {

	public ClientS(float encours) {
		super("S", encours);
	}

	public boolean accept(float montant) {
		
		boolean refuse = false;
		System.out.println("ClientS accept");
		
		if (montant > 5000
				|| (montant > 1000 && this.encours > 1000)) {
			refuse = true;
		}
		
		return !refuse;		
	}
	
}
