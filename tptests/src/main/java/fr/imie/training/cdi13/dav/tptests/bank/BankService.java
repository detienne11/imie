package fr.imie.training.cdi13.dav.tptests.bank;

public interface BankService {

	public enum CURRENCY {EURO,DOLLARUS,POUND};
	
	public float getRate(CURRENCY currency);
}
