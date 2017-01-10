package by.it_academy.model.dao_impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;

import by.it_academy.model.dao.UserDAO;
import by.it_academy.model.entity4dao.ExtendedUser;
import by.it_academy.model.entity4dao.User;

/**
 * @author head4max
 *
 */
public class UserDAOImpl extends DAOImplConnection implements UserDAO {
	
//	private static String addAllPreparedStatement;

	static{
		ResourceBundle rbUserDAOImpl = ResourceBundle.getBundle("by.it_academy.model.sql_properties.sql_prepared_statement");
		
		createPreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("create"), rbUserDAOImpl.getString("usersTableName"), rbUserDAOImpl.getString("users_table_create"));
		addPreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("add"), rbUserDAOImpl.getString("usersTableName"), rbUserDAOImpl.getString("users_add_values"));
//		addAllPreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("add"), rbUserDAOImpl.getString("usersTableName"), rbUserDAOImpl.getString("users_add_init"));
		deletePreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("delete"), rbUserDAOImpl.getString("usersTableName"), rbUserDAOImpl.getString("users_delete_where"));
		updatePreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("update"), rbUserDAOImpl.getString("usersTableName"), rbUserDAOImpl.getString("users_update_set"), rbUserDAOImpl.getString("users_update_where"));
		getByIDPreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("getByID"), rbUserDAOImpl.getString("usersTableName"), rbUserDAOImpl.getString("users_getbyid_where"));
		getAllPreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("users_getall_select"), rbUserDAOImpl.getString("usersTableName"), rbUserDAOImpl.getString("users_getall_where"));
	}
	/* (non-Javadoc)
	 * @see by.it_academy.model.dao.AbstractDAO#create(java.util.List)
	 */
	@Override
	public void create(List<User> entity) throws SQLException {
		
		PreparedStatement psCreate;
		ResourceBundle rbSalt = ResourceBundle.getBundle("by.it_academy.model.sql_properties.sql_security");
		
		psCreate = this.connectionImpl.prepareStatement(createPreparedStatement);
		psCreate.executeUpdate();
		
		psCreate = this.connectionImpl.prepareStatement(addPreparedStatement);
		this.connectionImpl.setAutoCommit(false);
		for(User u:entity){
			ExtendedUser eu = (ExtendedUser) u;
			java.sql.Date date = new java.sql.Date(eu.getDate().getTime());
			psCreate.setInt(1,eu.getID());
			psCreate.setString(2,eu.getName());
			psCreate.setString(3,eu.getLastName());
			psCreate.setDate(4,date);
			psCreate.setInt(5,Integer.parseInt(eu.getMobile()));
			psCreate.setString(6,eu.getAddress());
			psCreate.setString(7,eu.getLogin());
			psCreate.setString(8,eu.getPassword());
			psCreate.setString(9,rbSalt.getString("pswrd_key"));
			psCreate.setInt(10,eu.getAccessType());
			
			psCreate.addBatch();
		}
		
		psCreate.executeUpdate();
		this.connectionImpl.setAutoCommit(true);
	}

	/* (non-Javadoc)
	 * @see by.it_academy.model.dao.AbstractDAO#add(by.it_academy.model.entity4dao.Entity)
	 */
	@Override
	public boolean add(User entity) {
		
		PreparedStatement psCreate;
		ResourceBundle rbSalt = ResourceBundle.getBundle("by.it_academy.model.sql_properties.sql_security");
		
		ExtendedUser eu = (ExtendedUser) entity;
		System.out.println(eu);
		System.out.println(eu.getDate().getTime());
		java.sql.Date date = new java.sql.Date(eu.getDate().getTime());
		
		try {
			psCreate = this.connectionImpl.prepareStatement(addPreparedStatement);
		
			psCreate.setInt(1,eu.getID());
			psCreate.setString(2,eu.getName());
			psCreate.setString(3,eu.getLastName());
			psCreate.setDate(4,date);
			psCreate.setInt(5,Integer.parseInt(eu.getMobile()));
			psCreate.setString(6,eu.getAddress());
			psCreate.setString(7,eu.getLogin());
			psCreate.setString(8,eu.getPassword());
			psCreate.setString(9,rbSalt.getString("pswrd_key"));
			psCreate.setInt(10,eu.getAccessType());
			
			psCreate.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("quary error");
			e.printStackTrace();
		}
		
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
