package assignment2;

public class ExtremeActivity extends Activity{
	private int minHeight;
	private int minWeight;
	
	public ExtremeActivity(String name, String location, int price, int minHeight, int minWeight) {
		super(name, location, price);
		this.minHeight = minHeight;
		this.minWeight = minWeight;
	}
	
	
	
	public int getMinHeight() {
		return minHeight;
	}



	public void setMinHeight(int minHeight) {
		this.minHeight = minHeight;
	}



	public int getMinWeight() {
		return minWeight;
	}



	public void setMinWeight(int minWeight) {
		this.minWeight = minWeight;
	}



	public int getActualPrice(Person person) {
		if(person.getAge() >= 60) return (int)(this.getPrice()*1.3);
		return this.getPrice();
	}
}
