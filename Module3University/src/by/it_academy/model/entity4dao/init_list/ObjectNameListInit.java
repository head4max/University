package by.it_academy.model.entity4dao.init_list;

import by.it_academy.model.entity4dao.ObjectNameInfo;

public class ObjectNameListInit extends AbstractListInit<ObjectNameInfo> {

	{
		this.countUser = 7;
		this.bundleKey = "object";
		this.bundlePath = "by.it_academy.model.sql.ObjectNameTableInit";
	}
	
	public ObjectNameListInit(){
		ListInit();
	}
	
	@Override
	public ObjectNameInfo getEntity(String strInit) {
		return new ObjectNameInfo(strInit);
	}

}
