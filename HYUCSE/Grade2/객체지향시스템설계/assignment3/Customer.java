package assignment3;


import java.util.*;

public class Customer implements Observer{
	private String name;
	private ArrayList<Payable> Wallet = new ArrayList<Payable>();
	private ArrayList<Product> shoppingCart = new ArrayList<Product>();

	private ArrayList<Product> pendedProducts = new ArrayList<Product>();
	
	private int totalPrice;
	
	public Customer(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getTotalPrice() {
		totalPrice = 0;
		for(Product temp : shoppingCart) {
			totalPrice += temp.getPrice()*temp.getQuantity(); 
		}
		return totalPrice;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean equals(Customer other) {
		return this.name.equals(other.getName());
	}
	
	public void update(InventoryManager generator) {
		 Mart mart = (Mart)generator;
		 for(int i = pendedProducts.size() - 1; i >= 0; i--) {
			 int j = 0;
			 for(; j < mart.getSalesList().size(); j++) {
				 if(mart.getSalesList().get(j).equals(pendedProducts.get(i))) break;
			 }
			 
			 Product target = mart.getSalesList().get(j);
			 
			 target.setQuantity(target.getQuantity() - pendedProducts.get(i).getQuantity());
			 
			 if(target.getQuantity() < 0) {
				 for(Product temp : shoppingCart) {
					 if(temp.equals(pendedProducts.get(i))) {
						 temp.setQuantity(temp.getQuantity() + target.getQuantity() + pendedProducts.get(i).getQuantity());
						 break;
					 }
				 }
				 pendedProducts.get(i).setQuantity(-1*target.getQuantity());
				 target.setQuantity(0);
			 }else {
				 for(Product temp : shoppingCart) {
					 if(temp.equals(pendedProducts.get(i))) {
						 temp.setQuantity(temp.getQuantity() + pendedProducts.get(i).getQuantity());
						 break;
					 }
				 }
				 pendedProducts.remove(i);
			 }
		 }
		 
		 if(pendedProducts.size() == 0) mart.deleteObserver(this); 
	}
	
	public ArrayList<Product> getPendedProducts(){
		return pendedProducts;
	}

	public ArrayList<Payable> getWallet() {
		return Wallet;
	}

	public ArrayList<Product> getShoppingCart() {
		return shoppingCart;
	}

}
