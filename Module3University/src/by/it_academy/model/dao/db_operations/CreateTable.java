package by.it_academy.model.dao.db_operations;

import java.sql.SQLException;
import java.util.List;

import by.it_academy.model.entity4dao.Entity;

/**
 * @author head4max
 *
 */
public interface CreateTable<T extends Entity> {

	void create(List<T> entity) throws SQLException;
}
