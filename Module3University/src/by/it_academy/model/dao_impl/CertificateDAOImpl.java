package by.it_academy.model.dao_impl;

import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;

import by.it_academy.model.dao.CertificateDAO;
import by.it_academy.model.entity4dao.Certificate;

/**
 * @author head4max
 *
 */
public class CertificateDAOImpl extends DAOImplConnection implements CertificateDAO {

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
		
		createPreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("create"), rbUserDAOImpl.getString("certificateTableName"), rbUserDAOImpl.getString("users_table_create"));
		addPreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("add"), rbUserDAOImpl.getString("usersTableName"), rbUserDAOImpl.getString("users_add_values"));
//		addAllPreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("add"), rbUserDAOImpl.getString("usersTableName"), rbUserDAOImpl.getString("users_add_init"));
		deletePreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("delete"), rbUserDAOImpl.getString("usersTableName"), rbUserDAOImpl.getString("users_delete_where"));
		updatePreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("update"), rbUserDAOImpl.getString("usersTableName"), rbUserDAOImpl.getString("users_update_set"), rbUserDAOImpl.getString("users_update_where"));
		getByIDPreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("getByID"), rbUserDAOImpl.getString("users_getbyid"), rbUserDAOImpl.getString("usersTableName"), rbUserDAOImpl.getString("users_getbyid_where"));
		getAllPreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("getAll"), rbUserDAOImpl.getString("users_getall_select"), rbUserDAOImpl.getString("usersTableName"), rbUserDAOImpl.getString("users_getall_where"));
		getUserByLoginPasswordPreparedStatement = MessageFormat.format(rbUserDAOImpl.getString("getByID"), rbUserDAOImpl.getString("users_getbyloginpassword"), rbUserDAOImpl.getString("usersTableName"), rbUserDAOImpl.getString("users_getbyloginpassword_where"));
	}
	
	/* (non-Javadoc)
	 * @see by.it_academy.model.dao.AbstractDAO#create(java.util.List)
	 */
	@Override
	public void create(List<Certificate> entity) {
		
		

	}

	/* (non-Javadoc)
	 * @see by.it_academy.model.dao.AbstractDAO#add(by.it_academy.model.entity4dao.Entity)
	 */
	@Override
	public boolean add(Certificate entity) {
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
	public Certificate getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see by.it_academy.model.dao.AbstractDAO#getAll()
	 */
	@Override
	public List<Certificate> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFacultySumMark(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAverageMark(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
