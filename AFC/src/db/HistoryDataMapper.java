package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import history.History;
import history.HistoryDBGateway;

public class HistoryDataMapper implements HistoryDBGateway {
	
	public History getLastHistoryByCertificateId(String id) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectToMySQL.getInformation("transaction_history");
		Statement statement = connection.createStatement();
		String sql = "Select * from transactions WHERE certificateId='" + id + "' ORDER BY status ASC  \r\n" + 
				"LIMIT 1";
		ResultSet rs = statement.executeQuery(sql);
		History result = null;
		if (rs != null) {
			while(rs.next()) {
				int historyId = rs.getInt(1);
				int status = rs.getInt(3);
				String dayIn = rs.getDate(4) + " " + rs.getTime(4);
				String dayOut = rs.getDate(5) + " " + rs.getTime(5); 
				int embarkingStationID = rs.getInt(6);
				int endingStationID = rs.getInt(7);	
				result = new History(historyId, id, status, dayIn, dayOut, embarkingStationID, endingStationID);
			}			
		}
		connection.close();
		return result;
	}
}
