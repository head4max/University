package by.it_academy.model.dao_impl;

import java.util.List;

import by.it_academy.model.dao.UserDAO;
import by.it_academy.model.entity4dao.User;

/**
 * @author head4max
 *
 */
public class UserDAOImpl implements UserDAO {

	/* (non-Javadoc)
	 * @see by.it_academy.model.dao.AbstractDAO#create(java.util.List)
	 */
	@Override
	public void create(List<User> entity) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see by.it_academy.model.dao.AbstractDAO#add(by.it_academy.model.entity4dao.Entity)
	 */
	@Override
	public boolean add(User entity) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see by.it_academy.model.dao.AbstractDAO#delete(int)
	 */
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see by.it_academy.model.dao.AbstractDAO#getById(int)
	 */
	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see by.it_academy.model.dao.AbstractDAO#getAll()
	 */
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see by.it_academy.model.dao.UserDAO#getID(java.lang.String, java.lang.String)
	 */
	@Override
	public Integer getID(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
