package in.ineuron.utility;
import java.util.*;
public class User {

	private String firstName;
	private String LastName;
	
	//no of account user have
	public ArrayList<Account> account;
	
	//get unique userId
	private Integer custId;
	private Integer custPin;
	
	public User(String firstName, String lastName, Integer custPin) {
		this.firstName = firstName;
		this.LastName = lastName;
		this.account = new ArrayList<>();
		this.custPin = custPin;
		this.custId=this.newUserId();
	}
	
	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.LastName;
	}

	public Integer getCustId() {
		return this.custId;
	}
	
	public Integer getCustPin() {
		return this.custPin;
	}
	
	public ArrayList<Account> getAccount() {
		return account;
	}

	//get unique Customer Id
	public Integer newUserId() {
		Integer customerId=0;
		int k=6;
		while(k-->0) {
		customerId= customerId*10 + new Random().nextInt(10)+1;
		}
		return customerId;
	}

	//add account to user
	public void addAccount(Account accnt) {
		this.account.add(accnt);
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", LastName=" + LastName + ", account=" + account + ", custId=" + custId
				+ ", custPin=" + custPin + "]";
	}
	
	
	
	//Testing purpose
	
	
}
