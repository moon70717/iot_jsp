package com.test.iot.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.test.iot.dao.UserDAO;
import com.test.iot.dao.impl.UserDAOImpl;
import com.test.iot.service.UserService;

public class UserServiceImpl implements UserService {
	Connection con;
	private UserDAO ud = new UserDAOImpl();

	@Override
	public ArrayList<HashMap<String, Object>> getUserList(String name) {
		String sql = mkSql(4, name);
		ArrayList<HashMap<String, Object>> userList = ud.selectUserList(sql);
		return userList;
	}

	@Override
	public ArrayList<HashMap<String, Object>> getUser(int i, String name) {
		String sql="select * from "+name+"_info where uino="+i;
		ArrayList<HashMap<String, Object>> userList = ud.selectUserList(sql);
		return userList;
	}

	@Override
	public int executeUpdate(int i, LinkedHashMap<String, Object> hm, String name) {
		int result = 0;
		String sql = mkSql(i, name);
		result = ud.executeUpdate(sql, hm);

		return result;
	}

	public String mkSql(int i, String name) {
		String sql = "";
		if (i == 1) {// insert
			sql = "INSERT INTO " + name + "_INFO(UINAME,UIAGE,UIID,UIPWD,CINO,uiregdate,address) "
					+ "VALUES (?,?,?,?,?,Now(),?)";
		} else if (i == 2) {// delete
			sql = "delete from " + name + "_info where uino=?";
		} else if (i == 3) {// update
			sql = "update " + name + "_info set address=? where uino=?";
		} else if (i == 4) {
			sql = "select * from" + name + "_info";
		} else {
			System.out.println("에러가 발생했습니다");
		}

		return sql;
	}

}
