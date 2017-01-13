package by.it_academy.model.entity4dao;

import java.util.Date;

/**
 * class-expert extended User class login,password ant access type field
 * @author head4max
 *
 */
public class ExtendedUser extends User {
	
	private String login;
	private String password;
	private int accessType;
	/**
	 * @param id
	 * @param name
	 * @param lastName
	 * @param address
	 * @param mobile
	 * @param login
	 * @param password
	 * @param accessType
	 */
	public ExtendedUser(String name, String lastName, Date birthDay, String address, String mobile, String login,
			String password, int accessType) {
		
		super(login.hashCode(), name, lastName, birthDay, address, mobile);
		this.login = login;
		this.password = password;
		this.accessType = accessType;
	}
	
	public static ExtendedUser getInstance(String name, String lastName, Date birthDay, String address, String mobile, String login,
			String password, int accessType){

		if(name.matches("[A-ZА-ЯЁa-zа-яё]*") && lastName.matches("[A-ZА-ЯЁa-zа-яё]*") && mobile.matches("[0-9]{7}") && login.matches("[A-Za-z0-9]*[@][a-z]*[.][a-z]{2,3}") &&
				accessType > 0){
			return new ExtendedUser(name, lastName, birthDay, address, mobile, login, password, accessType);
		}else{
			return null;
		}
	}
	
	public static ExtendedUser getInstanceFromString(String bundle){
		String[] strUser= bundle.split(" ");
		
		if(strUser.length == 8){
			return ExtendedUser.getInstance(strUser[0], strUser[1], new java.util.Date(Long.parseLong(strUser[2])), strUser[3], strUser[4], strUser[5], strUser[6], Integer.parseInt(strUser[7]));
		}else {
			return null;
		}
	}
	
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @return the accessType
	 */
	public int getAccessType() {
		return accessType;
	}
	
	/**
	 * @return the id
	 */
	public int getID(){
		return this.id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ExtendedUser [" + "id=" + id + ", " + (login != null ? "login=" + login + ", " : "")
				+ (password != null ? "password=" + password + ", " : "") + "accessType=" + accessType + ", "
				+ (super.toString() != null ? "toString()=" + super.toString() : "") + "]";
	}
	
	
}
