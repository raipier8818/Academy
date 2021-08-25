package assignment3;

public class NotEnoughBalanceException extends Exception{
	private int enoughPrice;
	
	public NotEnoughBalanceException(int enoughPrice) {
		super(enoughPrice + " won is not enough.");
		this.enoughPrice = enoughPrice;
	}
	
	public int getEnoughPrice() {
		return enoughPrice;
	}
}
