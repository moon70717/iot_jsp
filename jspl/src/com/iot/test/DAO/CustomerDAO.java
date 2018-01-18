package com.iot.test.DAO;

import java.util.List;

import com.iot.test.vo.Customer;

public interface CustomerDAO {

	public List<Customer> selectCustomerList(String orderby, Customer cus);
	
	public int insertCustomer(Customer cus);
	
	public int deleteCustomer(int cuId);
}
