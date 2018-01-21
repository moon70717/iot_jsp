package com.iot.test.DAO;

import java.util.List;

import com.iot.test.vo.ClassInfo;
import com.iot.test.vo.Customer;

public interface ClassDAO {
	public List<ClassInfo> selectClassList(ClassInfo ci);

	public int insertClass(ClassInfo cus);

	public int deleteClass(int cuId);

	public int updateClass(ClassInfo cus);
}
