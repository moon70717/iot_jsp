package com.test.iot.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.test.iot.common.DBCon;
import com.test.iot.dao.UserDAO;
import com.test.iot.dao.impl.UserDAOImpl;
import com.test.iot.service.UserService;

public class UserServiceImpl implements UserService {
	Connection con;
	private UserDAO ud = new UserDAOImpl();

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
		result = ud.executeUpdate(sql, null);// 받은 값 없으니깐 일단 이렇게만 한다.

		return result;
	}

	public String mkSql(int i) {
		String sql = "";
		if (i == 1) {// insert
			sql = "INSERT INTO USER_INFO(UINAME,UIAGE,UIID,UIPWD,CINO,uiregdate,address) "
					+ "VALUES (?,?,?,?,?,Now(),?)";
		} else if (i == 2) {// delete
			sql = "delete from user_info where uino=?";
		} else if (i == 3) {// update
			sql = "update user_info set address=? where uino=?";
		} else {
			System.out.println("에러가 발생했습니다");
		}

		return sql;
	}

}
