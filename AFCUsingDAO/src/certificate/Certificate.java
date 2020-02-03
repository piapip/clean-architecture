package certificate;

public abstract class Certificate {
	private String id;
	private int type;
	
	public Certificate(String id, int type) {
		this.id = id;
		this.type = type;
	}	
	
	public String getID() {
		return this.id;
	}
	
	public int getType() {
		return this.type;
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
