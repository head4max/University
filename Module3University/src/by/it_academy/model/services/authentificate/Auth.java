package by.it_academy.model.services.authentificate;

/**
 * @author head4max
 *
 */
public class Auth {
	
	public static String auth(String login, String password) {
			
		Integer id = 0;
	
		return  (id == null)? "" : ((id > 0) ? id.toString() : (id == 0) ? "INSPECTOR" : "ADMIN");
	}
}
