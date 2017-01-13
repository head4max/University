package by.it_academy.model.entity4dao.init_list;

import by.it_academy.model.entity4dao.ExtendedUser;
import by.it_academy.model.entity4dao.User;

public class UserListInit extends AbstractListInit<User>{
	
	{
		this.countUser = 4;
		this.bundleKey = "user";
		this.bundlePath = "by.it_academy.model.sql.UserTableInit";
	}
	
	public UserListInit(){
		ListInit();
	}

	@Override
	public User getEntity(String strInit) {
		
		return ExtendedUser.getInstanceFromString(strInit);
	}
}
