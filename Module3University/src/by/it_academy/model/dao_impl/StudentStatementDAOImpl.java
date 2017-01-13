/**
 * 
 */
package by.it_academy.model.dao_impl;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import by.it_academy.model.dao.StudentStatementDAO;
import by.it_academy.model.entity4dao.StudentStatement;
import by.it_academy.model.services.c3p0.SQLConnectionsPull;
import by.it_academy.model.services.sql_utils.PreparedStatementFromBundle;

/**
 * class contain methods for work  with "StudentStatement" db 
 * @author head4max
 *
 */
public class StudentStatementDAOImpl implements StudentStatementDAO {

	private static String addPreparedStatement;
	private static String createPreparedStatement;
	private static String deletePreparedStatement;
//	private static String updatePreparedStatement;
//	private static String getByIDPreparedStatement;
//	private static String getAllPreparedStatement;
	
	static{
		
		createPreparedStatement = PreparedStatementFromBundle.getPreparedStatement("create","studentstatementTableName","studentstatement_table_create");
		addPreparedStatement = PreparedStatementFromBundle.getPreparedStatement("add","studentstatementTableName","studentstatement_add_values");
		deletePreparedStatement = PreparedStatementFromBundle.getPreparedStatement("delete","studentstatementTableName","studentstatement_delete_where");
//		updatePreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("update"), rbUserDAOImpl.getString("certificateTableName"), rbUserDAOImpl.getString("users_update_set"), rbUserDAOImpl.getString("users_update_where"));
//		getByIDPreparedStatement = PreparedStatementFromBundle.getPreparedStatement("getByID","studentstatement_getbyid","studentstatementTableName","studentstatement_getbyid_where");
//		getAllPreparedStatement = PreparedStatementFromBundle.getPreparedStatement("getAll","studentstatement_getAll","studentstatementTableName","objectName_getAll_where");
	}
	
	@Override
	public void create(List<StudentStatement> entity) {
		
		PreparedStatement psCreate = null;
		Connection con = null;
		
		try {
			con = SQLConnectionsPull.getInstance().getConnection();
			psCreate = con.prepareStatement(createPreparedStatement);
			System.out.println(createPreparedStatement);

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
		
		for(StudentStatement u:entity){
			this.add(u);
		}
	}

	@Override
	public boolean add(StudentStatement entity) {
		
		HashMap<String, StudentStatement.Request> hmStudentStatement = entity.getMap();
		Set<String> keys = hmStudentStatement.keySet();
		int count = 0;
		
        for (String key: keys) {
        	int response = 0;
        	switch(hmStudentStatement.get(key)){
        		case APPLY:
        			response = 1;
        			break;
        		case DENY:
        			response = 0;
        			break;
        		default:
        			response = 2;
        	}
            if(addFacultyRequest(entity.getID(), key.hashCode(), response)){
            	count++;
            }
        }
        
        return count > 0 ? true : false;
	}

	@Override
	public boolean addFacultyRequest(int userID, int facultyID, int response) {
		
		PreparedStatement psCreate = null;
		Connection con = null;
		int res = 0;

		try {
			con = SQLConnectionsPull.getInstance().getConnection();
			psCreate = con.prepareStatement(addPreparedStatement);
			System.out.println(addPreparedStatement);
			
			psCreate.setInt(1, userID);
			psCreate.setInt(2, facultyID);
			psCreate.setInt(3, response);
			
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
		return  res > 0 ? true : false;
	}

	@Override
	public StudentStatement getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentStatement> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
