package dbButUsingDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import history.History;

public class HistoryDataDAO implements Dao<History>{

	@Override
	public Optional<History> getById(String certificateId) throws ClassNotFoundException, SQLException {
		return getHistoryByCertificateId(certificateId);
	}
	
	private Optional<History> getHistoryByCertificateId(String certificateId) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectToMySQL.getInformation("transaction_history");
		Statement statement = connection.createStatement();
		String sql = "Select * from transactions WHERE certificateId='" + certificateId + "' ORDER BY status ASC  \r\n" + 
				"LIMIT 1";
		ResultSet rs = statement.executeQuery(sql);
		Optional<History> result = null;
		if (rs != null) {
			while(rs.next()) {
				int historyId = rs.getInt(1);
				int status = rs.getInt(3);
				String dayIn = rs.getDate(4) + " " + rs.getTime(4);
				String dayOut = rs.getDate(5) + " " + rs.getTime(5); 
				int embarkingStationID = rs.getInt(6);
				int endingStationID = rs.getInt(7);	
				result = Optional.of(new History(historyId, certificateId, status, dayIn, dayOut, embarkingStationID, endingStationID));
			}			
		}
		connection.close();
		return result;
	}

	@Override
	public void update(History t) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = ConnectToMySQL.getInformation("transaction_history");
		Statement statement = connection.createStatement();
		String sql = "UPDATE transactions SET status=" + t.getStatus()+" WHERE id=\"" + t.getId()+ "\"";
		statement.executeUpdate(sql);	
		if(t.getEmbarkingStationID() != 0) {
			sql = "UPDATE transactions SET embarking_station_ID=\"" + t.getEmbarkingStationID()+"\" WHERE id=\"" + t.getId()+ "\"";
			statement.executeUpdate(sql);	
		}
		if(t.getEndingStationID() != 0) {
			sql = "UPDATE transactions SET ending_station_ID=\"" + t.getEndingStationID()+"\" WHERE id=\"" + t.getId()+ "\"";
			statement.executeUpdate(sql);	
		}
		if(!t.getDayIn().equals("null null")) {
			sql = "UPDATE transactions SET time_In=\"" + t.getDayIn() +"\" WHERE id=\"" + t.getId()+ "\"";
			statement.executeUpdate(sql);
		}
		if(!t.getDayOut().equals("null null")) {
			sql = "UPDATE transactions SET time_Out=\"" + t.getDayOut() +"\" WHERE id=\"" + t.getId()+ "\"";
			statement.executeUpdate(sql);
		}
		connection.close();
	}
	
	public void createNewHistorySlot(String certificateId) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectToMySQL.getInformation("transaction_history");
		Statement statement = connection.createStatement();
		String sql = "INSERT INTO `transactions` (certificateID, status) VALUES('" + certificateId + "', '0');";
		statement.executeUpdate(sql);
		connection.close();
	}
}
