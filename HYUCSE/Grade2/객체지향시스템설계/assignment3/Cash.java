package assignment3;

public class Cash implements Payable{
	private String currency;
	private int amount;
	
	
	public Cash(String currency, int amount) {
		this.currency = currency;
		this.amount = amount;
	}
	
	public void pay(int amount) {
		if(this.amount - amount < 0) return;
		this.amount -= amount;
	}
	

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	
	
}
