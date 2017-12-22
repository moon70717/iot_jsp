package com.test.iot.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public interface UserDAO {
	
	public ArrayList<HashMap<String,Object>> selectUserList();
	public HashMap<String,Object> selectUser(); 
	public int executeUpdate(String sql,LinkedHashMap<String,Object> hm);
	public int executeUpdate(String sql);
}
