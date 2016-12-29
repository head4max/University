package by.it_academy.model.entity4dao;

import java.util.Date;

/**
 * class-expert with information about user by {@link User#id}
 * @author head4max
 *
 */
public class User extends Entity {
	
	private static enum Access{ADMIN,STUDENT,COMISION};
	private String name;
	private String lastName;
	
	private Date birthDay;
	
	private Adress adress;
	
	private Mobile mobile;
	
	private Access eccessType;
	
	
	/**
	 * inner class for store telephone number
	 * @author head4max
	 *
	 */
	private class Mobile {
		private int prefix;
		private int operatorCode;
		private int mobileNumber;
		
		/**
		 * @param prefix
		 * @param operatorCode
		 * @param mobileNumber
		 */
		public Mobile(int prefix, int operatorCode, int mobileNumber) {
			this.prefix = prefix;
			this.operatorCode = operatorCode;
			this.mobileNumber = mobileNumber;
		}
		
		public Mobile(int operatorCode, int mobileNumber){
			this(375, operatorCode, mobileNumber);
		}
		
		public String getMobileNumbers(){
			return "+" + this.prefix + this.operatorCode + this.mobileNumber;
		}
	}
	
	
	/**
	 * inner class contain detailed info about address
	 * @author head4max
	 *
	 */
	private class Adress {
		
		private String country;
		private String city;
		private String street;
		private String houseNumber;
		
		/**
		 * @param country
		 * @param city
		 * @param street
		 * @param houseNumber
		 */
		public Adress(String country, String city, String street, String houseNumber) {
			
			this.country = country;
			this.city = city;
			this.street = street;
			this.houseNumber = houseNumber;
		}

		/**
		 * @return the country
		 */
		public String getCountry() {
			return country;
		}

		/**
		 * @return the city
		 */
		public String getCity() {
			return city;
		}

		/**
		 * @return the street
		 */
		public String getStreet() {
			return street;
		}

		/**
		 * @return the houseNumber
		 */
		public String getHouseNumber() {
			return houseNumber;
		}
	}

	/**
	 * @param name
	 * @param lastName
	 * @param mobile
	 * @param eccessType
	 */
	public User(int id, String name, String lastName, Adress adress, Mobile mobile, Access eccessType) {
		super(id);
		this.name = name;
		this.lastName = lastName;
		this.adress = adress;
		this.mobile = mobile;
		this.eccessType = eccessType;
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
	 * @return the eccessType
	 */
	public Access getEccessType() {
		return eccessType;
	}
	
	public Date getDate() {
		return this.birthDay;
	}
}
