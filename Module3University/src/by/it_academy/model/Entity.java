package by.it_academy.model;

/**
 * use for parametrized DAO classes
 * @author head4max
 *
 */
class Entity {
	
	protected int id = 0;
	
	protected Entity(){
	}
	
	protected Entity(int id){
		this.id = id;
	}
}
