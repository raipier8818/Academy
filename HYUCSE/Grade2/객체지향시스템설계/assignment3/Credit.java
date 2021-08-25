package assignment3;

public class Credit implements Payable{
	private String bank;
	private int limit;
	private int amountUsed;
	
	public Credit(String bank, int limit, int amountUsed) {
		this.bank = bank;
		this.limit = limit;
		this.amountUsed = amountUsed;
	}
	
	public void pay(int price) {
		if((amountUsed + price) > limit) return;
		amountUsed += price;
	}
	
	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getAmountUsed() {
		return amountUsed;
	}

	public void setAmountUsed(int amountUsed) {
		this.amountUsed = amountUsed;
	}
}
