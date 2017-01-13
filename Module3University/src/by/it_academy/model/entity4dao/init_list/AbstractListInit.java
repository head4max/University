package by.it_academy.model.entity4dao.init_list;

import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import by.it_academy.model.entity4dao.Entity;

/**
 * @author head4max
 *
 */
public abstract class AbstractListInit<T extends Entity> {
	
	protected String bundleKey;
	protected String bundlePath;
	private ResourceBundle rbInitTable;
	
	protected int countUser;
	
	protected List<T> entityList;
	
	protected void ListInit(){
		rbInitTable = ResourceBundle.getBundle(bundlePath);
		entityList = new LinkedList<T>();
		
		for(int i = 1;i <= countUser;i++){
			T temp = getEntity(this.rbInitTable.getString(bundleKey + i));
			if(temp != null){
				this.entityList.add(temp);
			}
		}
	}
	
	public abstract T getEntity(String strInit);
	
	public List<T> getList() {
		return this.entityList;
	}
}
