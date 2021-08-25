package assignment2;

public class ShowActivity extends Activity{
	private int minAge;
	
	public ShowActivity(String name, String location, int price, int minAge) {
		super(name, location, price);
		this.minAge = minAge;
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	
	public int getActualPrice(Person person) {
		if(person.getAge() <= 19) return (int)(this.getPrice()*0.8);
		return this.getPrice();
	}
}
