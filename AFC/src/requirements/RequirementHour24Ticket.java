package requirements;

import java.sql.SQLException;

import certificate.Hour24Ticket;
import certificate.TicketDBGateway;
import history.HistoryDBGateway;
import interactor.RequirementInterface;

public class RequirementHour24Ticket implements RequirementInterface{

	private TicketDBGateway ticketGW;
	private HistoryDBGateway historyGW;
	//	this one left me wondering... shouldn't I specify this initiator already here, the book said that I mustn't do that
	public RequirementHour24Ticket(TicketDBGateway ticketMapper, HistoryDBGateway historyMapper) {
		this.ticketGW = ticketMapper;
		this.historyGW = historyMapper;
	}
	
	@Override
	public String passEntering(String certificateId) throws ClassNotFoundException, SQLException {
		Hour24Ticket ticket = (Hour24Ticket) ticketGW.getCertificateById(certificateId);
		if (ticket == null) return "Ticket doesn't exist. Please buy a new one.";
		if(ticket.getStatus() == Config.EXPIRED) {
			return "The ticket is already used.";
		}
		if(historyGW.getLastHistoryByCertificateId(certificateId).getStatus() != Config.UNUSED || 
				historyGW.getLastHistoryByCertificateId(certificateId).getStatus() != Config.SUCCESSFUL) {
			return "You can't enter the station with this ticket.";
		}
		return null;
	}

	@Override
	public String passExiting(String certificateId, double fee) throws ClassNotFoundException, SQLException {
		Hour24Ticket ticket = (Hour24Ticket) ticketGW.getCertificateById(certificateId);
		if (ticket == null) return "Ticket doesn't exist. Please buy a new one.";
		if(ticket.getStatus() == Config.EXPIRED) {
			return "The ticket is already used.";
		}
		if (historyGW.getLastHistoryByCertificateId(certificateId).getStatus() != Config.PENDING) {
			return "You can't exit the station with this ticket.";
		}
		if (ticket.isExpired()) 
			return "The ticket is outdated! It can't be used anymore";
		return null;
	}

}
