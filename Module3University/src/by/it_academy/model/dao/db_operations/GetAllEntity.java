package by.it_academy.model.dao.db_operations;

import java.util.List;

import by.it_academy.model.entity4dao.Entity;

/**
 * @author head4max
 *
 */
public interface GetAllEntity<T extends Entity> {

	List<T> getAll();
}
