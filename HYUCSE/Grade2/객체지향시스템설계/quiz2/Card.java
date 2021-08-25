package quiz2;

public class Card implements Comparable<Card> {
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
		return symbol;
	}

	public void setSymbol(int symbol) {
		this.symbol = symbol;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public boolean equals(Card anotherCard) {
		return this.symbol == anotherCard.symbol && this.number == anotherCard.number;
	}
	
	public String toString() {
		switch(symbol) {
		case 0:
			return "Clubs, " + number;
		case 1:
			return "Diamonds, " + number;
		case 2:
			return "Hearts, " + number;
		case 3:
			return "Spades, " + number;
		default:
			return null;
		}
	}

	@Override
	public int compareTo(Card o) {
		// TODO Auto-generated method stub
		if(this.number > o.getNumber()) return 1;
		else if(this.number < o.getNumber()) return -1;
		else {
			if(this.symbol > o.getSymbol()) return 1;
			else if(this.symbol < o.getSymbol()) return -1;
		}
		return 0;
	}
	

}
