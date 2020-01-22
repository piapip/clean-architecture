package interactor;

import java.sql.SQLException;

public interface TicketUpdater {
	public void updateCertificateEnter(String certificateId) throws ClassNotFoundException, SQLException;
	public void updateCertificateExit(String certificateId, double fee) throws ClassNotFoundException, SQLException;
}
