
package in.ineuron.utility;

import java.util.Scanner;

public class BankTransactionImpl implements BankTransaction {

	@Override
	public User validateUser(Integer customerId,Integer customerPin,Bank bank) {
		
		User isValidCustomer=null;
		isValidCustomer=bank.validateCustomer(customerId,customerPin);	
		return isValidCustomer;
	}

	@Override
	public void checkBalance(User user,Bank bank) {
	
		bank.checkAmount(user);

	}

	@Override
	public void transferMoney(User user,Scanner sc,Bank bank) {
		
		Long toAccount;
		System.out.println("Enter a account no to be send..");
		toAccount=sc.nextLong();
		
		Double amount;
		System.out.println("Enter the amount to be send");
		amount=sc.nextDouble();
		
		bank.transferMoney(toAccount,amount,user);

	}

	@Override
	public void transactionHistory(User user,Bank bank) {
		bank.transactionHistory(user);
	}

	@Override
	public void withdrawAmount(User user,Scanner sc,Bank bank) {
	
		System.out.println("Enter amount to be withdrawn:");
		Double amount=sc.nextDouble();
		bank.withdrawAmount(amount,user,bank);

	}

	@Override
	public void depositeAmount(User user, Scanner sc,Bank bank) {
		System.out.println("Enter amount to be Deposited:");
		Double amount=sc.nextDouble();
		bank.depositAmount(amount,user,bank);
		
	}

	@Override
	public void exitAtm() {
		System.out.println("Thank you for using Ineuron ATM");
		System.exit(0);
		
	}

}
