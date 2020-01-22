package interactor;

import java.sql.SQLException;

public interface HistorySaver {
	public void updateEmbarkingStation(String id, int stationId) throws ClassNotFoundException, SQLException;
	public void updateEndingStation(String id, int stationId) throws ClassNotFoundException, SQLException;
	public void createNewHistorySlot(String id) throws ClassNotFoundException, SQLException;
}
