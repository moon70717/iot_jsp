package com.test.iot.service.impl;

import java.util.ArrayList;
import java.util.HashMap;

import com.test.iot.common.DBCon;
import com.test.iot.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public ArrayList<HashMap<String, Object>> getUserList() {
		DBCon.getCon();
		DBCon.closeCon();
		return null;
	}

	@Override
	public HashMap<String, Object> getUser() {
		return null;
	}

}
