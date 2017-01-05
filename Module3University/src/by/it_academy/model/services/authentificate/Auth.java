package by.it_academy.model.services.authentificate;

import by.it_academy.model.dao_impl.UserDAOImpl;

/**
 * @author head4max
 *
 */
public class Auth {
	
	public static String auth(String login, String password) {
			
		Integer id = new UserDAOImpl().getID(login, password);
	
		return  (id == null)? "" : ((id > 0) ? id.toString() : (id == 0) ? "INSPECTOR" : "ADMIN");
	}
}
