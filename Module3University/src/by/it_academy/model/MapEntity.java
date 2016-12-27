package by.it_academy.model;

import java.util.HashMap;

/**
 * @author head4max
 *
 */
class MapEntity<T,V> extends Entity {

	private HashMap<T, V> Marks;
	
	public MapEntity(){
		this.Marks = new HashMap<T, V>();
	}
	
	public void addMark(T name, V mark) {
		this.Marks.put(name, mark);
	}
	
	public V getMark(T name) {
		return this.Marks.get(name);
	}
}
