package certificate;

public class OnewayTicket extends Certificate {
	
	private int status;
	private int startingStation;
	private int endingStation;
	private double fare;
	
	public OnewayTicket(String onewayId, LastHistory history, int status, int startingStation, int endingStation, double fare) {
		super(onewayId, Config.ONEWAY_TYPE, history);
		this.status = status;
		this.startingStation = startingStation;
		this.endingStation = endingStation;
		this.fare = fare;
	}
	
	public int getStatus() {
		return this.status;
	}
	
	public int getStartingStation() {
		return startingStation;
	}

	public int getEndingStation() {
		return endingStation;
	}

	public double getFare() {
		return fare;
	}
}
