package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import station.Station;
import station.StationDBGateway;

public class StationDataMapper implements StationDBGateway {
	@Override
	public Station getStationById(int id) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectToMySQL.getInformation("station_system");
		Statement statement = connection.createStatement();
		String sql = "Select * from station WHERE id='" + id + "'";
		ResultSet rs = statement.executeQuery(sql);
		Station result = null;
		while(rs.next()) {
			int stationId = rs.getInt(1);
			String stationName = rs.getString(2);
			double stationDistance = rs.getDouble(3);
			result = new Station(stationId, stationName, stationDistance);
		}
		connection.close();
		return result;
	}
}
