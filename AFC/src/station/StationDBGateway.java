package station;

import java.sql.SQLException;

public interface StationDBGateway {
	public Station getStationById(int id) throws ClassNotFoundException, SQLException;
}
