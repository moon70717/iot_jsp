package com.iot.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iot.test.dao.ClassDAO;
import com.iot.test.utils.DBUtil;
import com.iot.test.vo.ClassInfo;

import common.DBCon;

public class ClassDAOImpl implements ClassDAO {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public ArrayList<ClassInfo> selectClassList() {
		ArrayList<ClassInfo> classList= new ArrayList<ClassInfo>();
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=DBCon.getCon();
			String sql="select * from class_info";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				ClassInfo ci=new ClassInfo();
				ci.setCiNo(rs.getInt("ciNo"));
				ci.setCiDesc(rs.getString("ciDesc"));
				ci.setCiName(rs.getString("ciName"));
				classList.add(ci);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con);
			DBUtil.close(ps);
			DBUtil.close(rs);
		}
		return classList;
	}

	@Override
	public int openClass(ClassInfo ci) {
		con = null;
		ps = null;
		rs = null;
		try {
			con = DBCon.getCon();
			String sql = "insert class_info(ciName,ciDesc)values(?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, ci.getCiName());
			ps.setString(2, ci.getCiDesc());
			int i = ps.executeUpdate();

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
	public int updateClass(ClassInfo ci) {
		con = null;
		ps = null;
		rs = null;
		try {
			con = DBCon.getCon();
			String sql = "update class_info set ciName=?,cidesc=? where ciNo=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ci.getCiName());
			ps.setString(2, ci.getCiDesc());
			ps.setInt(3, ci.getCiNo());
			int i = ps.executeUpdate();

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
	public int deleteClass(ClassInfo ci) {
		con = null;
		ps = null;
		rs = null;
		try {
			con = DBCon.getCon();
			String sql = "delete from class_info where ciNo=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, ci.getCiNo());
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
