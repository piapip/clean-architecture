package db;

import java.sql.Connection;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import interactor.HistorySaverInterface;

public class HistorySaver implements HistorySaverInterface{

	@Override
	public void updateEmbarkingStation(String id, int stationId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = ConnectToMySQL.getInformation("transaction_history");
		Statement statement = connection.createStatement();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		String sql = "UPDATE transactions SET status=" + Config.PENDING +
				", embarking_station_ID=" + stationId +
				", time_In=\"" + dtf.format(now) + "\"" +
				" WHERE certificateID=\"" + id + "\" AND status=" + Config.UNUSED;
		statement.executeUpdate(sql);
		connection.close();
	}

	@Override
	public void updateEndingStation(String id, int stationId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = ConnectToMySQL.getInformation("transaction_history");
		Statement statement = connection.createStatement();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		String sql = "UPDATE transactions SET status=" + Config.SUCCESSFUL +
				", ending_station_ID=" + stationId +
				", time_Out=\"" + dtf.format(now) + "\"" +
				" WHERE certificateID=\"" + id + "\" AND status=" + Config.PENDING;
		statement.executeUpdate(sql);
		connection.close();
	}
	
	public void createNewHistorySlot(String id) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectToMySQL.getInformation("transaction_history");
		Statement statement = connection.createStatement();
		String sql = "INSERT INTO `transactions` (certificateID, status) VALUES('" + id + "', '0');";
		statement.executeUpdate(sql);
		connection.close();
	}
}
