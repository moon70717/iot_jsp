package com.test.iot.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.test.iot.common.DBCon;
import com.test.iot.dao.UserDAO;
import com.test.iot.dao.impl.UserDAOImpl;
import com.test.iot.service.UserService;

public class UserServiceImpl implements UserService{
	Connection con;
	private UserDAO ud=new UserDAOImpl();
	@Override
	public ArrayList<HashMap<String, Object>> getUserList() {
		con=DBCon.getCon();
		ArrayList<HashMap<String,Object>> userList=ud.selectUserList();
		
		
		DBCon.closeCon();
		return userList;
	}

	@Override
	public HashMap<String, Object> getUser() {
		return null;
	}

	@Override
	public int executeUpdate(String sql, LinkedHashMap<String, Object> hm) {
		int result=0;
		con=DBCon.getCon();
		result=ud.executeUpdate(sql);// 받은 값 없으니깐 일단 이렇게만 한다.
		
		return result;
	}

}
