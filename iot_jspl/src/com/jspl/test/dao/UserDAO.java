package com.jspl.test.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.jspl.test.vo.UserClass;

public interface UserDAO {

	public List<UserClass> getUserClassList();
	public List<UserClass> getSerachList(String name);
}
