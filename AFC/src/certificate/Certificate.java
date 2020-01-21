package certificate;

public class Certificate {
	private String id;
	private int type;
	LastHistory lastHistory;
	
	public Certificate(String id, int type, LastHistory history) {
		this.id = id;
		this.type = type;
		this.lastHistory = history;
	}	
	
	public String getID() {
		return this.id;
	}
	
	public int getType() {
		return this.type;
	}
	
	public LastHistory getLastHistory() {
		return this.lastHistory;
	}
	
	public String toString() {
		String typeName;
		if(this.type == Config.ONEWAY_TYPE) typeName = "Oneway ticket";
		else if(this.type == Config.HOUR24_TYPE) typeName = "24-hour ticket";
		else if(this.type == Config.PREPAID_TYPE) typeName = "Prepaid card";
		else typeName = null;
		return String.format("ID: " + this.id + "\nType: " + typeName);
	}
}
