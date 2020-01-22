package controller;

import java.sql.SQLException;

public interface ControllerInterface {
	public String enter(String certificateId, int stationId) throws ClassNotFoundException, SQLException;
	public String exit(String certificateId, int stationId) throws ClassNotFoundException, SQLException;
}
