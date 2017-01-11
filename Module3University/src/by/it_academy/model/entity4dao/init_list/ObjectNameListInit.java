package by.it_academy.model.entity4dao.init_list;

import java.util.List;

import by.it_academy.model.entity4dao.ObjectName;

public class ObjectNameListInit extends AbstractListInit<ObjectName> {

	{
		this.countUser = 7;
		this.bundleKey = "object";
		this.bundlePath = "by.it_academy.model.sql.ObjectNameTableInit";
	}
	
	@Override
	public ObjectName getEntity(String strInit) {
		return new ObjectName(strInit);
	}

	@Override
	public List<ObjectName> getList() {
		return this.entityList;
	}


}
