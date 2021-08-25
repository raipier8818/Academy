package assignment2;

public class ArrayFullException extends Exception{
	private int number;
	
	public ArrayFullException(int number) {
		super("Array Full Exception");
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
}
