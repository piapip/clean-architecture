package controller;

import java.sql.SQLException;

import interactor.HistorySaver;
import interactor.RequirementInterface;
import interactor.StationDistanceInterface;
import interactor.TicketUpdater;

public class Controller implements ControllerInterface {

	private RequirementInterface req;
	private TicketUpdater ticketInt;
	private StationDistanceInterface stationInt;
	private HistorySaver historyInt;
	
	public Controller(RequirementInterface req, TicketUpdater ticketInt, StationDistanceInterface stationInt, HistorySaver historyInt) {
		// TODO Auto-generated constructor stub
		this.req = req;
		this.ticketInt = ticketInt;
		this.stationInt = stationInt;
		this.historyInt = historyInt;
	}
	
	@Override
	public String enter(String certificateId, int stationId) throws ClassNotFoundException, SQLException {
//		String error = req.passEntering(certificateId);
//		if (error != null) return error;
//		historyInt.updateEmbarkingStation(certificateId, stationId);
		return null;
	}

	@Override
	public String exit(String certificateId, int stationId) {
		// TODO Auto-generated method stub
//		double distance = stationInt.getDistance(startingStationId, stationId);
//		String error = req.passExiting(certificateId, fee);
		return null;
	}
	
//	private double getFee(double distance) {
//		
//	}

}
