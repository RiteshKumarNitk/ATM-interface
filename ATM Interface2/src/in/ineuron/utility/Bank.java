package in.ineuron.utility;

import java.util.*;

public class Bank {

	private static String bankName = "SBI";

	private ArrayList<User> accountholders;
	private ArrayList<Account> account;

	public Bank() {
		this.accountholders = new ArrayList<User>();
		this.account = new ArrayList<Account>();
	}

	public static String getBankName() {
		return bankName;
	}

	// get new account number
	public long newAccountNo() {
		long accountNo = 0;
		int k = 12;
		while (k-- > 0) {
			accountNo = accountNo * 10 + new Random().nextInt(10) + 1;
		}
		return accountNo;
	}

	// add new account to Bank
	public void addAccount(Account acnt) {
		this.account.add(acnt);
	}

	// add new User in Bank
	public User addNewCustomer(String firstName, String lastName, Integer custPin) {
		User newUser = new User(firstName, lastName, custPin);
		this.accountholders.add(newUser);
		return newUser;
	}

	// new Account creation
	public Account newAccount(String accountType, Double balance, User user) {
		Account account = new Account(accountType, balance, user, this);
		this.addAccount(account);
		user.addAccount(account);
		return account;

	}

	public User validateCustomer(Integer customerId, Integer customerPin) {

		for (User user : this.accountholders) {
			if (customerId.compareTo(user.getCustId()) == 0 && customerPin.compareTo(user.getCustPin()) == 0) {

				return user;
			}
		}

		return null;
	}

	@Override
	public String toString() {
		return "Bank [accountholders=" + accountholders + ", account=" + account + "]";
	}

	public void checkAmount(User user) {

		System.out.println("======================================");
		System.out.println("User Name: " + user.getFirstName() + " " + user.getLastName());
		System.out.println("Account No: " + user.getAccount().get(0).getAccountNumber());
		System.out.println("Account Type: " + user.getAccount().get(0).getAccountType());
		System.out.println("Account Balance: " + user.getAccount().get(0).getBalance());
		System.out.println("======================================");
	}

	public void withdrawAmount(Double amount, User user, Bank bank) {

		Double userBalance = user.getAccount().get(0).getBalance();
		if (amount > userBalance) {
			System.out.println("Sorry! Insufficient Amount");
		} else {
			user.getAccount().get(0).setBalance(userBalance - amount);
			long accountNumber = user.getAccount().get(0).getAccountNumber();
			user.getAccount().get(0).addTransaction(new Transaction(amount, accountNumber, "Debit"));
			System.out.println(amount + " successfully Debited");
		}

	}

	public void transactionHistory(User user) {

		long accountNumber = user.getAccount().get(0).getAccountNumber();
		ArrayList<Transaction> transaction = user.getAccount().get(0).getTransaction();

		System.out.println("=============================================================");
		System.out.println("Transaction history for account : " + accountNumber);
		for (int t = transaction.size() - 1; t >= 0; t--) {
			System.out.println(transaction.get(t).getSummaryLine());
		}
		System.out.println();
		System.out.println("=============================================================");
	}

	public void depositAmount(Double amount, User user, Bank bank) {
		
		Double userBalance = user.getAccount().get(0).getBalance();
		if (amount <0) {
			System.out.println("Sorry! please Enter Valid Amount to be deposit");
		} else {
			user.getAccount().get(0).setBalance(userBalance + amount);
			long accountNumber = user.getAccount().get(0).getAccountNumber();
			user.getAccount().get(0).addTransaction(new Transaction(amount, accountNumber, "Credit"));
			System.out.println(amount + " successfully Credited");
		}
		
	}

	public void transferMoney(Long toAccount, Double amount, User user) {
		
		User toUser=null;
		for(User cust:this.accountholders) {
			
			if(cust.getAccount().get(0).getAccountNumber().compareTo(toAccount)==0) {
				toUser=cust;
			}
		}
		Double userBalance = user.getAccount().get(0).getBalance();
		
		//from user
		if(amount>userBalance) {
			System.out.println("Sorry! Insufficient Balance");
		}else {
			user.getAccount().get(0).setBalance(userBalance - amount);
			long accountNumber = user.getAccount().get(0).getAccountNumber();
			user.getAccount().get(0).addTransaction(new Transaction(amount, accountNumber, "Debit"));
			System.out.println(amount + " successfully transfer");
		}
		
		//to User
		Double toUserBalance=toUser.getAccount().get(0).getBalance();
		toUser.getAccount().get(0).setBalance(toUserBalance+amount);
		long accountNumber1 = toUser.getAccount().get(0).getAccountNumber();
		toUser.getAccount().get(0).addTransaction(new Transaction(amount, accountNumber1, "Credit"));
		
		
	}

}
