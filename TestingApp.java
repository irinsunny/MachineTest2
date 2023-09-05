package com.nissan.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nissan.model.Admin;
import com.nissan.model.Bank;
import com.nissan.model.Customer;

public interface TestingApp {
	static ArrayList<Bank> b= new ArrayList<Bank>();
 public static void main(String[] args)
 {
	 Customer c= new Customer();
	 Admin a= new Admin();
		String PersonType;

		char choice = 'n';
		int option;
		Scanner s = new Scanner(System.in);
		
		do {
			System.out.println("\n ENTER IF A -->ADMIN/ C-->CUSTOMER");
			PersonType = s.next();
			int k = 0;
			if (PersonType.equals("A")) {
				do {
					System.out.println(" MAIN MENU \n1.ADD NEW CUSTOMER \n2.UPDATE CUSTOMER DETAILS"
							+ " \n3.DELETE CUSTOMER DETAILS \n4.DISPLAY ALL CUSTOMER"
							+ "\n5. DISPLAY SPECIFIC CUSTOMER DETAILS" + "\n ENTER THE OPTION");
					option =CheckOption( s.next());
					switch (option) {
					case 1:
						a.AddNewCustomers(b);
						break;
					case 2:
						a.UpdateCustomerDetails(b);
						break;
					case 3:
						a.DeleteCustomer(b);
						
						break;
					case 4:
						a.Display(b);
						break;
					case 5:
						a.DisplayCustomer(b);
						break;
					default :
						System.out.println(" WRONG CHOICE");
					}

					System.out.println(" DO YOU WANT TO CONTINUE (ADMIN) y/n)");
					choice =checkif(s.next());

				} while (choice == 'y' || choice == 'Y');
				
			} else if (PersonType.equals("C")) {
				do

				{
					System.out.println(" MAIN MENU \n1.DEPOSIT \n2.WITHDRAW" + " \n3.SHOW BALANCE"
							+ "\n4.TRANSFER MONEY" + "\n ENTER THE OPTION");
					option = CheckOption(s.next());
					switch (option) {
					case 1:
						c.Deposit(b);
						break;
					case 2:
						c.Withdraw(b);
						break;
					case 3:
						c.ShowBalance(b);
						break;
					case 4:
						c.Transfer(b);
						break;

					}

					System.out.println(" DO YOU WANT TO CONTINUE( CUSTOMER) y/n)");
					choice = checkif(s.next());

				} while (choice == 'y' || choice == 'Y');
			} 
			
			System.out.println(" DO YOU WANT TO CONTINUE( y/n)");
			choice =checkif(s.next());

		} while (choice == 'y' || choice == 'Y');
 }

public static char checkif(String c) {
	try {
		//creating object for BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//creating pattern using regular expression
		Pattern pattern = Pattern.compile("[^yYNn]");

		do {

		//Match
		Matcher matcher = pattern.matcher(c);
		boolean finder = matcher.find(); //find() returns false if the string matches the pattern

		if(finder) {
		System.out.print("choice must be a  single alphabet. Please re-enter choice: ");
		c = br.readLine();
		}
		
		else {
		break;
		}

		}while(true);

		}catch(Exception e) {
		System.out.println("Invalid choice");
		}
		char d= c.charAt(0);
		return d;
		
}

public static int CheckOption(String op) {

	try {
	BufferedReader brBalance = new BufferedReader(new InputStreamReader(System.in));

	
	Pattern patternBalance = Pattern.compile("[^0-9.-]");

	do {
	Matcher matcherBalance = patternBalance.matcher(op);
	boolean balanceFinder = matcherBalance.find();

	if(balanceFinder) {
	System.out.print("Option should contain positive numeric values. Please re-enter Option: ");
	op = brBalance.readLine();
	}
	
	else {
	break;
	}

	}while(true);



	}catch(Exception e) {
	System.out.println("Invalid balance");
	}

	int b = Integer.parseInt(op);

	return b;
}
}
