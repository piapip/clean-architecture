package certificate;

import java.sql.SQLException;

public interface TicketDBGateway {	
	public Certificate getCertificateById(String id) throws SQLException, ClassNotFoundException;
}
