package certificate;

public class PrepaidCard extends Certificate{

	private double balance;
	
	public PrepaidCard(String id, double balance) {
		super(id, Config.PREPAID_TYPE);
		this.balance = balance;
	}

	public double getBalance() {
		return this.balance;
	}
}
