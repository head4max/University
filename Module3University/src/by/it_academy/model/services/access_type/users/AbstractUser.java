package by.it_academy.model.services.access_type.users;

import java.sql.Connection;

/**
 * @author head4max
 *
 */
public abstract class AbstractUser {
	
	public static enum AccessType{STUDENT,ADMIN,INSPECTOR};
	
	protected Connection userConnection;
	protected AccessType userAccessType;
	
	abstract void showPage();
	
	public AccessType getAccessType() {
		return this.userAccessType;
	}
}
