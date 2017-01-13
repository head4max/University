package by.it_academy.model.dao_impl;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.it_academy.model.dao.FacultiesDAO;
import by.it_academy.model.entity4dao.Faculty;
import by.it_academy.model.services.c3p0.SQLConnectionsPull;
import by.it_academy.model.services.sql_utils.PreparedStatementFromBundle;

/**
 * class contain methods for work  with "Faculties" db 
 * @author head4max
 *
 */
public class FacultiesDAOImpl implements FacultiesDAO {

	protected static String addPreparedStatement;
	protected static String createPreparedStatement;
	protected static String deletePreparedStatement;
//	protected static String updatePreparedStatement;
	protected static String getByIDPreparedStatement;
	protected static String getAllPreparedStatement;
	protected static String getFacultySumMarkPreparedStatement;
	
	static{
		
		createPreparedStatement = PreparedStatementFromBundle.getPreparedStatement("create","facultyTableName","faculty_table_create");
		addPreparedStatement = PreparedStatementFromBundle.getPreparedStatement("add","facultyTableName","faculty_add_values");
		deletePreparedStatement = PreparedStatementFromBundle.getPreparedStatement("delete","facultyTableName","faculty_delete_where");
//		updatePreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("update"), rbUserDAOImpl.getString("certificateTableName"), rbUserDAOImpl.getString("users_update_set"), rbUserDAOImpl.getString("users_update_where"));
		getByIDPreparedStatement = PreparedStatementFromBundle.getPreparedStatement("getByID","faculty_getByID","facultyTableName","faculty_getByID_where");
		getAllPreparedStatement = PreparedStatementFromBundle.getPreparedStatement("getAll","faculty_getAll","facultyTableName","objectName_getAll_where");
	}
	@Override
	public void create(List<Faculty> entity) {
		
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
		
		for(Faculty u:entity){
			this.add(u);
		}

	}

	@Override
	public boolean add(Faculty entity) {
		
		PreparedStatement psCreate = null;
		Connection con = null;
		int res = 0;

		try {
			con = SQLConnectionsPull.getInstance().getConnection();
			psCreate = con.prepareStatement(addPreparedStatement);
			System.out.println(addPreparedStatement);
			
			psCreate.setInt(1, entity.getFacultyName().hashCode());
			psCreate.setString(2, entity.getFacultyName());
			psCreate.setInt(3, entity.getFirstExamObjects().hashCode());
			psCreate.setInt(4, entity.getSecondExamObjects().hashCode());
			psCreate.setInt(5, entity.getThirdExamObjects().hashCode());
			
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
	public Faculty getById(int id) {
		
		PreparedStatement psCreate = null;
		Connection con = null;
		Faculty fac = null;
		System.out.println(getByIDPreparedStatement);
		
		try {
			con = SQLConnectionsPull.getInstance().getConnection();
			psCreate = con.prepareStatement(getByIDPreparedStatement);
		
			psCreate.setInt(1,id);
			ResultSet rsFacultyById = psCreate.executeQuery();
			
			if(rsFacultyById.next()){
				ObjectNameDAOImpl ondaoi = new ObjectNameDAOImpl();

				fac = new Faculty(rsFacultyById.getString(1),ondaoi.getById(rsFacultyById.getInt(2)).getObjectName(),ondaoi.getById(rsFacultyById.getInt(3)).getObjectName(),ondaoi.getById(rsFacultyById.getInt(4)).getObjectName());
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
		
		return fac;
	}

	@Override
	public List<Faculty> getAll() {
		
		PreparedStatement psCreate = null;
		Connection con = null;
		List<Faculty> userList= new ArrayList<Faculty>();
		Faculty fac = null;
		
		try {
			con = SQLConnectionsPull.getInstance().getConnection();
			psCreate = con.prepareStatement(getAllPreparedStatement);
			System.out.println(getAllPreparedStatement);
		
			ResultSet rsFacultyById = psCreate.executeQuery();
			
			while(rsFacultyById.next()){
				ObjectNameDAOImpl ondaoi = new ObjectNameDAOImpl();

				fac = new Faculty(rsFacultyById.getString(1),ondaoi.getById(rsFacultyById.getInt(2)).getObjectName(),ondaoi.getById(rsFacultyById.getInt(3)).getObjectName(),ondaoi.getById(rsFacultyById.getInt(4)).getObjectName());
				
				if(fac != null){
					userList.add(fac);
				}
				
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

}
