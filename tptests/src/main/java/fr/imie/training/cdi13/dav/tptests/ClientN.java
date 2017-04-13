package fr.imie.training.cdi13.dav.tptests;

public class ClientN extends Client {

	public ClientN(float encours) {
		super("N", encours);
	}
	
	public boolean accept(float montant) {
		
		boolean refuse = false;
		System.out.println("ClientN accept");
		
		if ((montant > 5000 && this.encours >= 1000 && this.encours <= 3000)
				|| (montant > 1000 && this.encours > 3000)) {
			refuse = true;
		}
		
		return !refuse;		
	}

}
