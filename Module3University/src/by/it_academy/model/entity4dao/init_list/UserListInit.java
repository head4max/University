package by.it_academy.model.entity4dao.init_list;

import java.util.List;

import by.it_academy.model.entity4dao.ExtendedUser;
import by.it_academy.model.entity4dao.User;

public class UserListInit extends AbstractListInit<User>{
	
	{
		this.countUser = 6;
		this.bundleKey = "user";
		this.bundlePath = "by.it_academy.model.sql.UsersTableInit";
	}
	
	public UserListInit(){
		ListInit();
	}

	@Override
	public List<User> getList() {

		return this.entityList;
	}

	@Override
	public User getEntity(String strInit) {
		
		return ExtendedUser.getInstanceFromString(strInit);
	}
}
