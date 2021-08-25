package assignment3;

public class InvalidAccessException extends Exception {
	private int num;
	
	public InvalidAccessException(int num) {
		super("Invalid Access Exception");
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}
}
