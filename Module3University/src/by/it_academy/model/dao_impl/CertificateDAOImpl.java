package by.it_academy.model.dao_impl;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import by.it_academy.model.dao.CertificateDAO;
import by.it_academy.model.entity4dao.Certificate;
import by.it_academy.model.services.c3p0.SQLConnectionsPull;
import by.it_academy.model.services.sql_utils.PreparedStatementFromBundle;

/**
 * class contain methods for work with "Certificates" db 
 * @author head4max
 *
 */
public class CertificateDAOImpl implements CertificateDAO {

//	static field represent prepared statement for UserDAO methods
//	private static String addAllPreparedStatement;
	protected static String addPreparedStatement;
	protected static String createPreparedStatement;
	protected static String deletePreparedStatement;
//	protected static String updatePreparedStatement;
	protected static String getByIDPreparedStatement;
	protected static String getAllPreparedStatement;
	protected static String getFacultySumMarkPreparedStatement;
	
	static{
		ResourceBundle rbUserDAOImpl = ResourceBundle.getBundle("by.it_academy.model.sql_properties.sql_prepared_statement");
		
		createPreparedStatement = PreparedStatementFromBundle.getPreparedStatement("create","certificateTableName","certificate_table_create");
		addPreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("add"), rbUserDAOImpl.getString("certificateTableName"), rbUserDAOImpl.getString("certificate_add_values"));
//		addAllPreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("add"), rbUserDAOImpl.getString("usersTableName"), rbUserDAOImpl.getString("users_add_init"));
		deletePreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("delete"), rbUserDAOImpl.getString("certificateTableName"), rbUserDAOImpl.getString("certificate_delete_where"));
//		updatePreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("update"), rbUserDAOImpl.getString("certificateTableName"), rbUserDAOImpl.getString("users_update_set"), rbUserDAOImpl.getString("users_update_where"));
		getByIDPreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("getByID_join"), rbUserDAOImpl.getString("certificate_getById_join_select"), rbUserDAOImpl.getString("certificate_getById_join_table1"), rbUserDAOImpl.getString("certificate_getById_join_table2"), rbUserDAOImpl.getString("certificate_getById_join_using"));
		getAllPreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("getAll"), rbUserDAOImpl.getString("users_getall_select"), rbUserDAOImpl.getString("certificateTableName"), rbUserDAOImpl.getString("users_getall_where"));
		getFacultySumMarkPreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("getByID"), rbUserDAOImpl.getString("certificate_getFacultySumMarkByID_select"), rbUserDAOImpl.getString("certificate_getFacultySumMarkByID_table"), rbUserDAOImpl.getString("certificate_getFacultySumMarkByID_where"));
	}
	
	/* (non-Javadoc)
	 * @see by.it_academy.model.dao.AbstractDAO#create(java.util.List)
	 */
	@Override
	public void create(List<Certificate> entity) {
		
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
		
		for(Certificate u:entity){
			this.add(u);
		}

	}

	/* (non-Javadoc)
	 * @see by.it_academy.model.dao.AbstractDAO#add(by.it_academy.model.entity4dao.Entity)
	 */
	@Override
	public boolean add(Certificate entity) {
		
		HashMap<String, Integer> hmCertificate = entity.getMap();
		Set<String> keys = hmCertificate.keySet();
		int count = 0;
		
        for (String key: keys) {
            if(addMark(entity.getID(), key.hashCode(), hmCertificate.get(key))){
            	count++;
            }
        }
        
        return count > 0 ? true : false;
	}
	
	@Override
	public boolean addMark(int id, int objectID, int mark) {
		
		PreparedStatement psCreate = null;
		Connection con = null;
		int res = 0;

		try {
			con = SQLConnectionsPull.getInstance().getConnection();
			psCreate = con.prepareStatement(addPreparedStatement);
			
			psCreate.setInt(1, id);
			psCreate.setInt(2, objectID);
			psCreate.setInt(3, mark);
			
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

	/* (non-Javadoc)
	 * @see by.it_academy.model.dao.AbstractDAO#delete(int)
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
		return  res > 0 ? true : false;
	}

	/* (non-Javadoc)
	 * @see by.it_academy.model.dao.AbstractDAO#getById(int)
	 */
	@Override
	public Certificate getById(int id) {
		
		PreparedStatement psCreate = null;
		Connection con = null;
		Certificate certif = null;
		
		try {
			con = SQLConnectionsPull.getInstance().getConnection();
			psCreate = con.prepareStatement(getByIDPreparedStatement);
		
			psCreate.setInt(1,id);
			ResultSet rsCertificateById = psCreate.executeQuery();
			
			certif = new Certificate(id);
			
			while(rsCertificateById.next()){
				String objectName = rsCertificateById.getString(1);
				int mark = rsCertificateById.getInt(2);
				certif.addMark(objectName, mark);
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
		
		if(certif.getMap().size() > 0){
			return certif;
		} else {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see by.it_academy.model.dao.AbstractDAO#getAll()
	 */
	@Override
	public List<Certificate> getAll() {
		return null;
	}

	@Override
	public int getFacultySumMark(int id) {
		
		PreparedStatement psCreate = null;
		Connection con = null;
		int mark = 0;
		
		try {
			con = SQLConnectionsPull.getInstance().getConnection();
			psCreate = con.prepareStatement(getByIDPreparedStatement);
		
			psCreate.setInt(1,id);
			ResultSet rsSumMark = psCreate.executeQuery();
			mark = rsSumMark.getInt(1);
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
		
		if(mark > 0){
			return mark;
		} else {
			return 0;
		}
	}

	@Override
	public int getAverageMark(int id) {
		return 0;
	}

}
