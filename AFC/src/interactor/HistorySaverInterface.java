package interactor;

import java.sql.SQLException;

public interface HistorySaverInterface {
	public void updateEmbarkingStation(String certificateId, int stationId) throws ClassNotFoundException, SQLException;
	public void updateEndingStation(String certificateId, int stationId) throws ClassNotFoundException, SQLException;
	public void createNewHistorySlot(String certificateId) throws ClassNotFoundException, SQLException;
}
