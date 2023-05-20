package in.ineuron.main;

import java.util.*;

import in.ineuron.utility.*;

public class IneuronAtm {

	private static Integer customerId;
	private static Integer customerPin;
	private static User isValidUser = null;
	private static Scanner sc = null;
	private static BankTransactionImpl ATM = null;

	public static void main(String[] args) {

		ATM = new BankTransactionImpl();

		// create new User
		Bank bank = new Bank();
		
		//1st User
		User newUser = bank.addNewCustomer("Ritesh", "Kumar", 22222);
		Account newAccount = bank.newAccount("Savings", 150000.00, newUser);

		System.out.print("Account Holder Name : "+newUser.getFirstName() + " " + newUser.getLastName() + '\n' + "Customer Id:"
				+ newUser.getCustId()+'\n'+"Account No: "+newAccount.getAccountNumber());
		System.out.println();
		
		//2nd user
		User newUser2 = bank.addNewCustomer("Akash", "Singh", 33333);
		Account newAccount2 = bank.newAccount("Savings", 200000.00, newUser2);
		System.out.print(newUser2.getFirstName() + " " + newUser2.getLastName() + '\n' + "Customer Id:"
				+ newUser2.getCustId()+'\n'+"Account No: "+newAccount2.getAccountNumber());
		System.out.println();

		User newUser3 = bank.addNewCustomer("Akash", "Singh", 44444);
		Account newAccount3 = bank.newAccount("Savings", 100000.00, newUser3);
		System.out.print(newUser3.getFirstName() + " " + newUser2.getLastName() + '\n' + "Customer Id:"
				+ newUser3.getCustId()+'\n'+"Account No: "+newAccount3.getAccountNumber());
		System.out.println();
		
		//taking input form user
		sc = new Scanner(System.in);
		userLogin(sc,bank);

	}

	public static void userLogin(Scanner sc,Bank bank) {
		System.out.println("Enter Customer Id:");
		customerId = sc.nextInt();

		System.out.println("Enter Customer Pin:");
		customerPin = sc.nextInt();

		isValidUser = ATM.validateUser(customerId, customerPin, bank);

		System.out.println();

		if (isValidUser != null) {

			System.out.println("Hello " + isValidUser.getFirstName() + " " + isValidUser.getLastName());
			getMenu(isValidUser, sc,bank);
		} else if (isValidUser == null) {
			System.out.println("The Pin is incorrect. Try again");
			userLogin(sc,bank);
		}
	}

	// main menu prompt
	private static void getMenu(User user, Scanner sc,Bank bank) {
		int choice;
		
		// user menu
		do {
			
			System.out.println("====================WELCOME TO iNEURON ATM====================");
			System.out.println("1.>Show Transaction History");
			System.out.println("2.>checkBalance");
			System.out.println("3.>withdraw");
			System.out.println("4.>Deposite");
			System.out.println("5.>Transfer");
			System.out.println("6.>Quit");
			System.out.println();
			System.out.println("==============================================================");
			System.out.println("Enter Your Choice : ");
			choice = sc.nextInt();
			if (choice < 1 || choice > 6) {
				System.out.println("Invalid Choice" + " Please choose between 1-6 ");
				getMenu(user, sc,bank);
			}
			else
			{
				switch (choice) {
				case 1:
					ATM.transactionHistory(user,bank);
					menuDispAgain(user,sc,bank);
					break;
				case 2:
					ATM.checkBalance(user,bank);
					menuDispAgain(user,sc,bank);
					break;
				case 3:
					ATM.withdrawAmount(user, sc,bank);
					menuDispAgain(user,sc,bank);
					break;
				case 4:
					ATM.depositeAmount(user, sc,bank);
					menuDispAgain(user,sc,bank);
					break;
				case 5:
					ATM.transferMoney(user, sc,bank);
					ATM.checkBalance(user,bank);
					int checkUser2=0;
					System.out.println("Enter 8 User login Again");
					checkUser2=sc.nextInt();
					if(checkUser2==8) {
						userLogin(sc,bank);
					}else
					{
						menuDispAgain(user,sc,bank);
					}
					break;
				case 6:
					ATM.exitAtm();break;
				default:
					sc.nextLine();
					break;
				}

			}

		} while (choice < 1 || choice > 5);


	}
	
	private static void menuDispAgain(User user,Scanner sc,Bank bank) {
		   System.out.println("Press \"ENTER\" to continue...");
		   Scanner scanner = new Scanner(System.in);
		   scanner.nextLine();
		   getMenu(user,sc,bank);
	}

//end of class
}
