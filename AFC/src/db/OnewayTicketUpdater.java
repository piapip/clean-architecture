package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import certificate.Certificate;
import certificate.OnewayTicket;
import interactor.TicketUpdater;

public class OnewayTicketUpdater implements TicketUpdater{

	@Override
	public void updateCertificate(String id, Certificate newCertificate) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		OnewayTicket newTicket = (OnewayTicket) newCertificate;
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql = "UPDATE oneway_ticket SET status=" + newTicket.getStatus() + " WHERE id=\"" + newTicket.getID() + "\"";
		statement.executeUpdate(sql);
		connection.close();
	}	
}
