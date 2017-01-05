package by.it_academy.model.dao;

import by.it_academy.model.entity4dao.User;

public interface UserDAO extends AbstractDAO<User> {
	
	Integer getID(String login, String password);
}
