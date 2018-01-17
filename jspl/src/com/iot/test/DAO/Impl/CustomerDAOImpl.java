package com.iot.test.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iot.test.DAO.CustomerDAO;
import com.iot.test.common.DBCon;
import com.iot.test.vo.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public List<Customer> selectCustomerList(Customer cusName,String orderStr,String orderby) {
		List<Customer> customerList=new ArrayList<Customer>();
		String sql="select * from customer where 1=1";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		/*if(cusName!=null) {
			sql+=" and customerName=?";
		}*/
		
		if(orderStr!=null) {
			
			sql+=" order by "+orderStr+" "+orderby;
		}
		try {
			con=DBCon.getCon();
			ps=con.prepareStatement(sql);
			/*if(cusName!=null) {
				ps.setString(0, cusName.getCustomerName());
			}*/
			/*if(orderStr!=null) {
				ps.setString(0, orderStr);
			}*/
			System.out.println("sql= "+sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Customer cus=new Customer();
				cus.setCustomerName(rs.getString("customerName"));
				cus.setCustomerId(rs.getInt("customerId"));
				cus.setCity(rs.getString("city"));
				cus.setCountry(rs.getString("country"));
				customerList.add(cus);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			/*DBUtil.closeAll(rs, con, ps);*/
		}
		System.out.print(customerList);
		return customerList;
	}

}
