package quiz2;

public class BadNumException extends Exception{
	private int badNumber;
	
	public BadNumException() {
		super("Bad Number");
	}
	
	public BadNumException(String message) {
		super(message);
	}
	
	public BadNumException(int num) {
		super("Bad Number");
		this.badNumber = num;
	}
	
	public int getBadNumber() {
		return badNumber;
	}
}
