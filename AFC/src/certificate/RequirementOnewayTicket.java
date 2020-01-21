package certificate;

import java.sql.SQLException;

import interactor.RequirementInterface;

public class RequirementOnewayTicket implements RequirementInterface{

	private TicketDBGateway gw;
	
	public RequirementOnewayTicket(TicketDBGateway mapper) {
		this.gw = mapper;
	}
	
	@Override
	public String passEntering(String certificateId) throws ClassNotFoundException, SQLException {
		OnewayTicket ticket = (OnewayTicket) gw.getCertificateById(certificateId);
		if (ticket == null) return "Ticket doesn't exist. Please buy a new one.";
		if (ticket.getLastHistory().getStatus() != Config.UNUSED) {
			return "You can't enter the station with this ticket.";
		}
		return null;
	}

	@Override
	public String passExiting(String certificateId, double fee) throws ClassNotFoundException, SQLException {
		OnewayTicket ticket = (OnewayTicket) gw.getCertificateById(certificateId);
		if (ticket == null) return "Ticket doesn't exist. Please buy a new one.";
		if (ticket.getLastHistory().getStatus() != Config.PENDING) {
			return "You can't exit the station with this ticket.";
		}
		if (ticket.getFare() < fee) 
			return "You have gone too far. Please purchase another ticket with the price of " + fee;
		return null;
	}
}
