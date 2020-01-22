package history;

import java.sql.SQLException;

public interface HistoryDBGateway {
	public History getLastHistoryByCertificateId(String certificateId) throws ClassNotFoundException, SQLException;
}
