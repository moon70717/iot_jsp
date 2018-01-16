package com.iot.test.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iot.test.DAO.UserDAO;
import com.iot.test.common.DBCon;
import com.iot.test.common.DBUtil;
import com.iot.test.vo.UserInfo;

public class UserDAOImpl implements UserDAO {

	@Override
	public List<UserInfo> selectUserList(UserInfo ui) {
		List<UserInfo> userList=new ArrayList<UserInfo>();
		String sql="select * from user_info where 1=1";
		if(ui!=null) {
			sql+=" and uiname like ?";
		}
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			con=DBCon.getCon();
			ps=con.prepareStatement(sql);
			if(ui!=null) {
				ps.setString(1, "%"+ui.getUiName()+"%");
			}
			rs=ps.executeQuery();
			while(rs.next()) {
				UserInfo ui2=new UserInfo();
				ui2.setUiNo(rs.getInt("uiNo"));
				ui2.setUiId(rs.getString("uiId"));
				ui2.setUiAge(rs.getInt("uiAge"));
				ui2.setUiName(rs.getString("uiName"));
				ui2.setUiPwd(rs.getString("uiPwd"));
				ui2.setUiRegdate(rs.getString("uiRegdate"));
				ui2.setAddress(rs.getString("address"));
				userList.add(ui2);
			}
		}catch(SQLException e) {
			
		}finally {
			DBUtil.closeAll(rs, con, ps);
		}
		return userList;
	}

	@Override
	public UserInfo setUser(UserInfo ui) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertUser(UserInfo ui) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(UserInfo ui) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(UserInfo ui) {
		// TODO Auto-generated method stub
		return 0;
	}

}
