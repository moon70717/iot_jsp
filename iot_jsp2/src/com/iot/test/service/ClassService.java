package com.iot.test.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.iot.test.vo.ClassInfo;

public interface ClassService {

	public ArrayList<ClassInfo> getClassList();

	public String openClass(HttpServletRequest req);
	
	public String deleteClass(HttpServletRequest req);
	
	public String updateClass(HttpServletRequest req);
}
