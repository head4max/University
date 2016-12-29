package by.it_academy.model.entity4dao;

import java.util.HashMap;

/**
 * class-expert contains final school marks
 * @author head4max
 *
 */
public class Certificate extends Entity {

	/**
	 * table contains couple "object's name", "mark" 
	 */
	private HashMap<String, Integer> Marks;
	
	/**
	 * constructor class
	 * @param id - {@link User#id}
	 */
	public Certificate(int id){
		super(id);
		
		this.Marks = new HashMap<String, Integer>();
	}
	
	
	/**
	 * add mark of an object in {@link #Marks}
	 * @param objectName - name of an object
	 * @param mark - mark of an object
	 */
	public void addMark(String objectName, int mark) {
		this.Marks.put(objectName, mark);
	}
	
	/**
	 * 
	 * @param objectName
	 * @return mark by objectName from {@link #Marks} table
	 */
	public int getMark(String objectName) {
		return this.Marks.get(objectName);
	}
}
