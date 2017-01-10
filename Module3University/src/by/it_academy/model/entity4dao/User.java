package by.it_academy.model.entity4dao;

import java.util.Date;

/**
 * class-expert with information about user by {@link User#id}
 * @author head4max
 *
 */
public class User extends Entity {
	
	private String name;
	private String lastName;
	
	private Date birthDay;
	
	private String address;
	
	private String mobile;
	
	/**
	 * @param name
	 * @param lastName
	 * @param mobile
	 * @param eccessType
	 */
	public User(int id, String name, String lastName, Date birthDay, String address, String mobile) {
		super(id);
		this.name = name;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.address = address;
		this.mobile = mobile;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @return the birthDay
	 */
	public Date getDate() {
		return this.birthDay;
	}
	
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [" + (lastName != null ? "lastName=" + lastName + ", " : "")
				+ (name != null ? "name=" + name + ", " : "") + (birthDay != null ? "birthDay=" + birthDay + ", " : "")
				+ (address != null ? "address=" + address + ", " : "") + (mobile != null ? "mobile=" + mobile : "")
				+ "]";
	}
	
}
