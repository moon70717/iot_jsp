package com.test.iot.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public interface UserService {

	public ArrayList<HashMap<String,Object>> getUserList();
	public HashMap<String,Object> getUser();
	public int executeUpdate(int i,LinkedHashMap<String,Object> hm);
	public String mkSql(int i);
}
