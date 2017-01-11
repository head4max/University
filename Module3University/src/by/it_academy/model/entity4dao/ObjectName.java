package by.it_academy.model.entity4dao;

public class ObjectName extends Entity {
	
	private String objectName;
	
	public ObjectName(String objectName){
		this(objectName.hashCode());
		this.objectName = objectName;
	}
	
	public ObjectName(int id) {
		super(id);
	}

	/**
	 * @return the objectName
	 */
	public String getObjectName() {
		return objectName;
	}
}
