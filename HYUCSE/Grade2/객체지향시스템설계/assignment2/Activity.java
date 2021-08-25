package assignment2;

public class Activity {
	private String name;
	private String location;
	private int price;
	
	public Activity(String name, String location, int price) {
		this.name = name;
		this.location = location;
		this.price = price;
	}
	
	public Activity(Activity other) {
		this.name = other.name;
		this.location = other.location;
		this.price = other.price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		return this.name + "(" + this.location + ", " + this.price + " won)";
	}
	
	public boolean equals(Activity other) {
		return this.name.equals(other.getName()) && this.location.equals(other.getLocation()) && this.price == other.getPrice();
	}
	
	public int getActualPrice(Person person) {
		return this.price;
	}
}
