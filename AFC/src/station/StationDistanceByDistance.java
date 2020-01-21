package station;

import java.sql.SQLException;

import db.StationDataMapper;
import interactor.StationDistanceInterface;

public class StationDistanceByDistance implements StationDistanceInterface{

	@Override
	public double getDistance(int startingStationId, int endingStationId) throws ClassNotFoundException, SQLException {
		StationDBGateway gw = new StationDataMapper();
		Station starting = gw.getStationById(startingStationId);
		Station ending = gw.getStationById(endingStationId);
		return Math.abs(ending.getDistanceToTerminus() - starting.getDistanceToTerminus());
	}
}
