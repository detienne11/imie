package fr.imie.training.cdi13.dav.tpuml;
public class Singleton {
	
	private static Singleton instance = null;

	private Singleton() {}

	public final static Singleton getInstance() {
		if (Singleton.instance == null) {
			Singleton.instance = new Singleton();
		}
		return Singleton.instance;
	} 
	
	public String method() {
		return "Hello singleton";
	}
	
}
