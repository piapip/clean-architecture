package interactor;

import java.sql.SQLException;

import certificate.Certificate;

public interface TicketUpdater {
	public void updateCertificate(String id, Certificate newCertificate) throws ClassNotFoundException, SQLException;
}
