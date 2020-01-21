package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import certificate.Certificate;
import certificate.TicketDBGateway;

public class TicketDataMapper implements TicketDBGateway{

	@Override
	public Certificate getCertificateById(String id) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql = "Select * from certificate_info WHERE id='" + id +"'";
		ResultSet rs = statement.executeQuery(sql);
		Certificate result = null;
		if (rs != null) {
			while(rs.next()) {
				int type = rs.getInt(2);
				HistoryDataMapper historyMapper = new HistoryDataMapper();
				result = new Certificate(id, type, historyMapper.getLastHistoryByCertificateId(id));
			}
		}
		connection.close();
		return result;
	}
}
