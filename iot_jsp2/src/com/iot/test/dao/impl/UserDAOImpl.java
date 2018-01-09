package com.iot.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iot.test.dao.UserDAO;
import com.iot.test.utils.DBUtil;
import com.iot.test.vo.UserClass;

import common.DBCon;

public class UserDAOImpl implements UserDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public ArrayList<UserClass> selectUserList() {
		ArrayList<UserClass> userList = new ArrayList<UserClass>();
		con = null;
		ps = null;
		rs = null;
		try {
			String sql = "select *, date_format(uiregdate, '%Y-%m-%d') as rdate from user_info ui,class_info ci where ui.cino=ci.cino";
			con = DBCon.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserClass uc = new UserClass();
				uc.setAddress(rs.getString("address"));
				uc.setCiDesc(rs.getString("cidesc"));
				uc.setCiName(rs.getString("ciname"));
				uc.setCiNo(rs.getInt("cino"));
				uc.setUiAge(rs.getInt("uiage"));
				uc.setUiId(rs.getString("uiId"));
				uc.setUiName(rs.getString("uiName"));
				uc.setUiNo(rs.getInt("uino"));
				uc.setUiPwd(rs.getString("uipwd"));
				uc.setUiRegdate(rs.getString("rdate"));
				userList.add(uc);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(con);
			DBUtil.close(ps);
		}
		return userList;
	}

	@Override
	public UserClass selectUser(int uiNo) {

		return null;
	}

	@Override
	public UserClass selectUser(String uiId) {
		con = null;
		ps = null;
		rs = null;
		try {
			con = DBCon.getCon();
			String sql = "select * from user_info ui, class_info ci where ui.cino=ci.cino and ui.uiid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, uiId);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserClass uc = new UserClass();
				uc.setAddress(rs.getString("address"));
				uc.setCiDesc(rs.getString("cidesc"));
				uc.setCiName(rs.getString("ciname"));
				uc.setCiNo(rs.getInt("cino"));
				uc.setUiAge(rs.getInt("uiage"));
				uc.setUiId(rs.getString("uiId"));
				uc.setUiName(rs.getString("uiName"));
				uc.setUiNo(rs.getInt("uino"));
				uc.setUiPwd(rs.getString("uipwd"));
				uc.setUiRegdate(rs.getString("UiRegdate"));

				return uc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(con);
			DBUtil.close(ps);
		}
		return null;
	}

	@Override
	public int insertUser(UserClass uc) {
		con = null;
		ps = null;
		rs = null;
		try {
			con = DBCon.getCon();
			String sql = "insert into user_info(uiName,uiAge,uiId,uiPwd,ciNo,"
					+ "uiRegdate,address)values(?,?,?,?,?,now(),?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, uc.getUiName());
			ps.setInt(2, uc.getUiAge());
			ps.setString(3, uc.getUiId());
			ps.setString(4, uc.getUiPwd());
			ps.setInt(5, uc.getCiNo());
			ps.setString(6, uc.getAddress());
			int i = ps.executeUpdate();
			System.out.println("result=" + i);

			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con);
			DBUtil.close(ps);
		}

		return 0;
	}

	@Override
	public int deleteUser(UserClass uc) {
		con = null;
		ps = null;
		rs = null;
		try {
			con = DBCon.getCon();
			String sql = "delete from user_info where uiNo=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, uc.getUiNo());
			int i = ps.executeUpdate();
			System.out.println("result=" + i);

			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con);
			DBUtil.close(ps);
		}
		return 0;
	}
	
	@Override
	public int updateUser(UserClass uc) {
		con = null;
		ps = null;
		rs = null;
		try {
			con = DBCon.getCon();
			String sql = "update user_info set uiName=?,uiAge=?,address=? where uiNo=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, uc.getUiName());
			ps.setInt(2, uc.getUiAge());
			ps.setString(3, uc.getAddress());
			ps.setInt(4, uc.getUiNo());
			System.out.print(ps);
			int i = ps.executeUpdate();
			System.out.println("result=" + i);

			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con);
			DBUtil.close(ps);
		}

		return 0;
	}
}
