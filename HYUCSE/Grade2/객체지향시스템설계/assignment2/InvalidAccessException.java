package assignment2;

public class InvalidAccessException extends Exception{
	private int number;
	
	public InvalidAccessException(int number) {
		super("Invalid Access Exception");
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
}
