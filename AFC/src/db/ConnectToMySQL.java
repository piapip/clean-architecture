package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToMySQL {
	protected static Connection getInformation(String dbName) throws SQLException, ClassNotFoundException {
		String hostName = "localhost";
		String userName = Config.dbUsername;
		String password = Config.dbPassword;
		return getInformation(hostName, dbName, userName, password);
	}
	
	protected static Connection getInformation(String hostName, String dbName, String userName, String password) throws SQLException, ClassNotFoundException {
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
	}
}
