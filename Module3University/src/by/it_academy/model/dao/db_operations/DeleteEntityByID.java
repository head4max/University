package by.it_academy.model.dao.db_operations;

import by.it_academy.model.entity4dao.Entity;

public interface DeleteEntityByID<T extends Entity> {

	boolean delete(int id);
}
