package com.iot.test.DAO;

import java.util.List;

import com.iot.test.vo.ClassInfo;

public interface ClassDAO {
	public List<ClassInfo> selectClassList(ClassInfo ci);
}
