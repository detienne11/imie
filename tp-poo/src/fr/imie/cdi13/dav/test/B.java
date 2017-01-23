package fr.imie.cdi13.dav.test;

public class B extends A {

	private String a = "test a";
	
	@Override
	public AInterface function1(String value) {
<<<<<<< HEAD
		// new commentaire
=======
>>>>>>> branch 'master' of https://github.com/detienne11/imie.git
		return  new B();
		
	}

	@Override
	public String toString() {		
		return this.a + ' ' + super.toString();
	}
	
	

}
