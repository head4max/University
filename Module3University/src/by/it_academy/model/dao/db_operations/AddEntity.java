package by.it_academy.model.dao.db_operations;

import by.it_academy.model.entity4dao.Entity;

/**
 * @author head4max
 *
 */
public interface AddEntity<T extends Entity> {
	
	boolean add(T entity);
}
