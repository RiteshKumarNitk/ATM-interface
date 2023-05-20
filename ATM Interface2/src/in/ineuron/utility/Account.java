package in.ineuron.utility;

import java.util.*;

public class Account {
	
	private long accountNumber;
	private String AccountType;
	private Double balance;

	private User holder;
	private ArrayList<Transaction>transaction;
	
	
	public Account(String accountType, Double balance,User user,Bank bank) {
		this.holder = user;
		this.AccountType = accountType;
		this.balance = balance;
		this.accountNumber=bank.newAccountNo();
		this.transaction=new ArrayList<>();
	}
	
	public Long getAccountNumber() {
		return accountNumber;
	}
	public String getAccountType() {
		return AccountType;
	}
	public Double getBalance() {
		return balance;
	}

	public void addTransaction(Transaction transaction) {
		this.transaction.add(transaction);
	}
	
	
	public ArrayList<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(ArrayList<Transaction> transaction) {
		this.transaction = transaction;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	//Testing Purpose
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", AccountType=" + AccountType + ", balance=" + balance
				+ "]";
	}
	
	
	
	
	

}
