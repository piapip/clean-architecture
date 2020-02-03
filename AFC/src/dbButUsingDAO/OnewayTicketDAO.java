package dbButUsingDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import certificate.OnewayTicket;

public class OnewayTicketDAO implements Dao<OnewayTicket> {

	@Override
	public Optional<OnewayTicket> getById(String certificateId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql = "Select * from certificate_info WHERE id='" + certificateId +"'";
		ResultSet rs = statement.executeQuery(sql);
		Optional<OnewayTicket> result = null;
		if (rs != null) {
			while(rs.next()) {
				int type = rs.getInt(2);
				if (type != Config.ONEWAY_TYPE) {
					System.out.println("This is not an oneway ticket!");
					return null;
				}
				result = Optional.of(new OnewayTicket(certificateId,
						getStatus(certificateId), 
						getStartingStation(certificateId), 
						getEndingStation(certificateId), 
						getFee(certificateId)));
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

	@Override
	public void update(OnewayTicket t) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql = "UPDATE onewayticket SET status=\"" + t.getStatus() + "\" WHERE id=\"" + t.getID()
				+ "\"";
		statement.executeUpdate(sql);
		connection.close();
	}
	
}
