package by.it_academy.model.dao.db_operations;

import by.it_academy.model.entity4dao.Entity;

/**
 * @author head4max
 *
 */
public interface GetEntityByID<T extends Entity> {

	T getById(int id);
}
