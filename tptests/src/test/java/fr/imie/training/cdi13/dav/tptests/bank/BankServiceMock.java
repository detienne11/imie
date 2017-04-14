package fr.imie.training.cdi13.dav.tptests.bank;

public class BankServiceMock implements BankService {

	@Override
	public float getRate(CURRENCY currency) {
		return 1;
	}

}
