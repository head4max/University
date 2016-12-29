package by.it_academy.model.dao;

import java.util.List;

import by.it_academy.model.entity4dao.Entity;

interface AbstractDAO<T extends Entity> {
	
	void create(List<T> entity);
	boolean add(T entity);
	boolean delete(int id);
	T getById(int id);
	List<T> getAll();
		
}
