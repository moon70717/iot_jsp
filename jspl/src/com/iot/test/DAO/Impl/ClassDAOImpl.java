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

public class ClassDAOImpl implements ClassDAO {

	@Override
	public List<ClassInfo> selectClassList(ClassInfo ci) {
		List<ClassInfo> ClassList=new ArrayList<ClassInfo>();
		String sql="select * from class_info where 1=1";
		if(ci!=null) {
			sql+=" and ciname like ?";
		}
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
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

}
