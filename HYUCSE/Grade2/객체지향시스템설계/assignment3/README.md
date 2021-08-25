# Assignment 3

## Development Environment   

 - OS : Window 10

 - Java : Java(TM) SE Runtime Environment (build 15.0.1+9-18)

----

## Configuration

- [Cash.java](#cash)

- [Credit.java](#credit)

- [Food.java](#food)

- [Manufactured.java](#manufactured)

- [Mart.java](#mart)

- [Customer.java](#customer)

- [MartSimulation.java](#martsimulation)

- [InvalideAccessException.java](#invalidaccessexception)

- [ExpiredProductException.java](#expiredproductexception)

- [NotEnoughBalanceException.java](#notenoughbalanceexception)
----
## Design Pattern

1. Singleton : In Mart.java, using double-check locking, method getInstance is implement. [Link](#mart)

2. Observer : If customer has any product in pendedProduct, class MartSimulation add customer to Mart's observers using addObserver. And then, if that customer has no product in pendedProduct by buying pended products, then invoke deleteObserver. [Link](#customer)


----

  

## *Cash*  
 : implements Payable


<details>
<summary>Source Code</summary>
<div markdown='1'>

```java
package assignment3;

public class Cash implements Payable{
	private String currency;
	private int amount;
	
	
	public Cash(String currency, int amount) {
		this.currency = currency;
		this.amount = amount;
	}
	
	public void pay(int amount) {
		if(this.amount - amount < 0) return;
		this.amount -= amount;
	}
	

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	
	
}


```

</div>
</details>
  

  

### Variable

  

| Type | Variable Name | Description |
| :------------ | :----------- | :------------------- |
| private String | currency | Cash Currency |
| private int | amount | Cash Amount |

  

<br>

### Constructor

  

| parameter | Description |
| :------------ | :----------- |
| String currency <br>int amount | set all private variable to parameter |  

<br>

  

### Method

| Return Type | Method Name | Parameter | Description |
| :------------ | :----------- | :------ |:------------------- |
| public void | pay | int amount | pay amount
  
  
----

## *Credit* 
 : implements Payable

<details>
<summary>Source Code</summary>
<div markdown='1'>

```java
package assignment3;

public class Credit implements Payable{
	private String bank;
	private int limit;
	private int amountUsed;
	
	public Credit(String bank, int limit, int amountUsed) {
		this.bank = bank;
		this.limit = limit;
		this.amountUsed = amountUsed;
	}
	
	public void pay(int price) {
		if((amountUsed + price) > limit) return;
		amountUsed += price;
	}
	
	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getAmountUsed() {
		return amountUsed;
	}

	public void setAmountUsed(int amountUsed) {
		this.amountUsed = amountUsed;
	}
}

```

</div>
</details>
  
### Variable

  

| Type | Variable Name | Description |
| :------------ | :----------- | :------------------- |
| private String | bank | Credit's Bank |
| private int | limit | Credit's Limit |
| private int | amountUsed | Credit's Used Amount |

  

<br>

### Constructor

  

| parameter | Description |
| :------------ | :----------- |
| String bank <br>int limit <br>int amountUsed| set all private variable to parameter |

  

<br>

  

### Method

| Return Type | Method Name | Parameter | Description |
| :------------ | :----------- | :------ |:------------------- |
| public void | pay | int amount | pay amount
  
----


## *Food* 

 : extends Product

<details>
<summary>Source Code</summary>
<div markdown='1'>

```java
package assignment3;

import java.time.LocalDateTime;

public class Food extends Product{
	private LocalDateTime expirationDateTime;

	public Food(String name, int price, LocalDateTime expirationDateTime, int quantity) {
		super(name,price,quantity);
		this.expirationDateTime = expirationDateTime;
	}
	
	public Food(Food other, int quantity) {
		super(other.getName(), other.getPrice(), quantity);
		this.expirationDateTime = other.getExpirationDateTime();
	}
	
	public boolean isExpired(LocalDateTime present) {
		if(expirationDateTime.compareTo(present) < 0) return true;
		return false;
	}

	public LocalDateTime getExpirationDateTime() {
		return expirationDateTime;
	}

	public void setExpirationDateTime(LocalDateTime expirationDateTime) {
		this.expirationDateTime = expirationDateTime;
	}

	
}


```

</div>
</details>
  
### Variable

  

| Type | Variable Name | Description |
| :------------ | :----------- | :------------------- |
| private String | name | Product's Name |
| private int | price | Product's Price |
| private int | quantity | Product's Quantity |
| private LocalDateTime | expirationDateTime | Food's Expiration Date |
  

<br>

### Constructor

  

| parameter | Description |
| :------------ | :----------- |
| String name  <br>int price <br>LocalDateTime expirationDateTime <br>int quantity | set all private variable to parameter |
| Food other <br>int quantity | copy constructor with new quantity|

  

<br>

  

### Method

| Return Type | Method Name | Parameter | Description |
| :------------ | :----------- | :------ |:------------------- |
| public boolean  | isExpired | LocalDateTime present | return true if expirationDateTime is after present
  

----

## *Manufactured*
 : extends Product
   

<details>
<summary>Source Code</summary>
<div markdown='1'>

```java
package assignment3;

public class Manufactured extends Product{
	public String brand;
	
	public Manufactured(String name, int price, String brand, int quantity) {
		super(name,price,quantity);
		this.brand = brand;
	}
	
	public Manufactured(Manufactured other, int quantity) {
		super(other.getName(), other.getPrice(), quantity);
		this.brand = brand;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
}


```

</div>
</details>
  

  

### Variable

  

| Type | Variable Name | Description |
| :------------ | :----------- | :------------------- |
| private String | name | Product's Name |
| private int | price | Product's Price |
| private int | quantity | Product's Quantity |
| public String | brand | Manufactured's Brand |

  

<br>

### Constructor

| parameter | Description |
| :------------ | :----------- |
| String name  <br>int price <br>String brand <br>int quantity | set all private variable to parameter |
| Manufactured other <br>int quantity | copy constructor with new quantity|

<br>
  
  ----

## *Mart*
 : extends InventoryManager
  
<details>
<summary>Source Code</summary>
<div markdown='1'>

```java
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


```

</div>
</details>
  

### Method

   

| Return Type | Method Name | Parameter |
| :------------ | :----------- | :------ | 
| public static Mart | getInstance | Null |
| public void  | addObserver | Null | 
| public void  | deleteObserver | Null | 
| public void  | notifyObserver | Null | 


----

## *Customer*

<details>
<summary>Source Code</summary>
<div markdown='1'>

```java
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


```
</div>
</details>
  
### Variable

  

| Type | Variable Name | Description |
| :------------ | :----------- | :------------------- |
| private String | name | Customer's name |
| private int | totalPrice | Customer's ShoppingCart's Total Price |

  

<br>

### Constructor

  

| parameter | Description |
| :------------ | :----------- |
| String name | set all private variable to parameter |

  

<br>

  

### Method

| Return Type | Method Name | Parameter | Description |
| :------------ | :----------- | :------ |:------------------- |
| public int | getTotalPrice | Null | return Shopping Cart's Products' total price |
| public void | update | InventoryManager generator | if pended product is in mart, add this product in shopping cart | 
  

----

## *MartSimulation*
  
<details>
<summary>Source Code</summary>
<div markdown='1'>

```java
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


```

</div>
</details>
  
### Variable

| Type | Variable Name | Description |
| :------------ | :----------- | :------------------- |
| public static ArrayList&lt;Customer&gt; | customerList | Customers' List |
| public static LocalDateTime | localTime | Present Time |


### Method

   

| Return Type | Method Name | Parameter |
| :------------ | :----------- | :------ | 
| public static void | printProduct | Null |
| public static void | addInventory | Null |
| public static void | replaceExpired | Null |
| public static void | managerMode | Null |
| public static void | shopping | Customer customer |
| public static void | printShoppingCart | Customer customer |
| public static void | printWallet | Customer customer |
| public static void | customerMode | Null |
| public static void | main | String[] args |


### Method Description

| Method Name | Description |
| :-----------------:| :------------|
| main | 1. Read text files<br>2. Input menu number<br> - 1 : Manager Mode<br> - 2 : Customer Mode<br> - 3 : End Program |
| managerMode | Input menu number<br> - 1 : Add Inventory<br> - 2 : Replace Expired |
| addInventory | 1. Print all products<br>2. Select product and enter quantity<br>3. Add product in mart's sales products |
| replaceExpired | 1. Print all expired products<br>2. Select product and enter expired date<br> 3. Set expired date to the day later that is entered |
| customerMode  | 1. Select customer<br>2. Input menu number<br> - 0 : Back to Main<br> - 1 : Shopping<br> - 2 : Print Shopping Cart<br> - 3 : Wallet<br> - 4 : Print Wallet  |
| shopping  | 1. Print products<br> 2. Select product and enter quantity<br>3. Add customer's shopping cart as possible<br>4. If the products are not enough, add insufficient products to customer's pended product |
| printShoppingCart  | Print shopping cart |
| paying  | 1. Print shopping cart<br>2. Select payment method<br>3. If payable's amount is enough then pay total cost<br> 4. Make receipt text file |
| printWallet  | Print wallet |



----

## *InvalidAccessException*

 : extends Exception

<details>
<summary>Source Code</summary>
<div markdown='1'>

```java
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


```
</div>
</details>
  
 - getMessage() : return "Invalid Access Exception"

----

## *ExpiredProductException*

 : extends Exception

<details>
<summary>Source Code</summary>
<div markdown='1'>

```java
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


```
</div>
</details>
  
 - getMessage() : return "Expired Product Exception"

----

## *NotEnoughBalanceException*

 : extends Exception

<details>
<summary>Source Code</summary>
<div markdown='1'>

```java
package assignment3;

public class NotEnoughBalanceException extends Exception{
	private int enoughPrice;
	
	public NotEnoughBalanceException(int enoughPrice) {
		super(enoughPrice + " won is not enough.");
		this.enoughPrice = enoughPrice;
	}
	
	public int getEnoughPrice() {
		return enoughPrice;
	}
}



```
</div>
</details>
  
 - getMessage() : return enoughPrice + "  won is not enough"


<br>
