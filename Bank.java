


package com.nissan.model;

public class Bank {

public int AccountNo;
public String CustomerName;
public String AccountType;
public int Balance;
public int MininumBalance;
public String MobileNumber;
public String EmailId;
public int ATMPin;

public Bank() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "Bank [AccountNo=" + AccountNo + ", CustomerName=" + CustomerName + ", AccountType=" + AccountType
			+ ", Balance=" + Balance + ", MininumBalance=" + MininumBalance + ", MobileNumber=" + MobileNumber
			+ ", EmailId=" + EmailId + ", ATMPin=" + ATMPin + "]";
}

}
