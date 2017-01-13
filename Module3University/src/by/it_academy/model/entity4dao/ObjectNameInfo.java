package by.it_academy.model.entity4dao;

/**
 * expert-class contains info about object from "objects" table
 * @author head4max
 *
 */
public class ObjectNameInfo extends Entity {
	
	private String objectName;
	
	public ObjectNameInfo(String objectName){
		this(objectName.hashCode());
		this.objectName = objectName;
	}
	
	/**
	 * constructor
	 * @param id
	 */
	public ObjectNameInfo(int id) {
		super(id);
	}

	/**
	 * @return the objectName
	 */
	public String getObjectName() {
		return objectName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ObjectNameInfo [" + (objectName != null ? "objectName=" + objectName + ", " : "") + "id=" + id + "]";
	}
}
