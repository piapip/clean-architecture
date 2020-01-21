package station;

import java.sql.SQLException;

import interactor.StationDistanceInterface;

public class StationDistanceByDistance implements StationDistanceInterface{
	
	private StationDBGateway gw;
	
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
