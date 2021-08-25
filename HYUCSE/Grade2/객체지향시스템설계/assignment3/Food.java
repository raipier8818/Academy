package assignment3;

import java.time.LocalDateTime;

public class Food extends Product{
	private LocalDateTime expirationDateTime;

	public Food(String name, int price, LocalDateTime expirationDateTime, int quantity) {
		super(name,price,quantity);
		this.expirationDateTime = expirationDateTime;
	}
	
	public Food(Food other, int quantity) {
		super(other.getName(), other.getPrice(), quantity);
		this.expirationDateTime = other.getExpirationDateTime();
	}
	
	public boolean isExpired(LocalDateTime present) {
		if(expirationDateTime.compareTo(present) < 0) return true;
		return false;
	}

	public LocalDateTime getExpirationDateTime() {
		return expirationDateTime;
	}

	public void setExpirationDateTime(LocalDateTime expirationDateTime) {
		this.expirationDateTime = expirationDateTime;
	}

	
}
