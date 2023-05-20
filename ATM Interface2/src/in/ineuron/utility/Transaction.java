package in.ineuron.utility;

import java.util.*;

public class Transaction {
		private Double amount;
		private Long accountNo;
		private Date timestamp;
		private String transType;
		public Transaction(Double amount, Long accountNo, String transType) {
	
			this.amount = amount;
			this.accountNo = accountNo;
			this.timestamp = new Date();
			this.transType=transType;
		}
		public String getSummaryLine() {
			return String.format(this.timestamp.toString()+" : Rs."+this.amount+" : "+this.transType);
		}
		
		
		

}
