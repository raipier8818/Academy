package lab13;

import java.util.*;

public class DigitObserver implements Observer{
	private NumberGenerator num;
	
	public DigitObserver(NumberGenerator num) {
		this.num = num;
		num.addObserver(this);
	}
	
	public void update(NumberGenerator generator) {
		System.out.println("DigitObserver: " + generator.getNumber());
	
		try {
			Thread.sleep(100);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
