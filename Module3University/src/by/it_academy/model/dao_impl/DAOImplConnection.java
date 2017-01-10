package by.it_academy.model.dao_impl;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import by.it_academy.model.services.c3p0.SQLConnectionsPull;
import by.it_academy.model.services.c3p0.TemporaryConnection;

/**
 * @author head4max
 *
 */
class DAOImplConnection {

	protected static String addPreparedStatement;
	protected static String createPreparedStatement;
	protected static String deletePreparedStatement;
	protected static String updatePreparedStatement;
	protected static String getByIDPreparedStatement;
	protected static String getAllPreparedStatement;
	
	protected Connection connectionImpl;

	/**
	 * @param connectionImpl
	 */
	public DAOImplConnection() {
		/*try {
			this.connectionImpl = SQLConnectionsPull.getInstance().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}*/
		
		connectionImpl = TemporaryConnection.getConnection();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		
		if(this.connectionImpl != null){
			this.connectionImpl.close();
		}
	}
	
	
}
