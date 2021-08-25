package lab12;


public class Buffer {
	private int loc = 0;
	private double[] data;
	
	public Buffer(int size) {
		this.data = new double[size];
	}
	
	public int getSize() {
		return data.length;
	}
	
	public synchronized void add(double toAdd) throws InterruptedException{
		if(loc >= data.length) {
			System.out.println("Buffer is full");
			wait();
		}
		System.out.println("Adding item " + toAdd);
		data[loc++] = toAdd;
		notifyAll();
	}
	
	public synchronized double remove() throws InterruptedException{
		if(loc <= 0) {
			System.out.println("Buffer is empty");
			wait(); 
		}
		
		double returnVal = data[--loc];
		System.out.println("Removing item : " + data[loc]);
		data[loc] = 0.0;
		return returnVal;
	}
	
}
