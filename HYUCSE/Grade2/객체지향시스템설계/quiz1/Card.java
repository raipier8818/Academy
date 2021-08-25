package quiz1;

public class Card {
	private int symbol;
	private int number;
	
	public Card(int symbol, int number) {
		this.symbol = symbol;
		this.number = number;
	}
	
	public Card(Card aCard) {
		this.symbol = aCard.symbol;
		this.number = aCard.number;
	}
	
	public int getSymbol() {
		return this.symbol;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public void setSymbol(int symbol) {
		this.symbol = symbol;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public boolean equals(Card anotherCard) {
		if(this.symbol == anotherCard.symbol && this.number == anotherCard.number) return true;
		return false;
	}
	
	public String toString() {
		String symbolString = "";
		if(this.symbol == 0) symbolString = "Clubs";
		if(this.symbol == 1) symbolString = "Diamonds";
		if(this.symbol == 2) symbolString = "Hearts";
		if(this.symbol == 3) symbolString = "Spades";
		
		return symbolString + ", " + this.number;
	}
	
	public static int compareCard(Card cardA, Card cardB) {
		if(cardA.number > cardB.number) return -1;
		else if(cardA.number < cardB.number) return 1;
		else return 0;
	}
}
