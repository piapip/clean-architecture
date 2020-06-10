package certificate;

public class Hour24Ticket extends Certificate{
	
	private int status;
	private String activeTime;
	private String expiredTime;
	
	public Hour24Ticket(String id, int status, String activeTime, String expiredTime) {
		super(id, Config.HOUR24_TYPE);
		this.status = status;
		this.activeTime=activeTime;
		this.expiredTime=expiredTime;
	}
	
	public int getStatus() {
		return status;
	}
	
	public String getActiveTime() {
		return activeTime;
	}
	
	public String getExpiredTime() {
		return expiredTime;
	}
	
	public boolean isExpired() {
		if((this.getActiveTime()).compareTo(this.getExpiredTime())==-1) return true;
		return false;
	}
}


