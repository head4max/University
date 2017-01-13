package by.it_academy.model.services.sql_utils;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class PreparedStatementFromBundle {
	private static ResourceBundle sqlRB = ResourceBundle.getBundle("by.it_academy.model.sql_properties.sql_prepared_statement");

	public static String getPreparedStatement(String quiry, String...param){
		
		switch(param.length){
			case 0:
				return MessageFormat.format(sqlRB.getString(quiry),"");
			case 1:
				return MessageFormat.format(sqlRB.getString(quiry),sqlRB.getString(param[0]));
			case 2:
				return MessageFormat.format(sqlRB.getString(quiry),sqlRB.getString(param[0]),sqlRB.getString(param[1]));
			case 3:
				return MessageFormat.format(sqlRB.getString(quiry),sqlRB.getString(param[0]),sqlRB.getString(param[1]),sqlRB.getString(param[2]));
			default:
				return MessageFormat.format(sqlRB.getString(quiry),sqlRB.getString(param[0]),sqlRB.getString(param[1]),sqlRB.getString(param[2]),sqlRB.getString(param[3]));
		}
	}
}
