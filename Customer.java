package com.nissan.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends Bank  implements CustomerInterface {
	//static Bank[] b = new Bank[3];
	@Override
	public void Deposit(ArrayList<Bank> b) {
		int amt;int flag=0;
		Scanner s = new Scanner(System.in);
		System.out.println("\nENTER ACCOUNT NO");
		int acc = s.nextInt();
		for(Bank b1:b) {
			if(b1.AccountNo==acc)
			{ 
				flag++;	
					System.out.println("ENTER AMOUNT TO DEPOSIT");
					amt = s.nextInt();
					if (amt > 50000) 
					{
						System.out.println("ENTER PAN CARD");
						String pan = s.next();
					}
					b1.Balance+=amt;

					} 
		}
			if(flag==0)
				System.out.println("\nACCOUNT NO NOT FOUND!!!");

			}
				
		

			
	
	@Override
	public void Withdraw(ArrayList<Bank> b) {
		int amt,flag=0;
		Scanner s = new Scanner(System.in);
		System.out.println("\nENTER ACCOUNT NO");
		int acc = s.nextInt();
		for(Bank b1:b) 
			{
				if(b1.AccountNo==acc) 
				{	flag++;
				System.out.println("ENTER AMOUNT TO WITHDRAW");
				amt = s.nextInt();
				int balance = b1.Balance - b1.MininumBalance;

				if (amt > 50000) 
				{
					System.out.println("ENTER PAN CARD");
					String pan = s.next();
				}
				if (amt > balance)
				{
					System.out.println("INSUFFICIENT FUNDS!!");

				} 
				else 
				{
					b1.Balance -= amt;
				}	
				}
			}
			if(flag==0)
				System.out.println("\nACCOUNT.NO NOT FOUND!!!");

		}
		
		

	@Override
	public void ShowBalance(ArrayList<Bank> b) {
		int amt,flag=0;
		Scanner s = new Scanner(System.in);
		System.out.println("\nENTER ACCOUNT NO");
		int acc = s.nextInt();
		for(Bank b1:b) {
		    if(b1.AccountNo==acc)
			{ flag++;
				System.out.println(b1);
				
			} 
		}
			if(flag==0)
				System.out.println("\nACCOUNT.NO NOT FOUND!!!");		
	}
	

	@Override
	public void Transfer(ArrayList<Bank> b) {
		int amt, k,flag=0;
		Scanner s = new Scanner(System.in);
		System.out.println("\nENTER ACCOUNT NO");
		int acc = s.nextInt();
		System.out.println("ENTER AMOUNT TO TRANSFER");
		amt = s.nextInt();
		for(Bank b1:b)
		{
			if(b1.AccountNo==acc)
			{flag++;
			System.out.println("\nENTER ACCOUNT NO TO WHICH THE AMT HAS TTO BE TRANSFERED");
			int acc1 = s.nextInt();
			int balance = b1.Balance - b1.MininumBalance;

			if (amt > balance) 
			{
				System.out.println("INSUFFICIENT FUNDS!!");

			}
			else
			{
				b1.Balance -= amt;
				System.out.println(" FUND TRANSFERED SUCCESSFULLY");
			}

			}
		}
			if(flag==0)
				System.out.println("\nACCOUNT.NO NOT FOUND!!!");

		

		
	}

}
