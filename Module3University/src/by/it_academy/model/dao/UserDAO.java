package by.it_academy.model.dao;

import by.it_academy.model.entity4dao.User;

public interface UserDAO extends AbstractDAO<User> {
	
	User getByLoginPassword(String login, String password);
}
