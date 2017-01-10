package by.it_academy.model.services.c3p0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TemporaryConnection {
	
	private static Connection tempConnection;
	
	private TemporaryConnection(){
		
		try {
			Class.forName ("com.mysql.jdbc.Driver").newInstance();
			tempConnection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bsu_university", "root",
					"mysql4max");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		if(tempConnection == null){
			new TemporaryConnection();
		}
		
		return tempConnection;
	}
}
