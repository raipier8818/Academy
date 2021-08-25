package lab04;

import java.util.Random;

public class city {
	Random rnd = new Random();	
	private String name;
	private int locationX;
	private int locationY;
	

	public city(String name, int locationX, int locationY) {
		this.name = name;
		this.locationX = locationX;
		this.locationY = locationY;
	}
	
	public city(String name) {
		this.name = name;
		this.locationX = rnd.nextInt(361);
		this.locationY = rnd.nextInt(361);
	}

	public String getName() {
		return name;
	}

	public int getLocationX() {
		return locationX;
	}

	public int getLocationY() {
		return locationY;
	}
	
	public boolean equals(city other) {
		if(this.getName() == other.getName() && this.getLocationX() == other.getLocationX() && this.getLocationY() == other.getLocationY()) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		String cityInfo = this.name + ", " + locationX + ", " + locationY;
		return cityInfo;
	}
	
	public static double Method(city A, city B) {
		return Math.sqrt(Math.pow(A.getLocationX() - B.getLocationX(), 2) + Math.pow(A.getLocationY() - B.getLocationY(), 2));
	}
}
