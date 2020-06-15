package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import certificate.OnewayTicket;
import certificate.TicketDBGateway;

public class OnewayTicketDataMapper implements TicketDBGateway {

	@Override
	public OnewayTicket getCertificateById(String id) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql = "Select * from certificate_info WHERE id='" + id +"'";
		ResultSet rs = statement.executeQuery(sql);
		OnewayTicket result = null;
		if (rs != null) {
			while(rs.next()) {
				int type = rs.getInt(2);
				int is_VIP = rs.getInt(3);
				if (type != Config.ONEWAY_TYPE) {
					System.out.println("This is not an oneway ticket!");
					return null;
				}
				result = new OnewayTicket(id,
						is_VIP,
						getStatus(id), 
						getStartingStation(id), 
						getEndingStation(id), 
						getFee(id));
			}
		}
		connection.close();
		return result;
	}
	
	private int getStatus(String id) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql = "Select * from oneway_ticket WHERE id='" + id + "'";
		ResultSet rs = statement.executeQuery(sql);
		int result = 0;
		if(rs != null) {
			while(rs.next()){
				result = rs.getInt(2);
			}
		}
		connection.close();
		return result;
	}
	
	private int getStartingStation(String id) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql = "Select * from oneway_ticket WHERE id='" + id + "'";
		ResultSet rs = statement.executeQuery(sql);
		int result = 0;
		if(rs != null) {
			while(rs.next()){
				result = rs.getInt(3);
			}
		}
		connection.close();
		return result;
	}
	
	private int getEndingStation(String id) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql = "Select * from oneway_ticket WHERE id='" + id + "'";
		ResultSet rs = statement.executeQuery(sql);
		int result = 0;
		if(rs != null) {
			while(rs.next()){
				result = rs.getInt(4);
			}
		}
		connection.close();
		return result;
	}
	
	private double getFee(String id) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql = "Select * from oneway_ticket WHERE id='" + id + "'";
		ResultSet rs = statement.executeQuery(sql);
		double result = 0;
		if(rs != null) {
			while(rs.next()){
				result = rs.getDouble(5);
			}
		}
		connection.close();
		return result;
	}
}
