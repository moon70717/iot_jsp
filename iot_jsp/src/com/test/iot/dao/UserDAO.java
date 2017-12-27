package com.test.iot.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public interface UserDAO {

	public ArrayList<HashMap<String, Object>> selectUserList(String sql);

	public HashMap<String, Object> selectUser();

	public int executeUpdate(String sql, LinkedHashMap<String, Object> hm);

	public int executeUpdate(String sql);

	public void setParameter(LinkedHashMap<String, Object> hm) throws SQLException;
}
