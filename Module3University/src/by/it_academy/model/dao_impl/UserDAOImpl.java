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
	public void create(List<User> entity){
		
		PreparedStatement psCreate = null;
		Connection con = null;
		
		try {
			con = SQLConnectionsPull.getInstance().getConnection();

			psCreate = con.prepareStatement(createPreparedStatement);
			psCreate.executeUpdate();
		} catch (IOException e) {
		} catch (PropertyVetoException e) {
		} catch (SQLException e) {
		} finally {
			if(psCreate != null){
				try {
					psCreate.close();
				} catch (SQLException e) {
				}
			}
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
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
		
		PreparedStatement psCreate = null;
		Connection con = null;
		int res = 0;
		ResourceBundle rbSalt = ResourceBundle.getBundle("by.it_academy.model.sql_properties.sql_security");
		
		ExtendedUser eu = (ExtendedUser) entity;

		java.sql.Date date = new java.sql.Date(eu.getDate().getTime());
		
		try {
			con = SQLConnectionsPull.getInstance().getConnection();
			psCreate = con.prepareStatement(addPreparedStatement);
		
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
			
			res = psCreate.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (PropertyVetoException e) {
			System.out.println(e);
		} finally {
			if(psCreate != null){
				try {
					psCreate.close();
				} catch (SQLException e) {
				}
			}
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}
		
		return res == 1 ? true : false;
	}

	/**
	 * public boolean delete(int)<br\>
	 * @return true if user by id has been deleted, false - another way
	 */
	@Override
	public boolean delete(int id) {

		PreparedStatement psCreate = null;
		Connection con = null;
		int res = 0;
		
		try {
			con = SQLConnectionsPull.getInstance().getConnection();
			psCreate = con.prepareStatement(deletePreparedStatement);
		
			psCreate.setInt(1,id);
			res = psCreate.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (PropertyVetoException e) {
			System.out.println(e);
		} finally {
			if(psCreate != null){
				try {
					psCreate.close();
				} catch (SQLException e) {
				}
			}
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}
		
		return  res == 1 ? true : false;
	}

	/**
	 * public {@link User} getById(int)<br\>
	 * @return {@link User} equals id or null if {@link User} not found
	 */
	@Override
	public User getById(int id) {
		
		PreparedStatement psCreate = null;
		Connection con = null;
		User tempUser = null;
		
		try {
			con = SQLConnectionsPull.getInstance().getConnection();
			psCreate = con.prepareStatement(getByIDPreparedStatement);
		
			psCreate.setInt(1,id);
			ResultSet rsUserById = psCreate.executeQuery();
			if(rsUserById.next()){
				String name = rsUserById.getString(1);
				String lastName = rsUserById.getString(2);
				Date birthDay = rsUserById.getDate(3);
				String address = rsUserById.getString(4);
				String mobile = rsUserById.getString(5);
				String login = rsUserById.getString(6);
				
				tempUser = new User(login.hashCode(), name, lastName, birthDay, address, mobile);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (PropertyVetoException e) {
			System.out.println(e);
		} finally {
			if(psCreate != null){
				try {
					psCreate.close();
				} catch (SQLException e) {
				}
			}
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}
		
		return tempUser;
	}

	/**
	 * public @{@link List}<{@link User}> getAll()<br\>
	 * @return list of {@link User} with "student" access
	 */
	@Override
	public List<User> getAll() {
		
		PreparedStatement psCreate = null;
		Connection con = null;
		List<User> userList= new ArrayList<User>();
		
		try {
			con = SQLConnectionsPull.getInstance().getConnection();
			psCreate = con.prepareStatement(getAllPreparedStatement);
		
			ResultSet rsUserById = psCreate.executeQuery();
			
			
			while(rsUserById.next()){
				String name = rsUserById.getString(1);
				String lastName = rsUserById.getString(2);
				Date birthDay = rsUserById.getDate(3);
				String address = rsUserById.getString(4);
				String mobile = rsUserById.getString(5);
				String login = rsUserById.getString(6);
				
				userList.add(new User(login.hashCode(), name, lastName, birthDay, address, mobile));
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (PropertyVetoException e) {
			System.out.println(e);
		} finally {
			if(psCreate != null){
				try {
					psCreate.close();
				} catch (SQLException e) {
				}
			}
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}
		if(userList.size() > 0){
			return userList;
		} else {
			return null;
		}
	}

	/**
	 * public {@link User} getByLoginPassword({@link String}, {@link String})
	 */
	@Override
	public User getByLoginPassword(String login, String password) {

		PreparedStatement psCreate = null;
		Connection con = null;
		ExtendedUser tempExtendedUser = null;
		ResourceBundle rbSalt = ResourceBundle.getBundle("by.it_academy.model.sql_properties.sql_security");
		
		try {
			con = SQLConnectionsPull.getInstance().getConnection();
			psCreate = con.prepareStatement(getUserByLoginPasswordPreparedStatement);
		
			psCreate.setString(1, login);
			psCreate.setString(2, password);
			psCreate.setString(3, rbSalt.getString("pswrd_key"));
			ResultSet rsUserById = psCreate.executeQuery();
			if(rsUserById.next()){
				tempExtendedUser = new ExtendedUser(rsUserById.getString(1), rsUserById.getString(2), rsUserById.getDate(3), 
						rsUserById.getString(4), rsUserById.getString(5), rsUserById.getString(6), null, rsUserById.getInt(7));
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (PropertyVetoException e) {
			System.out.println(e);
		} finally {
			if(psCreate != null){
				try {
					psCreate.close();
				} catch (SQLException e) {
				}
			}
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}
		
		return tempExtendedUser;
	}

}
