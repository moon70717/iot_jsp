package com.jspl.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.jspl.test.common.DBCon;
import com.jspl.test.dao.UserDAO;
import com.jspl.test.vo.UserClass;

public class UserDAOImpl implements UserDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	
	@Override
	public List<UserClass> getUserClassList() {
		con=null;
		ps=null;
		rs=null;
		con=DBCon.getCon();
		String sql="select * from user_Info ui, class_Info ci where ui.cino=ci.cino";
		List<UserClass> userList=new ArrayList<UserClass>();
		
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				UserClass uc=new UserClass();
				uc.setUiAge(rs.getInt("uiAge"));
				uc.setUiId(rs.getString("uiId"));
				uc.setUiName(rs.getString("uiName"));
				uc.setUiNo(rs.getInt("uiAge"));
				uc.setUiPwd(rs.getString("uiPwd"));
				uc.setUiRegdate(rs.getString("uiRegdate"));
				uc.setAddress(rs.getString("address"));
				uc.setCiDesc(rs.getString("ciDesc"));
				uc.setCiName(rs.getString("ciName"));
				uc.setCiNo(rs.getInt("ciNo"));
				userList.add(uc);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}


	@Override
	public List<UserClass> getSerachList(String name) {
		String sql="select * from user_Info ui where uiName like(%?%)";
		List<UserClass> userList=new ArrayList<UserClass>();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(0, name);
			rs=ps.executeQuery();
			while(rs.next()) {
				UserClass uc=new UserClass();
				uc.setUiAge(rs.getInt("uiAge"));
				uc.setUiId(rs.getString("uiId"));
				uc.setUiName(rs.getString("uiName"));
				uc.setUiNo(rs.getInt("uiAge"));
				uc.setUiPwd(rs.getString("uiPwd"));
				uc.setUiRegdate(rs.getString("uiRegdate"));
				uc.setAddress(rs.getString("address"));
				uc.setCiDesc(rs.getString("ciDesc"));
				uc.setCiName(rs.getString("ciName"));
				uc.setCiNo(rs.getInt("ciNo"));
				userList.add(uc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userList;
	}

}
