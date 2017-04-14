package fr.imie.training.cdi13.dav.tptests.bank;

public class BankAccount {

	public BankAccount() {
		// TODO Auto-generated constructor stub
	}

	private float amount = 0;

	private BankService bankService = null;

	public void setBankService(BankService bankService){
		this.bankService = bankService;
	}
	
	public void credit(float amount, BankService.CURRENCY currency) {
		float rate = bankService.getRate(currency);
		this.amount = this.amount + (rate * amount);
	}

	public void debit(float amount, BankService.CURRENCY currency) {
		float rate = bankService.getRate(currency);
		this.amount = this.amount - (rate * amount);
	}

	public Float getAmount() {
		return Float.valueOf(this.amount);
	}

}
