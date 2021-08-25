package assignment3;

public class Product {
	private String name;
	private int price;
	private int quantity;
	
	public Product(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Product(Product other, int quantity) {
		this.name = other.name;
		this.price = other.price;
		this.quantity = quantity;
	}
	
	public Product(Product other) {
		this.name = other.name;
		this.price = other.price;
		this.quantity = other.quantity;
	}
	
	public boolean equals(Product other) {
		return this.name.equals(other.getName()) && (this.price == other.getPrice());
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
