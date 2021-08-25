package assignment3;

public abstract class InventoryManager {
	public abstract void addObserver(Observer observer);
	public abstract void deleteObserver(Observer observer);
	public abstract void notifyObservers();
}
