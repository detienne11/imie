package fr.imie.training.cdi13.dav.tptests;

public class Addition {

	public Addition() {
		super();
	}
	
	public long calculer(long op1, long op2) {
		return op1 + op2;
	}
	
	public String lireSymbole() {
		return "+";
	}
	
	public long  method1(long param){
		if (param > 10){
			throw new IllegalArgumentException("parametre d'entree invalide");
		}
		else {
			return param;
		}
	}
	
	public void  method2(){
		try {
			Thread.sleep(2000);
		} catch (Throwable e) {
		}
	}
	
	public boolean dateValide(int j, int m , int a){
		throw new RuntimeException("not implemented");
	}
}
