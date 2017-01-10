package by.it_academy.model.services.c3p0;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.concurrent.locks.Lock;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author head4max
 *
 */
public class SQLConnectionsPull {

	private static SQLConnectionsPull datasource = null;
//	private static Lock lock;

	private ComboPooledDataSource cpds = null;
	
	static{
//		lock.unlock();
	}
	
	private SQLConnectionsPull() throws IOException, SQLException, PropertyVetoException {

		ResourceBundle rbSQLConnectionsPull = ResourceBundle.getBundle("by.it_academy.model.sql_properties.sql_connection");
		
		System.out.println(MessageFormat.format(rbSQLConnectionsPull.getString("sqldriver"), rbSQLConnectionsPull.getString("current_sql")));
		System.out.println(MessageFormat.format(rbSQLConnectionsPull.getString("sqldb"), rbSQLConnectionsPull.getString("current_sql"), rbSQLConnectionsPull.getString("sql_ip")));
		System.out.println(rbSQLConnectionsPull.getString("login"));
		System.out.println(rbSQLConnectionsPull.getString("password"));
		
		cpds = new ComboPooledDataSource();
		
		System.out.println(cpds);
		
		cpds.setDriverClass(MessageFormat.format(rbSQLConnectionsPull.getString("sqldriver"), rbSQLConnectionsPull.getString("current_sql")));
		cpds.setJdbcUrl(MessageFormat.format(rbSQLConnectionsPull.getString("sqldb"), rbSQLConnectionsPull.getString("current_sql"), rbSQLConnectionsPull.getString("sql_ip")));
		cpds.setUser(rbSQLConnectionsPull.getString("login"));
		cpds.setPassword(rbSQLConnectionsPull.getString("password"));
		
		System.out.println(cpds);

		cpds.setMinPoolSize(5);
		cpds.setAcquireIncrement(5);
		cpds.setMaxPoolSize(20);
		cpds.setMaxStatements(180);
	}

	public static SQLConnectionsPull getInstance() throws IOException, SQLException, PropertyVetoException {

//		lock.lock();
		
		if (datasource == null) {
			datasource = new SQLConnectionsPull();
		}
		
//		lock.unlock();
		return datasource;
	}

	public Connection getConnection() throws SQLException {
		return this.cpds.getConnection();
	}
}
