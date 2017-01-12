package by.it_academy.model.dao;

import by.it_academy.model.entity4dao.ObjectNameInfo;

/**
 * additional methods for table-links "objectName"
 * @author head4max
 *
 */
public interface ObjectNameDAO extends AbstractDAO<ObjectNameInfo> {

	/**
	 * boolean deleteByName({@link String})<br\>
	 * @param object - name of an object to delete
	 * @return true if deleting was successful
	 */
	boolean deleteByName(String object);
}
