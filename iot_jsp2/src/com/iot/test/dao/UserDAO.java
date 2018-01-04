package com.iot.test.dao;

import java.util.ArrayList;

import com.iot.test.vo.UserClass;

public interface UserDAO {

	public ArrayList<UserClass> getUserList(String sql);
	UserClass selectUser(int uiNo);
	UserClass selectUser(String uiId);
	int insertUser(UserClass uc);
	int updateUser(UserClass uc);
	int deleteUser(UserClass uc);
}
