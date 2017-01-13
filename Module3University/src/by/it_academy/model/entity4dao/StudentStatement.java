package by.it_academy.model.entity4dao;

import java.util.HashMap;

/**
 * class-expert contains {@link StudentStatement#income} table by {@link User#id}
 * @author head4max
 */
public class StudentStatement extends Entity {
	
	public static enum Request{APPLY,DENY,INPROCCESS};
	
	/**
	 * table of wishful faculties with appropriate boolean type university's design
	 */
	private HashMap<String, Request> income;
	
	/**
	 * @param id - student ID whose appropriate {@link StudentStatement#income}
	 */
	public StudentStatement(int id){
		super(id);
		
		this.income = new HashMap<String, Request>();
	}
	
	/**
	 * @param facultyName - key of {@link StudentStatement#income} table
	 * @param hasInvited - value of {@link StudentStatement#income} table
	 */
	public void addFaculty(String facultyName, Request hasInvited) {
		this.income.put(facultyName, hasInvited);
	}
	
	
	/**
	 * @param facultyName - key of {@link StudentStatement#income} table
	 * @return value of {@link StudentStatement#income} table
	 */
	public Request getDesign(String facultyName) {
		return this.income.get(facultyName);
	}
	
	public HashMap<String, Request> getMap(){
		return this.income;
	}
	
	public int getID(){
		return this.id;
	}
}
