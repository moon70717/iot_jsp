package com.test.iot.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.test.iot.common.DBCon;
import com.test.iot.dao.ClassDAO;
import com.test.iot.dao.impl.ClassDAOImpl;
import com.test.iot.service.ClassService;

public class ClassServiceImpl implements ClassService {
	Connection con;
	private ClassDAO ud = new ClassDAOImpl();

	@Override
	public ArrayList<HashMap<String, Object>> getUserList() {
		con = DBCon.getCon();
		ArrayList<HashMap<String, Object>> userList = ud.selectUserList();

		DBCon.closeCon();
		return userList;
	}

	@Override
	public HashMap<String, Object> getUser() {
		return null;
	}

	@Override
	public int executeUpdate(int i, LinkedHashMap<String, Object> hm) {
		int result = 0;
		String sql = mkSql(i);
		result = ud.executeUpdate(sql, hm);

		return result;
	}

	public String mkSql(int i) {
		String sql = "";
		if (i == 1) {// insert
			sql = "INSERT INTO CLASS_INFO(CINAME,CIDESC) "
					+ "VALUES (?,?)";
		} else if (i == 2) {// delete
			sql = "delete from user_info where CINO=?";
		} else if (i == 3) {// update
			sql = "update user_info set CIDESC=? where CINO=?";
		} else {
			System.out.println("에러가 발생했습니다");
		}

		return sql;
	}

}
