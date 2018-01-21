package com.iot.test.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iot.test.DAO.MenuDAO;
import com.iot.test.common.DBCon;
import com.iot.test.common.DBUtil;
import com.iot.test.vo.Menu;

public class MenuDAOImpl implements MenuDAO {
	
	@Override
	public List<Menu> selectMenuList() {
		List<Menu> menuList=new ArrayList<Menu>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from menu order by mNum";
		
		try {
			con=DBCon.getCon();
			//con=DBConTest.getCon();
			ps=con.prepareStatement(sql);
			System.out.println("ps");
			rs=ps.executeQuery();
			System.out.println("rs");
			while(rs.next()) {
				Menu m=new Menu();
				m.setmNum(rs.getInt("mNum"));
				m.setmName(rs.getString("mName"));
				m.setmUrl(rs.getString("mUrl"));
				m.setmDesc(rs.getString("mDesc"));
				menuList.add(m);
			}
		} catch (SQLException e) {
			
			DBUtil.closeAll(rs, con, ps);
		}
		
		
		return menuList;
	}

}
