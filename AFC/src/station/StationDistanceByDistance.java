package station;

import java.sql.SQLException;

import interactor.StationDistanceInterface;

public class StationDistanceByDistance implements StationDistanceInterface{
	
	private StationDBGateway gw;
	//	this one left me wondering... shouldn't I specify this initiator already here, the book said that I mustn't do that
	public StationDistanceByDistance(StationDBGateway gw) {
		this.gw = gw;
	}
	
	@Override
	public double getDistance(int startingStationId, int endingStationId) throws ClassNotFoundException, SQLException {
		Station starting = gw.getStationById(startingStationId);
		Station ending = gw.getStationById(endingStationId);
		return Math.abs(ending.getDistanceToTerminus() - starting.getDistanceToTerminus());
	}
}
