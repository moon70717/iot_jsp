package com.jspl.test.service;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
	public void getUserList(HttpServletRequest req);
	public void getSearchList(HttpServletRequest req);
}
