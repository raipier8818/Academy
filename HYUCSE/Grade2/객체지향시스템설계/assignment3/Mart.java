package assignment3;

import java.util.ArrayList;

public class Mart extends InventoryManager{
	private ArrayList<Product> salesList = new ArrayList<Product>();
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	
	
	public static int transaction = 1000;
	
	private volatile static Mart manager;
	
	public static Mart getInstance() {
		if(manager == null) {
			synchronized (Mart.class) {
				if(manager == null) manager = new Mart();
			}
		}
		
		return manager;
	}
	

	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	
	public void deleteObserver(Observer observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers() {
		for(int i = 0; i < observers.size(); i++) {
			observers.get(i).update(this.getInstance());
		}
	}


	public ArrayList<Product> getSalesList() {
		return salesList;
	}


	public void setSalesList(ArrayList<Product> salesList) {
		this.salesList = salesList;
	}


	public ArrayList<Observer> getObservers() {
		return observers;
	}


	public void setObservers(ArrayList<Observer> observers) {
		this.observers = observers;
	}
}
