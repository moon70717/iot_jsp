package com.iot.test.dao;

import java.util.ArrayList;

import com.iot.test.vo.ClassInfo;

public interface ClassDAO {

	ArrayList<ClassInfo> selectClassList();
	int openClass(ClassInfo ci);
	int updateClass(ClassInfo ci);
	int deleteClass(ClassInfo ci);
}
