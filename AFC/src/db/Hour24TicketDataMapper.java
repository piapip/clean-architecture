package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import certificate.Hour24Ticket;
import certificate.TicketDBGateway;

public class Hour24TicketDataMapper implements TicketDBGateway  {

	@Override
	public Hour24Ticket getCertificateById(String id) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");;
		Statement statement = connection.createStatement();
		String sql = "Select * from hour24_ticket WHERE id='" + id + "'";
		ResultSet rs = statement.executeQuery(sql);
		if(rs != null) {
			while(rs.next()){
				int status = rs.getInt(2);
				String activeTime = rs.getString(3);
				String expiredTime = rs.getString(4);
				connection.close();
				return new Hour24Ticket(id, status, activeTime, expiredTime);
			}
		}
		connection.close();
		return null;
	}

}
