package fr.imie.training.cdi13.dav.tptests.calcul;

public class CalculatriceImpl implements Calculatrice {

	private Engine engine = null;
	
	private Boolean state = true;

	public CalculatriceImpl() {
		super();
	}
	
	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Override
	public Boolean appuiTouche(String touche) {
		if (this.state){
			this.state = engine.setCharacter(touche);
		}
		return this.state;
	}

	@Override
	public String lire() {
		if (this.state){
			return engine.getDisplay();
		}
		else {
			return "ERREUR";
		}		
	}

	@Override
	public void reset() {
		this.state = true;
	}

}
