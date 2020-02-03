package dbButUsingDAO;

import java.sql.SQLException;
import java.util.Optional;

public interface Dao<T> {
	Optional<T> getById(String certificateId) throws ClassNotFoundException, SQLException;
	void update(T t) throws ClassNotFoundException, SQLException;
}
