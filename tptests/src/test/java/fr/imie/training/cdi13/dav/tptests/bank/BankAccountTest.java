package fr.imie.training.cdi13.dav.tptests.bank;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.imie.training.cdi13.dav.tptests.bank.BankService.CURRENCY;

public class BankAccountTest {

	@Test
	public void test() {
		BankAccountFTO bankAccountFTO = new BankAccountFTO();
		bankAccountFTO.setBankService(new BankServiceMock());
		
		bankAccountFTO.credit(1000, BankService.CURRENCY.EURO);
		assertEquals(Float.valueOf(1000),bankAccountFTO.getAmount());
		
		bankAccountFTO.debit(200, BankService.CURRENCY.EURO);
		assertEquals(Float.valueOf(800),bankAccountFTO.getAmount());
		
	}

}
