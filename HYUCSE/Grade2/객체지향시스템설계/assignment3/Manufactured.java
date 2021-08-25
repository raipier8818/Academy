package assignment3;

public class Manufactured extends Product{
	public String brand;
	
	public Manufactured(String name, int price, String brand, int quantity) {
		super(name,price,quantity);
		this.brand = brand;
	}
	
	public Manufactured(Manufactured other, int quantity) {
		super(other.getName(), other.getPrice(), quantity);
		this.brand = brand;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
}
