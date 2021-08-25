package quiz2;

import java.util.*;

public class SortCard {
	
	
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Random rand = new Random();
		
		int size = 0;
		try {

			System.out.print("Enter the length of array : ");
			size = keyboard.nextInt();
			if(size <= 0) throw new BadNumException(size);
				
		} catch (BadNumException e) {
			System.out.println(e.getMessage() + ", " + e.getBadNumber() + " cannot be used.");
			System.out.print("Enter number again : ");
			size = keyboard.nextInt();
			
		}

		System.out.println("--------------------------------");
		
		Card[] cardArray = new Card[size];
		
		for(int i = 0; i < size; i++) {
			cardArray[i] = new Card(rand.nextInt(4), rand.nextInt(13) + 1);
			System.out.println(cardArray[i].toString());
		}
		
		System.out.println("--------------------------------");
		Arrays.sort(cardArray);
		for(int i = 0; i < size; i++) {
			System.out.println(cardArray[i].toString());
		}

		System.out.println("--------------------------------");
		ArrayList<Card> cardArrayList = new ArrayList<Card>();
		for(Card card : cardArray) {
			cardArrayList.add(card);
		}
		
		System.out.print("Enter the number to increase : ");
		int incNum = keyboard.nextInt();

		System.out.println("--------------------------------");
		
		for(int i = 0; i < incNum; i++) {
			Card newCard = new Card(rand.nextInt(4), rand.nextInt(13) + 1);
			int index = 0;
			for(Card card : cardArrayList) {
				if(card.compareTo(newCard) > 0) {
					cardArrayList.add(index,newCard);
					break;
				}
				index++;
			}
			
			if(index == cardArrayList.size()) cardArrayList.add(newCard);
		}

		for(Card card : cardArrayList) System.out.println(card.toString());

	
	}
}
