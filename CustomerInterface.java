package com.nissan.model;

import java.util.ArrayList;

public interface CustomerInterface {
	public abstract void Deposit(ArrayList<Bank> b);

	public abstract void Withdraw(ArrayList<Bank> b);

	public abstract void ShowBalance(ArrayList<Bank> b);

	public abstract void Transfer(ArrayList<Bank> b);

}
