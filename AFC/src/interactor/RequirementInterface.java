package interactor;

import java.sql.SQLException;

public interface RequirementInterface {
	public String passEntering(String certificateId) throws ClassNotFoundException, SQLException;
	public String passExiting(String certificateId, double fee) throws ClassNotFoundException, SQLException;
}
