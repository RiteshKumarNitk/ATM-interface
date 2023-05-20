package in.ineuron.utility;

import java.util.Scanner;

public interface BankTransaction {

	User validateUser(Integer customerId,Integer customerPin,Bank bank);
	void checkBalance(User user,Bank bank);
	void transferMoney(User user,Scanner sc,Bank bank);
	void withdrawAmount(User user,Scanner sc,Bank bank);
	void depositeAmount(User user,Scanner sc,Bank bank);
	void exitAtm();
	void transactionHistory(User user, Bank bank);
	
}
