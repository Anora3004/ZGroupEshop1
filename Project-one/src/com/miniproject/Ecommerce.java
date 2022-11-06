package com.miniproject;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public  class Ecommerce{

	// non parameterized constructor
	public Ecommerce() {

	}

	// parameterized constructor
	public Ecommerce(int max) {

	}

	private static String CustomerName;
	private static String address;
	private static int maxItemLimit = 5;
	private static int totalItemInCart;
	private static ArrayList<String> itemInCart = new ArrayList<>();
	private static ArrayList<Integer> priceAfterPurchase = new ArrayList<Integer>();
	ProductList list = new ProductList();

	ArrayList<String> purchased = new ArrayList<>(5);

	public String getName() {
		return CustomerName;
	}

	public void setName(String newName) {
		CustomerName = newName;
	}

	public String getIdNum() {
		return address;
	}

	public void setIdNum(String newAddress) {
		address = newAddress;
	}

	interface Mart_I {
		public void Admin();

		public int Stock();

		public void Customer();

		public void Cart();

		public void bill();

		public void CustomerRecord();
	}


	

static class EcommerceOne extends Ecommerce implements Mart_I {
	
	
		
	

		@Override
		public void Admin() {
			System.out.println("===============Ecommerce Application===============\n");
			System.out.println("View as an Admin\n");
			System.out.println(
					"\t\tChoose Option: \n\t\t1: Add Item(s)\n\t\t2: Update Existing Item\n\t\t3: Remove Item\n\t\t4: Stock Details\n\t\t5: Customer Record");
			System.out.println("===============Ecommerce Application===============");
			Scanner adminInput = new Scanner(System.in);
			System.out.println("Enter::");
			int inputAdmin = adminInput.nextInt();
			if (inputAdmin == 1) {
				System.out.println("Product name & price");

				// add start
				Scanner newPro = new Scanner(System.in);
				System.out.println("Name: ");
				String newname = newPro.nextLine();
				list.product.add(list.product.size(), newname);
				System.out.println("Price: ");
				Integer newPrice = newPro.nextInt();
				list.productPrices.add(newPrice);
				// add end
				System.out.println("Item added Successfully");
				Admin();
				// ended-----
			} else if (inputAdmin == 2) {
				// update
				Scanner change = new Scanner(System.in);
				System.out.println("Index no: ");
				int index = change.nextInt();
				System.out.println("Product name: ");
				String name = change.next();
				System.out.println("Price: ");

				int price = change.nextInt();
				list.product.set(index, name);
				list.productPrices.set(index, price);

				System.out.println("***Item updated successfully!!***");
				System.out.println("Choose:\n\t1: Continue\n\t2: Exit");
				System.out.println("Enter:: ");
				Scanner cr = new Scanner(System.in);
				int num = cr.nextInt();
				if (num == 1) {
					Admin();
				} else if (num == 2) {
					return;
				} else {
					return;
				}
				// update end
			} else if (inputAdmin == 3) {
				// remove start
				Scanner remove = new Scanner(System.in);
				System.out.println("Item index no.: ");
				int removeItem = remove.nextInt();
				list.product.remove(removeItem);
				list.productPrices.remove(removeItem);
				System.out.println("Item removed successfully");
				Admin();
			} else if (inputAdmin == 4) {
				Stock();
				System.out.println("Choose:\n\t1: Continue\n\t2: Exit");
				System.out.println("Enter:: ");
				Scanner cr = new Scanner(System.in);
				int num = cr.nextInt();
				if (num == 1) {
					Admin();
				} else if (num == 2) {
					return;
				} else {
					return;
				}
			} else if (inputAdmin == 5) {
				CustomerRecord();// calling record method which shows the customer
			} else if (inputAdmin == 99) {
				main(null);
			} else {
				System.out.println("Please enter correct choice!!");
				Admin();
			}
		}

		
		
		@Override
			public void Customer(){
				System.out.println("==========================***Ecommerce Application*** ==============================");
				System.out.println("View as a customer");
				System.out.println("\t\tChoose Option : \n\t\t1: Purchase\n\t\t2: Go to Cart\n\t\t3: Bill \n\t\t4: Back");
				System.out.println("==========================***Ecommerce Application*** ==============================");
				System.out.println("Enter:: ");
				Scanner customerInput = new Scanner(System.in);
				int customerIn=customerInput.nextInt();
				
				if (customerIn==1)
				{
					System.out.println("\t****___Shop now :");
					
					System.out.println("___Item Available ");
					System.out.println("_______________________________________________________________________");
				    System.out.println("Item no\t\tItem\t\t\tPrice\n");
				for (int i=0;i<list.product.size(); i++){
					System.out.println(i+"\t\t"+ list.product.get(i)+"\t\t\t$"+list.productPrices.get(i));
				}
				System.out.println("____________________________________________________________________________");
				
				//-----------------purchese start 
				Scanner itemPurchase=new Scanner(System.in);
				System.out.println("No. of item you want ");
				int index_no_item=itemPurchase.nextInt();
				int [] purchasedList=new int[5]; 
				
				if(index_no_item<=maxItemLimit)
				{
					try 
					{
						System.out.println("Enter item no: e.g.(for product1 enter 0 . . .and so on)");
					for (int i=0;i<index_no_item; i++)
					   {
						purchasedList[i]=itemPurchase.nextInt();
					   }
					totalItemInCart=index_no_item;
					System.out.println("___________________________________________________________________________");
					System.out.println("                                    Below                                  ");
					System.out.println("Item In Cart "+ index_no_item);
					System.out.println("------------------------------------------------------------------------");
					for(int i=0;i<index_no_item;i++){
						System.out.println(purchasedList[i]+" :"+list.product.get(purchasedList[i])+ "\t\t$  "+list.productPrices.get(i));
					    itemInCart.add(i,list.product.get(purchasedList[i])); //errorrrrrrr
						priceAfterPurchase.add(list.productPrices.get(purchasedList[i]));
					
					}
					}
				catch(Exception e){
					
					}
				finally
				{
					//sum of all item prices 
					
					// sum of end 
					System.out.println("-----------------------------------------------------------------------------------");
				}
					
				}else {
					System.out.println("you cant purchase more than 5 products");
				}
				
				System.out.println("Choose:\n\t1:Continue\n\t2: Exit");
				System.out.print("Enter::");
				Scanner ch =new Scanner(System.in);
				int num=ch.nextInt();
				if(num==1) {
					Customer();
				}else if (num==2) {
					return;
				}else {
					return;
				}
				}
				else if(customerIn==2) {
					System.out.println("**Your Cart*");
					System.out.println("________");
					Cart();
					System.out.println("________");
					System.out.println("Item QuantitY: "+ itemInCart.size());
					double sum= 0;
					for (int d: priceAfterPurchase) {
						sum+=d;
					}
					System.out.println("Total Cost: $" + sum);// must calculate here
				
			System.out.println("---------------------------");
			System.out.println("Choose:\n\t1: Manage Cart \n\t2: Continue\n\t3: "); //error line no.257
			System.out.print("Enter::");
			Scanner cr= new Scanner(System.in);
			int num= cr.nextInt();
			if(num==1)
			{
				System.out.println("Actions: \n1 : Add more items\n2: Remove items");
				Scanner cartManageInputActionNumber = new Scanner(System.in);
				int cm = cartManageInputActionNumber.nextInt();
				
				if(cm==1) {
					System.out.println("Enter item index: ");
					Scanner add = new Scanner(System.in);
					int cmm= add.nextInt();
					for(int i = 0; i< totalItemInCart;i++){
						itemInCart.set(i, list.product.get(cmm));
						priceAfterPurchase.add(list.productPrices.get(cmm));
					}
					Cart();
					
					}else if(cm==2) {
						
					}else {
						return;
					}
			}else if(num==2) {
				Customer();
			}
			else if(num==3) {
				return;
			}else {
				return;
			}
				}
				else if(customerIn==3) {
					bill();
					System.out.print("Enter:: ");
					Scanner sc=new Scanner(System.in);
					int num =sc.nextInt();
					if(num==1){
						Customer();
					}else if(num==2){
						return;
					}else {
						return;
					}
				}
				else if(customerIn==99) {
					main(null);
				}
				else {
					System.out.println("Please enter correct choice!!");
				}
			}
			public void Cart() {
				EcommerceOne object = new EcommerceOne();
				Ecommerce oi = new Ecommerce();
				System.out.println("---------------------------------");
				System.out.println("no \t Items\t\t Price");
				System.out.println("---------------------------------\n");
				for (int i = 0; i < totalItemInCart; i++) {
					System.out.println(i + "\t" + itemInCart.get(i) + "\t\t$ " + priceAfterPurchase.get(i));

				}

			}
			// cart end

			public void bill() {
				Scanner csName = new Scanner(System.in);
				System.out.print("Name: ");
				CustomerName = csName.nextLine();
				System.out.print("Address: ");
				address = csName.nextLine();

				System.out.println("**********YOUR BILL**********");
				System.out.println("______________________________");
				System.out.println("Customer name: " + CustomerName);
				System.out.println("Customer address: " + address);
				LocalDate date = LocalDate.now();
				System.out.println("Date: " + date);
				LocalTime time = LocalTime.now();
				System.out.println("Time: " + time);
				System.out.println("_______________________________");
				Cart();
				System.out.println("\n-----------------------------");
				System.out.println("Total Item: " + itemInCart.size());
				double sum = 0;
				for (int d : priceAfterPurchase) {
					sum += d;
				}
				System.out.println("Total Bill: $ " + sum);
				System.out.println("________________________________");
				System.out.println("**********THANK YOU**********");

				// keeping record
				File file = new File("newFile.txt");
				String name = CustomerName;
				String customerAddress = address;
				try {
					// creating a Writer using fileWriter
					FileWriter output = new FileWriter("newFile.txt");
					// Writes string to the file
					output.write("-------------------------------------------");
					output.write("\nCustomer name: " + name);
					output.write("\nCustomer address: " + customerAddress);
					output.write("\nDate & time:  " + date + " " + time);
					output.write("\nQuantity: " + itemInCart.size());
					output.write("\nList of purchased items: " + itemInCart);
					output.write("\nTotal purchase amount: " + sum);
					output.write("-------------------------------------------");
					output.close();
					// closing writer
				} catch (Exception e) {
					e.getStackTrace();
				}
				// end

				System.out.println("Choose:\n\t1: Continue\n\t2: Exit");
				System.out.println("Enter:: ");
				int num = csName.nextInt();
				if (num == 1) {
					Customer();
				} else if (num == 2) {
					return;

				} else {
					System.out.println("Entered incorrect");
				}

			}

			public void CustomerRecord() {
				// reading files
				char[] array = new char[1000];
				try {
					// creates a reader using filereader
					FileReader input = new FileReader("newFile.txt");

					// read characters
					input.read(array);
					System.out.println("Customer Details: ");
					if (input != null) {
						System.out.println(array);
					}
				} catch (Exception e) {
					e.getStackTrace();
				}

			}

			@Override
			public int Stock() {
				// TODO Auto-generated method stub
				return 0;
			}
			

		}
public static void main(String[] args) {
	
	EcommerceOne e = new EcommerceOne();
	e.Customer();
	e.Cart();
	e.bill();
	
	
}

		

}
