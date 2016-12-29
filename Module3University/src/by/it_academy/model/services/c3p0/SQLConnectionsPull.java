package by.it_academy.model.services.c3p0;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.locks.Lock;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author head4max
 *
 */
public class SQLConnectionsPull {

	private static SQLConnectionsPull datasource;
	private static Lock lock;

	private ComboPooledDataSource cpds;

	private SQLConnectionsPull() throws IOException, SQLException, PropertyVetoException {

		cpds = new ComboPooledDataSource();
		cpds.setDriverClass("com.mysql.jdbc.Driver");
		cpds.setJdbcUrl("jdbc:mysql://localhost/University");
		cpds.setUser("root");
		cpds.setPassword("1234");

		cpds.setMinPoolSize(5);
		cpds.setAcquireIncrement(5);
		cpds.setMaxPoolSize(20);
		cpds.setMaxStatements(180);
	}

	public static SQLConnectionsPull getInstance() throws IOException, SQLException, PropertyVetoException {

		lock.lock();
		
		if (datasource == null) {
			datasource = new SQLConnectionsPull();
		}
		
		lock.unlock();
		return datasource;
	}

	public Connection getConnection() throws SQLException {
		return this.cpds.getConnection();
	}
}
