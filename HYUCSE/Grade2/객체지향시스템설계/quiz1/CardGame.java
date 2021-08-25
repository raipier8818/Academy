package quiz1;

import java.util.Scanner;
import quiz1.Card;
import quiz1.Participant;

public class CardGame {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Player Name: ");
		String name = scan.nextLine();
		
		Participant A = new Participant(name);
		Participant dealer = new Participant("Dealer");
		
		System.out.println("------------------------");
		for(int i = 0; i < 3; i++) {
			System.out.println(dealer.toString());
			System.out.println(A.toString());
			
			if(A.getCard().getNumber() > dealer.getCard().getNumber()) A.addPoint(1);

			A.setCard(dealer.getCard());
			
			while(A.getCard().equals(dealer.getCard())) dealer.changeCard();

			System.out.println("------------------------");
		}
	
		System.out.println(A.getName() + ", " + A.getPoint() + " points");
	}
	
	
}
