package interactor;

import java.sql.SQLException;

public interface StationDistanceInterface {
	public double getDistance(int startingStationId, int endingStationId) throws ClassNotFoundException, SQLException;
}
