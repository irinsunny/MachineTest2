package com.nissan.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Admin  extends Bank implements BankingInterface{
	static int i = 0;
	//static Bank[] b = new Bank[3];
	static Bank obj = null;

	@Override
	public void AddNewCustomers(ArrayList<Bank> b) {
		Scanner s = new Scanner(System.in);
		Random rand = new Random();
		String name;
		int balance;
		char c = 'n';
		
		do {
			obj = new Bank();
			obj.AccountNo = 100000000 + rand.nextInt(999999999 - 100000000 + 1);
			System.out.println("\nENTER CUSTOMER NAME");
			name = GetValidCustomerName(s.next());
			obj.CustomerName = name;

			System.out.println("\n ENTER ACCOUNT TYPE");
			obj.AccountType = s.next();

			System.out.println("\n ENTER BALANCE");
			balance = getValidBalance(s.next());
			obj.Balance = balance;

			System.out.println("\n ENTER MINIMUM BALANCE");
			obj.MininumBalance = s.nextInt();

			System.out.println("\n ENTER MOBILE NUMBER(10 DIGIT");
			obj.MobileNumber = s.next();

			System.out.println("\n ENTER EMAIL ID ");
			obj.EmailId = s.next();

			obj.ATMPin = 1000 + rand.nextInt(9999 - 1000 + 1);

			System.out.println(" do you want to continue to add customers (y/n)");
			c = checkif(s.next());
			b.add(obj);

		} while (c == 'y' || c == 'Y');
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

	private int getValidBalance(String balance) {
		

		try {
			// creating object for BufferedReader
			BufferedReader brBalance = new BufferedReader(new InputStreamReader(System.in));

			// creating pattern using regular expression
			Pattern patternBalance = Pattern.compile("[^0-9.-]");

			do {
				Matcher matcherBalance = patternBalance.matcher(balance);
				boolean balanceFinder = matcherBalance.find();

				if (balanceFinder) {
					System.out.print("Balance should contain only positive numeric values. Please re-enter balance: ");
					balance = brBalance.readLine();
				}

				else {
					break;
				}

			} while (true);

		} catch (Exception e) {
			System.out.println("Invalid balance");
		}

		int Balance = Integer.parseInt(balance);

		return Balance;
	}

	private  String GetValidCustomerName(String customerName) {
		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			Pattern pattern = Pattern.compile("[^A-Za-z ]");

			do {

				Matcher matcher = pattern.matcher(customerName);
				boolean finder = matcher.find();
				if (customerName.length() > 30) {
					System.out.print("Name contains more than 30 characters. Please re-enter name: ");
					customerName = br.readLine();
				} else {
					break;
				}

			} while (true);

		} catch (Exception e) {
			System.out.println("Invalid name");
		}

		return customerName;
	}

	


	
	public void Display(ArrayList<Bank> b) {
		
		System.out.println("\nTHE DETAILS OF CUSTOMER IS");

		for(Bank b1:b)
			System.out.println(b1);
		}

	

	public void DeleteCustomer(ArrayList<Bank> b) {

		int acc;
		Scanner s = new Scanner(System.in);
		System.out.println("\nENTER ACCOUNT NO");
		acc = s.nextInt();
		for(int k=0;k<b.size();k++) 
		{
			if(b.get(k).AccountNo==acc) {
				b.remove(k);
				System.out.println("Customer Deleted");
			}
			}
		}
		
	
	public void UpdateCustomerDetails(ArrayList<Bank> b) {
		int k = 0, acc;
		String phno;
		Scanner s = new Scanner(System.in);
		System.out.println("\nENTER ACCOUNT NO");
		acc = s.nextInt();
		for(Bank b1:b) {
			if(b1.AccountNo==acc) {
				
		
		
		System.out.println("\nENTER MOBILE NUMBER(10 DIGIT");
		phno = CheckValidPhone(s.next());

		b1.MobileNumber = phno;
		System.out.println("\n.ENTER EMAIL ID ");
		b1.EmailId = s.next();
			}
		}
	}

	public String CheckValidPhone(String phn) {
		try {

			BufferedReader brphn = new BufferedReader(new InputStreamReader(System.in));
			Pattern patternBalance = Pattern.compile("[^0-9.-]");

			do {
				Matcher matcherBalance = patternBalance.matcher(phn);
				boolean balanceFinder = matcherBalance.find();

				if (phn.length() < 10) {
					System.out.print("Phone no must be 10 digits Please re-enter: ");
					phn = brphn.readLine();
				} else if (phn.length() > 10) {
					System.out.print("Phone no must be 10 digits Please re-enter: ");
					phn = brphn.readLine();
				} else {
					break;
				}

			} while (true);

		} catch (Exception e) {
			System.out.println("Invalid Phone number");
		}

		return phn;
	}


	@Override
	public void DisplayCustomer(ArrayList<Bank> b) {
		int k, acc;
		Scanner s = new Scanner(System.in);
		System.out.println("\nENTER ACCOUNT NO");
		acc = s.nextInt();
		for(Bank b1:b) {
			if(b1.AccountNo==acc)
			{System.out.println("\nTHE DETAILS OF CUSTOMER IS");
			System.out.println(b1);
			break;
			}
			else
			System.out.println("\nACCOUNT NO NOT FOUND!!!");

		}
				
	}

}