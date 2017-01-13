package by.it_academy.model.entity4dao.init_list;

import by.it_academy.model.entity4dao.Faculty;

/**
 * class for read initial "faculty" from  bundle
 * @author head4max
 *
 */
public class FacultyListInit extends AbstractListInit<Faculty> {

	{
		this.countUser = 5;
		this.bundleKey = "faculty";
		this.bundlePath = "by.it_academy.model.sql.FacultyTableInit";
	}
	
	public FacultyListInit(){
		ListInit();
	}
	
	@Override
	public Faculty getEntity(String strInit) {
		return Faculty.getInstance(strInit);
	}

}
