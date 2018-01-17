package com.iot.test.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.iot.test.DAO.CustomerDAO;
import com.iot.test.DAO.Impl.CustomerDAOImpl;
import com.iot.test.service.CustomerService;
import com.iot.test.vo.Customer;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDAO cDAO=new CustomerDAOImpl();
	@Override
	public void setCustomerList(HttpServletRequest req) {
		String order=req.getParameter("order");
		String orderby=req.getParameter("orderby");
		
		Customer cus=null;
		String param=req.getParameter("param");
		if(param!=null) {
			cus.setCustomerName(param);
		}
		System.out.println("orderby= "+orderby);
		req.setAttribute("customerList", cDAO.selectCustomerList(cus,order,orderby));
	}
}
