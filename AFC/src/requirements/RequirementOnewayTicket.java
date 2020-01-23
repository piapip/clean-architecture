package requirements;

import java.sql.SQLException;

import certificate.OnewayTicket;
import certificate.TicketDBGateway;
import history.HistoryDBGateway;
import interactor.RequirementInterface;

public class RequirementOnewayTicket implements RequirementInterface{

	private TicketDBGateway ticketGW;
	private HistoryDBGateway historyGW;
	//	this one left me wondering... shouldn't I specify this initiator already here, the book said that I mustn't do that
	public RequirementOnewayTicket(TicketDBGateway ticketMapper, HistoryDBGateway historyMapper) {
		this.ticketGW = ticketMapper;
		this.historyGW = historyMapper;
	}
	
	@Override
	public String passEntering(String certificateId) throws ClassNotFoundException, SQLException {
		OnewayTicket ticket = (OnewayTicket) ticketGW.getCertificateById(certificateId);
		if (ticket == null) return "Ticket doesn't exist. Please buy a new one.";
		if(ticket.getStatus() == Config.EXPIRED) {
			return "The ticket is already used.";
		}
		if(historyGW.getLastHistoryByCertificateId(certificateId).getStatus() != Config.UNUSED) {
			return "You can't enter the station with this ticket.";
		}
		return null;
	}

	@Override
	public String passExiting(String certificateId, double fee) throws ClassNotFoundException, SQLException {
		OnewayTicket ticket = (OnewayTicket) ticketGW.getCertificateById(certificateId);
		if (ticket == null) return "Ticket doesn't exist. Please buy a new one.";
		if(ticket.getStatus() == Config.EXPIRED) {
			return "The ticket is already used.";
		}
		if (historyGW.getLastHistoryByCertificateId(certificateId).getStatus() != Config.PENDING) {
			return "You can't exit the station with this ticket.";
		}
		if (ticket.getFare() < fee) 
			return "You have gone too far. Please purchase another ticket with the price of " + fee;
		return null;
	}
}
