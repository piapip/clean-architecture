package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import interactor.TicketUpdater;

public class Hour24TicketUpdater implements TicketUpdater{

	@Override
	public void updateCertificateEnter(String certificateId) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql1 = "UPDATE hour24_ticket SET status=\"" + Config.PENDING +  "\" WHERE id=\"" + certificateId+ "\"";
		statement.executeUpdate(sql1);
		connection.close();
		
	}

	@Override
	public void updateCertificateExit(String certificateId, double fee) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql1 = "UPDATE hour24_ticket SET status=\"" + Config.SUCCESSFUL +  "\" WHERE id=\"" + certificateId + "\"";
		statement.executeUpdate(sql1);
		connection.close();
	}

}
