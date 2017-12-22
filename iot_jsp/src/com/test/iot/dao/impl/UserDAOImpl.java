package com.test.iot.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.test.iot.common.DBCon;
import com.test.iot.dao.UserDAO;

public class UserDAOImpl implements UserDAO {
	PreparedStatement ps;
	ResultSet rs;
	@Override
	public ArrayList<HashMap<String, Object>> selectUserList() {
		ps = null;
		rs = null;
		ArrayList<HashMap<String, Object>> userList = new ArrayList<HashMap<String, Object>>();
		String sql = "select * from user_info";

		try {
			ps = DBCon.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
			userList=parseResultSet(rs);//ResultSet userList에 적용
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public ArrayList<HashMap<String, Object>> parseResultSet(ResultSet set){
		ArrayList<HashMap<String, Object>> userList=new ArrayList<HashMap<String, Object>>();
		ResultSetMetaData rsmd;
		try {
			rsmd = set.getMetaData();
			String[] colNames=new String[rsmd.getColumnCount()];
			for(int i=0;i<colNames.length;i++) {
				colNames[i]=rsmd.getColumnLabel(i+1);
			}
			while(set.next()) {
				HashMap<String, Object> hm=new HashMap<String, Object>();
				for(String colName:colNames) {
					hm.put(colName, set.getString(colName));
				}
				userList.add(hm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public HashMap<String, Object> selectUser() {
		return null;
	}

	@Override
	public int executeUpdate(String sql, LinkedHashMap<String, Object> hm) {//나중에 입력받게 구현할때 좀더 추가
		int result =0;
		try {
			ps=DBCon.getCon().prepareStatement(sql);
			//setpara   이부분 할거
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int executeUpdate(String sql) {
		return executeUpdate(sql,null);
	}
	
	

}
