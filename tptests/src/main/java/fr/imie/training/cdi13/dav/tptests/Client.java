package fr.imie.training.cdi13.dav.tptests;

public class Client {

	private String type;
	
	public float encours;
	
	public Client(String type, float encours) {
		super();
		this.type = type;
		this.encours = encours;
	}

	public boolean accept(float montant) {
		
		boolean refuse = false;
		
		System.out.println("Client accept type" + type);
		
		if ("S".equals(type)) {
			if (montant > 5000
					|| (montant > 1000 && this.encours > 1000)) {
				refuse = true;
			}
		}
		else if ("P".equals(type)) {
			if (montant > 5000 && this.encours > 3000) {
				refuse = true;
			}
		}
		else if ("N".equals(type)) {
			if ((montant > 5000 && this.encours >= 1000 && this.encours <= 3000)
					|| (montant > 1000 && this.encours > 3000)) {
				refuse = true;
			}
		}
		
		return !refuse;
		
	}

}
