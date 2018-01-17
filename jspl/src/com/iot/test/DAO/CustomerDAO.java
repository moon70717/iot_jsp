package com.iot.test.DAO;

import java.util.List;

import com.iot.test.vo.Customer;

public interface CustomerDAO {

	public List<Customer> selectCustomerList(Customer cus,String orderStr,String orderby);
}
