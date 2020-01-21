package certificate;

public class PrepaidCard extends Certificate{

	private double balance;
	
	public PrepaidCard(String id, LastHistory history, double balance) {
		super(id, Config.PREPAID_TYPE, history);
		this.balance = balance;
	}

	public double getBalance() {
		return this.balance;
	}
}
