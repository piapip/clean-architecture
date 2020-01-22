package requirements;

import java.sql.SQLException;

import certificate.PrepaidCard;
import certificate.TicketDBGateway;
import interactor.RequirementInterface;

public class RequirementPrepaidCard implements RequirementInterface {

	private TicketDBGateway gw;
	
	public RequirementPrepaidCard(TicketDBGateway mapper) {
		this.gw = mapper;
	}
	
	@Override
	public String passEntering(String certificateId) throws ClassNotFoundException, SQLException {
		PrepaidCard card = (PrepaidCard) gw.getCertificateById(certificateId);
		if (card == null) return "Card doesn't exist. Please buy a new one.";
		if (card.getLastHistory().getStatus() != Config.UNUSED) {
			return "You can't enter the station with this card. Probably stolen card.";
		}
		return null;
	}

	@Override
	public String passExiting(String certificateId, double fee) throws ClassNotFoundException, SQLException {
		PrepaidCard card = (PrepaidCard) gw.getCertificateById(certificateId);
		if (card == null) return "Card doesn't exist. Please buy a new one.";
		if (card.getLastHistory().getStatus() != Config.PENDING) {
			return "You can't enter the station with this card. Probably stolen card.";
		}
		if (card.getBalance() < fee) {
			double requirement = fee - card.getBalance();
			return "Card's balance is too low. Please recharge: " + requirement; 
		}
		return null;
	}
}
