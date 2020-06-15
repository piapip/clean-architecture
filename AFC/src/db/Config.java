package db;

public class Config {
	public static final String dbUsername = "root";
	public static final String dbPassword = "root";
	
	public static final int ONEWAY_TYPE = 1;
	public static final int HOUR24_TYPE = 2;
	public static final int PREPAID_TYPE = 3;
	public static final int VIP_TYPE = 4;

	public static final int UNUSED = 0;
	public static final int PENDING = 1;
	public static final int SUCCESSFUL = 2;
	public static final int EXPIRED = 3; //cho ticket
}
