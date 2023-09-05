package com.nissan.model;

import java.util.ArrayList;

public interface BankingInterface {
 public abstract void AddNewCustomers(ArrayList<Bank>  b);
 public abstract void UpdateCustomerDetails(ArrayList<Bank> b);
 public abstract void DeleteCustomer(ArrayList<Bank> b);
 public abstract void Display(ArrayList<Bank> b);
 public abstract void DisplayCustomer(ArrayList<Bank> b);
  
}
