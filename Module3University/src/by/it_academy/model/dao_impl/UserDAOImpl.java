package by.it_academy.model.dao_impl;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import by.it_academy.model.dao.UserDAO;
import by.it_academy.model.entity4dao.ExtendedUser;
import by.it_academy.model.entity4dao.User;
import by.it_academy.model.services.c3p0.SQLConnectionsPull;

/**
 * @author head4max
 *
 */
public class UserDAOImpl implements UserDAO {
	
//	static field represent prepared statement for UserDAO methods
//	private static String addAllPreparedStatement;
	protected static String addPreparedStatement;
	protected static String createPreparedStatement;
	protected static String deletePreparedStatement;
	protected static String updatePreparedStatement;
	protected static String getByIDPreparedStatement;
	protected static String getAllPreparedStatement;
	protected static String getUserByLoginPasswordPreparedStatement;
	
	static{
		ResourceBundle rbUserDAOImpl = ResourceBundle.getBundle("by.it_academy.model.sql_properties.sql_prepared_statement");
		
		createPreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("create"), rbUserDAOImpl.getString("usersTableName"), rbUserDAOImpl.getString("users_table_create"));
		addPreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("add"), rbUserDAOImpl.getString("usersTableName"), rbUserDAOImpl.getString("users_add_values"));
