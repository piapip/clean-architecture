package station;

import java.sql.SQLException;

import db.StationDataMapper;
import interactor.StationDistanceInterface;

public class StationDistanceByZone implements StationDistanceInterface{
	
	@Override
	public double getDistance(int startingStationId, int endingStationId) throws ClassNotFoundException, SQLException {
		return Math.abs(getZone(startingStationId) - getZone(endingStationId));				
	}
	
	private int getZone(int stationID) throws ClassNotFoundException, SQLException {
		StationDBGateway gw = new StationDataMapper();
		Station station = gw.getStationById(stationID);
		if(station.getId() >= 0 && station.getId() <= 3) {
			return Config.A;
		} else if (station.getId() > 3 && station.getId() <= 6) {
			return Config.B;
		} else {
			return Config.C;
		}
	}
}
