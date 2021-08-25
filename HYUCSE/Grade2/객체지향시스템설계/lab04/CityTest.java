package lab04;

public class CityTest {
	public static void main(String[] args) {
		city[] cities = new city[4];
		
		cities[0] = new city("Seoul", 23, 45);
		cities[1] = new city("Paris", 123, 41);
		cities[2] = new city("Racoon City");
		cities[3] = new city("Mega city");
		
		
		for(int i = 0; i < 4; i++) {
			System.out.println(cities[i].toString());
		}
		

		System.out.println("Seoul-Paris : " + city.Method(cities[0], cities[1]));
		System.out.println("Seoul-Racoon City : " + city.Method(cities[0], cities[2]));
		System.out.println("Paris-Mega City : " + city.Method(cities[1], cities[3]));
		
	}
}
