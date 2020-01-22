package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import certificate.Certificate;
import certificate.PrepaidCard;
import interactor.TicketUpdater;

public class PrepaidCardUpdater implements TicketUpdater{

	@Override
	public void updateCertificate(String id, Certificate newCertificate) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
//		PrepaidCardDataMapper mapper = new PrepaidCardDataMapper();
//		PrepaidCard oldCard = mapper.getCertificateById(id);
//		if(oldCard.getID() != id) {
//			System.out.println("Can't update the card like this.");
//			return;
//		}
		PrepaidCard newCard = (PrepaidCard) newCertificate;
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql = "UPDATE prepaid_card SET balance=\"" + newCard.getBalance()+"\" WHERE id=\"" + newCard.getID()+ "\"";
		statement.executeUpdate(sql);
		connection.close();
	}	
}
