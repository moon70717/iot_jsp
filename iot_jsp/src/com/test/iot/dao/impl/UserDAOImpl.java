package com.test.iot.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
	
	public ArrayList<HashMap<String, Object>> parseResultSet(ResultSet set){ // 유저 키값에 맞춰서 데이터 넣는용도
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
	
	public void setParameter(LinkedHashMap<String,Object> hm) throws SQLException {
		if(hm!=null) {
			Iterator<String> it = hm.keySet().iterator();
			int idx = 1;
			while(it.hasNext()) {
				String key = it.next();
				ps.setObject(idx++, hm.get(key));
			}
		}
    }

	@Override
	public HashMap<String, Object> selectUser() {
		return null;
	}

	@Override
	public int executeUpdate(String sql, LinkedHashMap<String, Object> hm) {
		Connection con=DBCon.getCon();
		int result =0;
		try {
			ps=con.prepareStatement(sql);
			setParameter(hm);
			result=ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		con=null;
		return result;
	}

	@Override
	public int executeUpdate(String sql) {
		return executeUpdate(sql,null);
	}
	
}
