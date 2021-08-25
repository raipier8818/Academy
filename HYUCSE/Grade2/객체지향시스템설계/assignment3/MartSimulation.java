package assignment3;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class MartSimulation {
	private static Scanner keyboard = new Scanner(System.in);
	public static ArrayList<Customer> customerList = new ArrayList<Customer>();
//	public static ArrayList<Product> salesList = new ArrayList<Product>();
	public static LocalDateTime localTime;
	
	public static void printProduct() {
		int idx = 1;
		for(Product product : Mart.getInstance().getSalesList()) {
			System.out.printf("%d. (Quantity: %d) %s, %d won, ", idx++, product.getQuantity(), product.getName(), product.getPrice());
			if(product instanceof Food) {
				System.out.println("Best before: " + ((Food)product).getExpirationDateTime());	
			}
			if(product instanceof Manufactured) {
				System.out.println("Brand: " + ((Manufactured)product).getBrand());
			}
		}
	}
	
	public static void addInventory() {
		printProduct();
		try {
			System.out.print("Select Product : ");
			int productNum = keyboard.nextInt() - 1;
			System.out.print("Enter Quantity : ");
			int productQuantity = keyboard.nextInt();
			
			if(productNum >= Mart.getInstance().getSalesList().size() || productNum < 0 || productQuantity <= 0) throw new InvalidAccessException(productNum);
			
			Mart.getInstance().getSalesList().get(productNum).setQuantity(Mart.getInstance().getInstance().getSalesList().get(productNum).getQuantity() + productQuantity);
			Mart.getInstance().notifyObservers();
		}catch(InvalidAccessException e) {
			System.out.println(e.getMessage());
		}catch(InputMismatchException e) {
			System.out.println("Wrong type input");
		}
		
	}
	
	public static void replaceExpired() {
		int idx = 1;
		int count = 0;
		ArrayList<Integer> expiredProducts = new ArrayList<Integer>();
		
		for(Product product : Mart.getInstance().getSalesList()) {
			if(product instanceof Food) {
				if(((Food)product).getExpirationDateTime().isBefore(localTime)) {
					System.out.printf("%d. (Quantity: %d) %s, %d won, ", idx++, product.getQuantity(), product.getName(), product.getPrice());
					System.out.println("Best before: " + ((Food)product).getExpirationDateTime());
					expiredProducts.add(count);
				}
			}
			count++;
		}
		
		try {
			System.out.print("Select Product : ");
			int productNum = keyboard.nextInt() - 1;
			System.out.print("Expired Date : ");
			int expiredNum = keyboard.nextInt();
			
			if(productNum < 0 || productNum > expiredProducts.size()) throw new InvalidAccessException(productNum);
			
			((Food)Mart.getInstance().getSalesList().get(expiredProducts.get(productNum))).setExpirationDateTime(localTime.plusDays(expiredNum)); 
		}catch(InvalidAccessException e) {
			System.out.println(e.getMessage());
		}catch(InputMismatchException e) {
			System.out.println("Wrong type input");
		}
		
	}
	
	
	public static void managerMode() {
		while(true) {
			int menuNum;
			try {
				System.out.println("<Manager Mode>");
				System.out.println("1. Add Inventory");
				System.out.println("2. Replace Expired");
				System.out.print("Enter the number : ");
				menuNum = keyboard.nextInt();
				if(menuNum == 0) return;
				else if(menuNum == 1) {
					addInventory();
				}
				else if(menuNum == 2) {
					replaceExpired();
				}
				else throw new InvalidAccessException(menuNum);
				
				
			}catch(InvalidAccessException e) {
				System.out.println(e.getMessage());
			}catch(InputMismatchException e) {
				System.out.println("Wrong type input");
			}
		}
	}
	
	public static void shopping(Customer customer) {
		while(true) {
			try {
				printProduct();
				System.out.print("Select Product : ");
				int product = keyboard.nextInt() - 1;
				
				if(product == -1) return;
				
				if(product < -1 || product >= Mart.getInstance().getSalesList().size()) throw new InvalidAccessException(product); 
				
				
				Product selectedProduct = Mart.getInstance().getSalesList().get(product);
				System.out.print("Enter Quantity : ");
				int productQuantity = keyboard.nextInt();
				
				if(productQuantity <= 0) throw new InvalidAccessException(productQuantity);
				
				
				if((selectedProduct instanceof Food) && (((Food)selectedProduct).getExpirationDateTime().isBefore(localTime))) {
					throw new ExpiredProductException();
				}
				
				Product addProduct = null;
				
				if(selectedProduct instanceof Food) {
					addProduct = new Food(((Food)selectedProduct), productQuantity > selectedProduct.getQuantity() ? selectedProduct.getQuantity() : productQuantity);
					
				}
				else if(selectedProduct instanceof Manufactured) {
					addProduct = new Manufactured(((Manufactured)selectedProduct), productQuantity > selectedProduct.getQuantity() ? selectedProduct.getQuantity() : productQuantity);
					
				}
				
				selectedProduct.setQuantity(selectedProduct.getQuantity() - productQuantity);
				if(selectedProduct.getQuantity() < 0) {					
					customer.getPendedProducts().add(new Product(selectedProduct, -1*selectedProduct.getQuantity()));
					selectedProduct.setQuantity(0);
					Mart.getInstance().addObserver(customer);
				}

				int i = 0;
				for(; i < customer.getShoppingCart().size(); i++) {
					if(customer.getShoppingCart().get(i).equals(addProduct)) break;
				}
				
				if(i == customer.getShoppingCart().size()) customer.getShoppingCart().add(addProduct);
				else customer.getShoppingCart().get(i).setQuantity(customer.getShoppingCart().get(i).getQuantity() + productQuantity);
			}catch(InvalidAccessException e) {
				System.out.println(e.getMessage());
			}
			catch(ExpiredProductException e) {
				System.out.println(e.getMessage());
			}catch(InputMismatchException e) {
				System.out.println("Wrong type input");
			}
		}
	}
	
	public static void printShoppingCart(Customer customer) {
		int idx = 1;
		System.out.println(localTime.toString());
		System.out.printf("%-16s%16s%16s%16s\n", "Product name", "Unit price", "Quantity", "Amount");
		for(Product product : customer.getShoppingCart()) {
			System.out.printf("%-16s%16d%16d%16d\n", product.getName(), product.getPrice(), product.getQuantity(), product.getPrice()*product.getQuantity());
		}
		System.out.println("----------------------------------------------------------------");
	}
	
	public static void paying(Customer customer) {
		printShoppingCart(customer);
		System.out.printf("%-32s%32d\n", "Total Price", customer.getTotalPrice());
		System.out.println("----------------------------------------------------------------");
		
		printWallet(customer);
		System.out.print("Select payment method: ");
		int paymentNum = 0;
		Payable p = null;	
		try {
			paymentNum = keyboard.nextInt() - 1;
			if(paymentNum < 0 || paymentNum >= customer.getWallet().size()) throw new InvalidAccessException(paymentNum);
			p = customer.getWallet().get(paymentNum);
			
			if(p instanceof Cash) {
				if (((Cash)p).getAmount() < customer.getTotalPrice()) throw new NotEnoughBalanceException(customer.getTotalPrice() - ((Cash)p).getAmount()); 
			
				((Cash)p).setAmount(((Cash)p).getAmount() - customer.getTotalPrice());
			}
			else if(p instanceof Credit) {
				if(((Credit)p).getLimit() - ((Credit)p).getAmountUsed() - customer.getTotalPrice() < 0) throw new NotEnoughBalanceException(-1*(((Credit)p).getLimit() - ((Credit)p).getAmountUsed() - customer.getTotalPrice()));
			
				((Credit)p).setAmountUsed(((Credit)p).getAmountUsed() + customer.getTotalPrice());
			}
			
			
		}catch(InvalidAccessException e) {
			System.out.println(e.getMessage());
			return;
		}catch(NotEnoughBalanceException e) {
			System.out.println(e.getMessage());
			return;
		}catch(InputMismatchException e) {
			System.out.println("Wrong type input");
		}

			
		
		File receipt = new File("Receipt" + Mart.transaction++ + ".txt");
		while(receipt.exists()) {
			receipt = new File("Receipt" + Mart.transaction++ + ".txt");
		}
		
		PrintWriter outputStream = null;
		
		try {
			outputStream = new PrintWriter(new FileOutputStream(receipt.getName()));
		}catch(FileNotFoundException e) {
			System.out.println("Error opening the file..");
			return;
		}
		int idx = 1;
		outputStream.println(localTime.toString());
		outputStream.printf("%-16s%16s%16s%16s\n", "Product name", "Unit price", "Quantity", "Amount");
		for(Product product : customer.getShoppingCart()) {
			outputStream.printf("%-16s%16d%16d%16d\n", product.getName(), product.getPrice(), product.getQuantity(), product.getPrice()*product.getQuantity());
		}
		outputStream.println("----------------------------------------------------------------");
		outputStream.printf("%-32s%32d\n", "Total Price", customer.getTotalPrice());
		outputStream.println("----------------------------------------------------------------");
		
		if(p instanceof Credit) {
			outputStream.println("Credit, " + ((Credit)p).getBank());
		}else if(p instanceof Cash) {
			outputStream.println("Cash, " + ((Cash)p).getCurrency());
		}

		customer.getShoppingCart().clear();
		outputStream.close();
	}
	
	public static void printWallet(Customer customer) {
		int index = 1;
		for(Payable temp : customer.getWallet()) {
			if(temp instanceof Credit) {
				System.out.printf("%d. %s, Amount used: %d won (Limit: %d won)\n", index, ((Credit)temp).getBank(), ((Credit)temp).getAmountUsed(), ((Credit)temp).getLimit());
			}else if(temp instanceof Cash){
				System.out.printf("%d. %s, %d won\n", index, ((Cash)temp).getCurrency(), ((Cash)temp).getAmount());
			}
			index++;
		}
	}
	
	
	
	public static void customerMode() {
		int idx = 1;
		for(Customer customer : customerList) {
			System.out.printf("%d) %s\n", idx++, customer.getName());
		}
		
		int customerNum;
		Customer selectedCustomer;
		while(true) {
			try {
				System.out.print("Select Customer : ");
				customerNum = keyboard.nextInt();
				if(customerNum-- == 0) return;
				if(customerNum >= customerList.size()) throw new InvalidAccessException(customerNum);
				else {
					selectedCustomer = customerList.get(customerNum);
					break;
				}
			}catch(InvalidAccessException e) {
				System.out.println(e.getMessage());
			}catch(InputMismatchException e) {
				System.out.println("Wrong type input");
			}
		}
		
		
		while(true) {
			int menuNum;
			try {
				System.out.println("<Customer Mode>");
				System.out.println("1. Shopping");
				System.out.println("2. Print Shopping Cart");
				System.out.println("3. Paying");
				System.out.println("4. Print Wallet");
				System.out.print("Enter the number : ");
				
				menuNum = keyboard.nextInt();
				if(menuNum == 0) return;
				else if(menuNum == 1) {
					shopping(selectedCustomer);
				}
				else if(menuNum == 2) {
					printShoppingCart(selectedCustomer);
				}
				else if(menuNum == 3) {
					paying(selectedCustomer);
				}
				else if(menuNum == 4) {
					printWallet(selectedCustomer);
				}
				else throw new InvalidAccessException(menuNum);
				
				
			}catch(InvalidAccessException e) {
				System.out.println(e.getMessage());
			}catch(InputMismatchException e) {
				System.out.println("Wrong type input");
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		localTime = LocalDateTime.of(2021, 5, 27, 15, 00);
		
		try {
			BufferedReader customerWallet =  new BufferedReader(new FileReader("CustomerWallet.txt"));
			int customerNum = Integer.parseInt(customerWallet.readLine());
			
			for(int i = 0; i < customerNum; i++) {
				String[] line = customerWallet.readLine().split(", ");
				Customer newCustomer = new Customer(line[0]);
				for(int j = 0; j < Integer.parseInt(line[1]); j++) {
					String[] pay = customerWallet.readLine().split(", ");
					if(pay[0].equals("Credit")) {
						Credit newCredit = new Credit(pay[1], Integer.parseInt(pay[2]), Integer.parseInt(pay[3]));
						newCustomer.getWallet().add(newCredit);
					}
					if(pay[0].equals("Cash")) {
						Cash newCash = new Cash(pay[1], Integer.parseInt(pay[2]));
						newCustomer.getWallet().add(newCash);
					}
				}
				customerList.add(newCustomer);
			}
			
			BufferedReader mart = new BufferedReader(new FileReader("Mart.txt"));
			int productNum = Integer.parseInt(mart.readLine());
			
			for(int i = 0; i < productNum; i++) {
				String[] line = mart.readLine().split(", ");
				if(line[0].equals("Food")) {
					Food newFood = new Food(line[1],Integer.parseInt(line[2]) ,LocalDateTime.of(
							Integer.parseInt(line[3]),
							Integer.parseInt(line[4]),
							Integer.parseInt(line[5]),
							Integer.parseInt(line[6]),
							Integer.parseInt(line[7])
							), Integer.parseInt(line[8]));
					
					Mart.getInstance().getSalesList().add(newFood);
				}
				if(line[0].equals("Manufactured")) {
					Manufactured newManufactured = new Manufactured(line[1], Integer.parseInt(line[2]), line[3], Integer.parseInt(line[4]));
					Mart.getInstance().getSalesList().add(newManufactured);
				}
			}
			
			
			
		}catch(FileNotFoundException e) {
			System.out.println("File not found..");
			return;
		}catch(IOException e) {
			System.out.println("Error reading from file..");
		}
		
		while(true) {
			int mainMenuNum;
			try {
				System.out.println("Mart Simulation");
				System.out.println("1. Manager Mode");
				System.out.println("2. Customer Mode");
				System.out.println("3. End Program");
				System.out.print("Enter the number : ");
				
				mainMenuNum = keyboard.nextInt();
				if(mainMenuNum == 1) {
					managerMode();
				}
				else if(mainMenuNum == 2) {
					customerMode();
				}
				else if(mainMenuNum == 3) {
					return;
				}
				else throw new InvalidAccessException(mainMenuNum);
				
			}catch(InvalidAccessException e) {
				System.out.println(e.getMessage());
			}catch(InputMismatchException e) {
				System.out.println("Wrong type input");
			}
		}	
	}
	
	
	
}
