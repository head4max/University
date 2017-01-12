package by.it_academy.model.entity4dao;

import java.util.HashMap;
import java.util.Set;

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
	 * public static {@link Certificate} getInstance({@link String})
	 * @param bundle
	 * @return
	 */
	public static Certificate getInstance(String bundle){
		String[] strUser= bundle.split(" ");
		Certificate certificate = new Certificate(Integer.parseInt(strUser[0]));

		for(String strCouple:strUser[1].split(",")){
			String[] strMark = strCouple.split("-");
			certificate.addMark(strMark[0], Integer.parseInt(strMark[1]));
		}
		return certificate;
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
	
	public int getID(){
		return this.id;
	}
	
	public HashMap<String, Integer> getMap(){
		return Marks;
	}
	
	@Override
	public String toString(){
		String toString = "";
		
		toString += this.getID();
		toString += " : ";
		
		HashMap<String, Integer> hmCertificate = this.getMap();
		Set<String> keys = hmCertificate.keySet();
		
        for (String key: keys) {
        	toString += "[" + key + "-" + hmCertificate.get(key) + "]";
        }
		return toString;
	}
}
