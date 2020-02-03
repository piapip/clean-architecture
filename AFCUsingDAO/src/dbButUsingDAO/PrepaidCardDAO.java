package dbButUsingDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import certificate.Dao;
import certificate.PrepaidCard;

public class PrepaidCardDAO implements Dao<PrepaidCard> {

	@Override
	public Optional<PrepaidCard> getById(String certificateId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql = "Select * from certificate_info WHERE id='" + certificateId +"'";
		ResultSet rs = statement.executeQuery(sql);
		Optional<PrepaidCard> result = null;
		if (rs != null) {
			while(rs.next()) {
				int type = rs.getInt(2);
				if (type != Config.PREPAID_TYPE) {
					System.out.println("This is not a prepaid card!");
					return null;
				}
				result = Optional.of(new PrepaidCard(certificateId, getBalance(certificateId)));
			}
		}
		connection.close();
		return result;
	}

	private double getBalance(String id) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql = "Select * from prepaid_card WHERE id='" + id + "'";
		ResultSet rs = statement.executeQuery(sql);
		double result = 0;
		if(rs != null) {
			while(rs.next()){
				result = rs.getDouble(2);
			}
		}
		connection.close();
		return result;
	}

	@Override
	public void update(PrepaidCard t) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql = "UPDATE prepaid_card SET balance=\"" + t.getBalance()+"\" WHERE id=\"" + t.getID()+ "\"";
		statement.executeUpdate(sql);
		connection.close();
	}
}
