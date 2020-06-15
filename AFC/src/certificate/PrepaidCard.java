package certificate;

public class PrepaidCard extends Certificate{

	private double balance;
	
	public PrepaidCard(String id, int is_VIP, double balance) {
		super(id, Config.PREPAID_TYPE, is_VIP);
		this.balance = balance;
	}

	public double getBalance() {
		return this.balance;
	}
}
