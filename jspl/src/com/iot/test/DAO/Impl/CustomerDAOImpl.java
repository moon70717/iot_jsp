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
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	@Override
	public List<Customer> selectCustomerList(String orderStr, Customer cusInput) {
		List<Customer> customerList=new ArrayList<Customer>();
		String sql="select * from customer where 1=1";
		con=null;
		ps=null;
		rs=null;
		if(cusInput.getCustomerName()!=null) {
			sql+=" and customerName like ?";
		}
		sql+=" order by "+orderStr;
		try {
			con=DBCon.getCon();
			ps=con.prepareStatement(sql);
			if(cusInput.getCustomerName()!=null) {
				ps.setString(1, "%"+cusInput.getCustomerName()+"%");
			}
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

	@Override
	public int insertCustomer(Customer cus) {
		con=null;
		ps=null;
		rs=null;
		int result=0;
		String sql="insert into customer(CustomerName,City,Country)values(?,?,?)";
		try {
			con=DBCon.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1, cus.getCustomerName());
			ps.setString(2, cus.getCity());
			ps.setString(3, cus.getCountry());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return result;
	}

	@Override
	public int deleteCustomer(int cuId) {
		con=null;
		ps=null;
		rs=null;
		int result=0;
		String sql="delete from customer where customerId=?";
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

}
