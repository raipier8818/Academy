package lab10;

public class Program {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Tiger tiger = new Tiger();
		Turtle turtle = new Turtle();
		
		
		Animal[] animals = new Animal[3];
		animals[0] = dog;
		animals[1] = tiger;
		animals[2] = turtle;
		
		
		Person person = new Person() {
			private int hp = 100;
			
			public void control(Animal target) {
				if(target == null) return;
				if(target instanceof Tiger) hp -= 80;
				if(target instanceof Dog) hp -= 10;				
			
				System.out.println("You have overpowered the " + target.getClass().getSimpleName());
			}
			
			public void showInfo() {
				System.out.println("Person HP: " + hp);
			}
		};
	
		showResult(animals, person);
	
	}
	
	public static void showResult(Animal[] animals, Person person) {
		for (int animal = 0; animal < animals.length; animal++) {
			System.out.println("Animal" + animal + ":" + animals[animal].getName());
			if(animals[animal] instanceof Barkable) {
				if(animals[animal] instanceof Dog) {
					System.out.println("Animal " + animal + " barked " + ((Dog)animals[animal]).bark());
					person.control(animals[animal]);
				}
				if(animals[animal] instanceof Tiger) {
					System.out.println("Animal " + animal + " barked " + ((Tiger)animals[animal]).bark());
					person.control(animals[animal]);
				}
			}else {
				person.control(animals[animal]);
			}
			person.showInfo();
		}
	}
}
