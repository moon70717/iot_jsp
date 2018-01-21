package com.iot.test.service;

import javax.servlet.http.HttpServletRequest;

public interface ClassService {
	public void getClassList(HttpServletRequest req);
	public void insertClass(HttpServletRequest req);
	public void deleteClass(HttpServletRequest req);
	public void updateClass(HttpServletRequest req);
}
