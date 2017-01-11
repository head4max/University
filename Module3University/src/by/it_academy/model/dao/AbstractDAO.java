package by.it_academy.model.dao;

import by.it_academy.model.dao.db_operations.*;
import by.it_academy.model.entity4dao.Entity;

public interface AbstractDAO<T extends Entity> extends CreateTable<T>, AddEntity<T>, DeleteEntityByID<T>, GetEntityByID<T>, GetAllEntity<T> {
		
}
