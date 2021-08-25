package quiz1;

import java.util.Random;
import quiz1.Card;

public class Participant {
	private String name;
	private Card card;
	private int point;
	
	Random rand = new Random();
	
	
	public Participant(String name) {
		this.name = name;		
		this.card = new Card(rand.nextInt(4), (rand.nextInt(13)+1));
		this.point = 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Card getCard() {
		Card newCard = new Card(this.card.getSymbol(), this.card.getNumber());
		return newCard;
	}
	
	public int getPoint() {
		return this.point;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCard(Card card) {
		Card newCard = new Card(card.getSymbol(), card.getNumber());
		this.card = newCard;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}
	
	public void addPoint(int point) {
		this.point += point;
	}
	
	public void changeCard() {
		this.card = new Card(rand.nextInt(4), (rand.nextInt(13)+1));
	}
	
	public String toString() {
		return this.name + " has " + this.card.toString() + "(point: " + this.point + ")";
	}
	
}
