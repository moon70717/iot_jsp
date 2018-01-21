package com.iot.test.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iot.test.DAO.ClassDAO;
import com.iot.test.common.DBCon;
import com.iot.test.common.DBUtil;
import com.iot.test.vo.ClassInfo;
import com.iot.test.vo.Customer;

public class ClassDAOImpl implements ClassDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	@Override
	public List<ClassInfo> selectClassList(ClassInfo ci) {
		List<ClassInfo> ClassList=new ArrayList<ClassInfo>();
		String sql="select * from class_info where 1=1";
		if(ci!=null) {
			sql+=" and ciname like ?";
		}
		con=null;
		ps=null;
		rs=null;
		try{
			con=DBCon.getCon();
			ps=con.prepareStatement(sql);
			if(ci!=null) {
				ps.setString(1, "%"+ci.getCiName()+"%");
			}
			rs=ps.executeQuery();
			while(rs.next()) {
				ClassInfo ci2=new ClassInfo();
				ci2.setCiName(rs.getString("ciName"));
				ci2.setCiDesc(rs.getString("ciDesc"));
				ClassList.add(ci2);
			}
		}catch(SQLException e) {
			
		}finally {
			DBUtil.closeAll(rs, con, ps);
		}
		System.out.println("ciName "+ClassList.get(0).getCiName());
		return ClassList;
	}

	@Override
	public int insertClass(ClassInfo ci) {
		con=null;
		ps=null;
		rs=null;
		int result=0;
		String sql="insert into class_info(ciname,cidesc)values(?,?)";
		try {
			con=DBCon.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1, ci.getCiName());
			ps.setString(2, ci.getCiDesc());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return result;
	}

	@Override
	public int deleteClass(int cuId) {
		con=null;
		ps=null;
		rs=null;
		int result=0;
		String sql="delete from class_info where cino=?";
		System.out.println("delete 진입");
			try {
				con=DBCon.getCon();
				ps=con.prepareStatement(sql);
				ps.setInt(1,cuId);
				result=ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}

	@Override
	public int updateClass(ClassInfo ci) {
		con=null;
		ps=null;
		int result=0;
		String sql="update class_info set ciname=?, cidesc=? where cino=?";
		
		try {
			con=DBCon.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1, ci.getCiName());
			ps.setString(2, ci.getCiDesc());
			ps.setInt(3, ci.getCiNo());
			
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}

