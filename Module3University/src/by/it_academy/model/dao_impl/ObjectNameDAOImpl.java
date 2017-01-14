package by.it_academy.model.dao_impl;

import by.it_academy.model.entity4dao.ObjectNameInfo;
import by.it_academy.model.services.c3p0.SQLConnectionsPull;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import by.it_academy.model.dao.ObjectNameDAO;

/**
 * class contain methods for work  with "Objects" db 
 * @author head4max
 *
 */
public class ObjectNameDAOImpl implements ObjectNameDAO{

	protected static String addPreparedStatement;
	protected static String createPreparedStatement;
	protected static String deletePreparedStatement;
	protected static String updatePreparedStatement;
	protected static String getByIDPreparedStatement;
	protected static String getAllPreparedStatement;
	
	static{
		ResourceBundle rbUserDAOImpl = ResourceBundle.getBundle("by.it_academy.model.sql_properties.sql_prepared_statement");
		
		createPreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("create"), rbUserDAOImpl.getString("objectNameTableName"), rbUserDAOImpl.getString("objectName_table_create"));
		addPreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("add"), rbUserDAOImpl.getString("objectNameTableName"), rbUserDAOImpl.getString("objectName_add_values"));
		deletePreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("delete"), rbUserDAOImpl.getString("objectNameTableName"), rbUserDAOImpl.getString("objectName_delete_where"));
		updatePreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("update"), rbUserDAOImpl.getString("objectNameTableName"), rbUserDAOImpl.getString("users_update_set"), rbUserDAOImpl.getString("users_update_where"));
		getByIDPreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("getByID"), rbUserDAOImpl.getString("objectName_getByID"), rbUserDAOImpl.getString("objectNameTableName"), rbUserDAOImpl.getString("objectName_getByID_where"));
		getAllPreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("getAll"), rbUserDAOImpl.getString("objectName_getAll_select"), rbUserDAOImpl.getString("objectNameTableName"), "");
	}
	
	/**
	 * create "objects" table and add object from list
	 */
	@Override
	public void create(List<ObjectNameInfo> entity) {
		
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
		
		for(ObjectNameInfo u:entity){
			this.add(u);
		}
		
	}

	/**
	 * public boolean add({@link ObjectNameInfo})<br/>
	 * @return true if add successful
	 */
	@Override
	public boolean add(ObjectNameInfo entity) {
		
		PreparedStatement psCreate = null;
		Connection con = null;
		int res = 0;

		try {
			con = SQLConnectionsPull.getInstance().getConnection();
			psCreate = con.prepareStatement(addPreparedStatement);
		
			psCreate.setInt(1, entity.getObjectName().hashCode());
			psCreate.setString(2, entity.getObjectName());
			
			res = psCreate.executeUpdate();
		} catch (SQLException e) {
		} catch (IOException e) {
		} catch (PropertyVetoException e) {
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
	 * public boolean delete(int)<br/>
	 * @return true if delete was successful
	 */
	@Override
	public boolean delete(int string) {
		
		PreparedStatement psCreate = null;
		Connection con = null;
		int res = 0;
		
		try {
			con = SQLConnectionsPull.getInstance().getConnection();
			psCreate = con.prepareStatement(deletePreparedStatement);
		
			psCreate.setInt(1,string);
			res = psCreate.executeUpdate();
		} catch (SQLException e) {
		} catch (IOException e) {
		} catch (PropertyVetoException e) {
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
	 * public {@link ObjectNameInfo} getById(int id)<br/>
	 * get name of the object by id
	 * @return {@link ObjectNameInfo}
	 */
	@Override
	public ObjectNameInfo getById(int id) {
		
		PreparedStatement psCreate = null;
		Connection con = null;
		ObjectNameInfo oni = null;
		
		try {
			con = SQLConnectionsPull.getInstance().getConnection();
			psCreate = con.prepareStatement(getByIDPreparedStatement);
		
			psCreate.setInt(1,id);
			ResultSet rsUserById = psCreate.executeQuery();
			if(rsUserById.next()){
				String name = rsUserById.getString(1);		
				oni = new ObjectNameInfo(name);
			}
		} catch (SQLException e) {
		} catch (IOException e) {
		} catch (PropertyVetoException e) {
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
		
		return oni;
	}

	/**
	 * public List<ObjectNameInfo> getAll()
	 * get list of th couple name and id of the object
	 * @return List<ObjectNameInfo>
	 */
	@Override
	public List<ObjectNameInfo> getAll() {
		
		PreparedStatement psCreate = null;
		Connection con = null;
		List<ObjectNameInfo> userList= new ArrayList<ObjectNameInfo>();
		
		try {
			con = SQLConnectionsPull.getInstance().getConnection();
			psCreate = con.prepareStatement(getAllPreparedStatement);
		
			ResultSet rsUserById = psCreate.executeQuery();
			
			while(rsUserById.next()){
				String name = rsUserById.getString(1);
				
				userList.add(new ObjectNameInfo(name));
			}
		} catch (SQLException e) {
		} catch (IOException e) {
		} catch (PropertyVetoException e) {
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
	 * public boolean deleteByName(String)
	 * delete object by name
	 * @return true if delete was successful
	 */
	@Override
	public boolean deleteByName(String object) {

		return delete(object.hashCode());
	}

}
