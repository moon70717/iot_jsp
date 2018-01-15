package com.jspl.test.dao;

import java.util.List;

import com.jspl.test.vo.UserClass;

public interface UserDAO {

	public List<UserClass> getUserClassList(String uiName);
	public List<UserClass> getSerachList(String name);
}
