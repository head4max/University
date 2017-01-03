package by.it_academy.model.services.sql_utils;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import by.it_academy.model.services.c3p0.SQLConnectionsPull;

/**
 * @author head4max
 *
 */
public abstract class Authorizing {
	
	public static Connection auth(String login, String password) {
		
		Connection tryConnection = null;
		try {
			tryConnection = SQLConnectionsPull.getInstance().getConnection();
		} catch (SQLException | IOException | PropertyVetoException e) {
			e.printStackTrace();
		}
		
		return tryConnection;
	}
}
