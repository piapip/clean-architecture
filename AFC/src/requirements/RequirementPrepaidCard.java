package requirements;

import java.sql.SQLException;

import certificate.PrepaidCard;
import certificate.TicketDBGateway;
import history.HistoryDBGateway;
import interactor.RequirementInterface;

public class RequirementPrepaidCard implements RequirementInterface {

	private TicketDBGateway cardGateWay;
	private HistoryDBGateway historyGW;
	
	public RequirementPrepaidCard(TicketDBGateway cardMapper, HistoryDBGateway historyMapper) {
		this.cardGateWay = cardMapper;
		this.historyGW = historyMapper;
	}
	
	@Override
	public String passEntering(String certificateId) throws ClassNotFoundException, SQLException {
		PrepaidCard card = (PrepaidCard) cardGateWay.getCertificateById(certificateId);
		if (card == null) return "Card doesn't exist. Please buy a new one.";
		if (historyGW.getLastHistoryByCertificateId(certificateId).getStatus() != Config.UNUSED) {
			return "You can't enter the station with this card. Probably stolen card.";
		}
		return null;
	}

	@Override
	public String passExiting(String certificateId, double fee) throws ClassNotFoundException, SQLException {
		PrepaidCard card = (PrepaidCard) cardGateWay.getCertificateById(certificateId);
		if (card == null) return "Card doesn't exist. Please buy a new one.";
		if (historyGW.getLastHistoryByCertificateId(certificateId).getStatus() != Config.PENDING) {
			return "You can't enter the station with this card. Probably stolen card.";
		}
		if (card.getBalance() < fee) {
			double requirement = fee - card.getBalance();
			return "Card's balance is too low. Please recharge: " + requirement; 
		}
		return null;
	}
}
