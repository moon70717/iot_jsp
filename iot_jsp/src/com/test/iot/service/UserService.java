package com.test.iot.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public interface UserService {

	public ArrayList<HashMap<String, Object>> getUserList(String name);

	public ArrayList<HashMap<String, Object>> getUser(int i, String name);

	public int executeUpdate(int i, LinkedHashMap<String, Object> hm, String name);

	public String mkSql(int i, String name);
}