//		addAllPreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("add"), rbUserDAOImpl.getString("usersTableName"), rbUserDAOImpl.getString("users_add_init"));
		deletePreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("delete"), rbUserDAOImpl.getString("usersTableName"), rbUserDAOImpl.getString("users_delete_where"));
		updatePreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("update"), rbUserDAOImpl.getString("usersTableName"), rbUserDAOImpl.getString("users_update_set"), rbUserDAOImpl.getString("users_update_where"));
		getByIDPreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("getByID"), rbUserDAOImpl.getString("users_getbyid"), rbUserDAOImpl.getString("usersTableName"), rbUserDAOImpl.getString("users_getbyid_where"));
		getAllPreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("getAll"), rbUserDAOImpl.getString("users_getall_select"), rbUserDAOImpl.getString("usersTableName"), rbUserDAOImpl.getString("users_getall_where"));
		getUserByLoginPasswordPreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("getByID"), rbUserDAOImpl.getString("users_getbyloginpassword"), rbUserDAOImpl.getString("usersTableName"), rbUserDAOImpl.getString("users_getbyloginpassword_where"));
	}
	
	/**
	 * public void create(@{@link List}<{@link User}>)
	 * create table "users" and add USER from entity list into it
	 */
	@Override
	public void create(List<User> entity) throws SQLException {
		
		PreparedStatement psCreate;
		Connection con = null;
		
		try {
			con = SQLConnectionsPull.getInstance().getConnection();

			psCreate = con.prepareStatement(createPreparedStatement);
			psCreate.executeUpdate();
			psCreate.close();
		} catch (IOException e) {
		} catch (PropertyVetoException e) {
		}
		
		for(User u:entity){
			this.add(u);
		}
	}

	/**
	 * public boolean add({@link User})<br\>
	 * add user into "users" table
	 * @return true if user has been added, false - another way
	 */
	@Override
	public boolean add(User entity) {
		
		PreparedStatement psCreate;
		ResourceBundle rbSalt = ResourceBundle.getBundle("by.it_academy.model.sql_properties.sql_security");
		
		ExtendedUser eu = (ExtendedUser) entity;

		java.sql.Date date = new java.sql.Date(eu.getDate().getTime());
		
		try {
			psCreate = SQLConnectionsPull.getInstance().getConnection().prepareStatement(addPreparedStatement);
		
			psCreate.setInt(1, eu.getID());
			psCreate.setString(2, eu.getName());
			psCreate.setString(3, eu.getLastName());
			psCreate.setDate(4, date);
			psCreate.setInt(5, Integer.parseInt(eu.getMobile()));
			psCreate.setString(6, eu.getAddress());
			psCreate.setString(7, eu.getLogin());
			psCreate.setString(8, eu.getPassword());
			psCreate.setString(9, rbSalt.getString("pswrd_key"));
			psCreate.setInt(10, eu.getAccessType());
			
			int res = psCreate.executeUpdate();
			psCreate.close();
			return res == 1 ? true : false;
		} catch (SQLException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (PropertyVetoException e) {
			System.out.println(e);
		}
		return false;
	}

	/**
	 * public boolean delete(int)<br\>
	 * @return true if user by id has been deleted, false - another way
	 */
	@Override
	public boolean delete(int id) {

		PreparedStatement psCreate;
		
		try {
			psCreate = SQLConnectionsPull.getInstance().getConnection().prepareStatement(deletePreparedStatement);
		
			psCreate.setInt(1,id);
			psCreate.executeUpdate();
			psCreate.close();
			return true;
		} catch (SQLException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (PropertyVetoException e) {
			System.out.println(e);
		}
		return false;
	}

	/**
	 * public {@link User} getById(int)<br\>
	 * @return {@link User} equals id or null if {@link User} not found
	 */
	@Override
	public User getById(int id) {
		
		PreparedStatement psCreate;
		
		try {
			psCreate = SQLConnectionsPull.getInstance().getConnection().prepareStatement(getByIDPreparedStatement);
			System.out.println(getByIDPreparedStatement);
		
			psCreate.setInt(1,id);
			ResultSet rsUserById = psCreate.executeQuery();
			if(rsUserById.next()){
				String name = rsUserById.getString(1);
				String lastName = rsUserById.getString(2);
				Date birthDay = rsUserById.getDate(3);
				String address = rsUserById.getString(4);
				String mobile = rsUserById.getString(5);
				String login = rsUserById.getString(6);
				
				psCreate.close();
				return new User(login.hashCode(), name, lastName, birthDay, address, mobile);
			} else {
				psCreate.close();
				return null;
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (PropertyVetoException e) {
			System.out.println(e);
		}
		
		return null;
	}

	/**
	 * public @{@link List}<{@link User}> getAll()<br\>
	 * @return list of {@link User} with "student" access
	 */
	@Override
	public List<User> getAll() {
		
		PreparedStatement psCreate;
		
		try {
			psCreate = SQLConnectionsPull.getInstance().getConnection().prepareStatement(getAllPreparedStatement);
		
			ResultSet rsUserById = psCreate.executeQuery();
			List<User> userList= new ArrayList<User>();
			
			while(rsUserById.next()){
				String name = rsUserById.getString(1);
				String lastName = rsUserById.getString(2);
				Date birthDay = rsUserById.getDate(3);
				String address = rsUserById.getString(4);
				String mobile = rsUserById.getString(5);
				String login = rsUserById.getString(6);
				
				userList.add(new User(login.hashCode(), name, lastName, birthDay, address, mobile));
			}
			
			psCreate.close();
			return userList;
		} catch (SQLException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (PropertyVetoException e) {
			System.out.println(e);
		}
		
		return null;
	}

	/**
	 * public {@link User} getByLoginPassword({@link String}, {@link String})
	 */
	@Override
	public User getByLoginPassword(String login, String password) {

		PreparedStatement psCreate;
		ResourceBundle rbSalt = ResourceBundle.getBundle("by.it_academy.model.sql_properties.sql_security");
		
		try {
			psCreate = SQLConnectionsPull.getInstance().getConnection().prepareStatement(getUserByLoginPasswordPreparedStatement);
		
			psCreate.setString(1, login);
			psCreate.setString(2, password);
			psCreate.setString(3, rbSalt.getString("pswrd_key"));
			ResultSet rsUserById = psCreate.executeQuery();
			if(rsUserById.next()){
				
				ExtendedUser tempExtendedUser = new ExtendedUser(rsUserById.getString(1), rsUserById.getString(2), rsUserById.getDate(3), 
						rsUserById.getString(4), rsUserById.getString(5), rsUserById.getString(6), null, rsUserById.getInt(7));
				psCreate.close();
				return tempExtendedUser;
			} else {
				psCreate.close();
				return null;
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (PropertyVetoException e) {
			System.out.println(e);
		}
		
		return null;
	}

}
