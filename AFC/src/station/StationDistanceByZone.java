package station;

import java.sql.SQLException;

import interactor.StationDistanceInterface;

public class StationDistanceByZone implements StationDistanceInterface{

	private StationDBGateway gw;
	//	this one left me wondering... shouldn't I specify this initiator already here, the book said that I mustn't do that
	public StationDistanceByZone(StationDBGateway gw) {
		this.gw = gw;
	}
	
	@Override
	public double getDistance(int startingStationId, int endingStationId) throws ClassNotFoundException, SQLException {
		return Math.abs(getZone(startingStationId) - getZone(endingStationId));				
	}
	
	private int getZone(int stationID) throws ClassNotFoundException, SQLException {
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
