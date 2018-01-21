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
		String order=(req.getParameter("order")==null)? "customerId":req.getParameter("order");
		String orderStr="customerId asc,customerName asc,city asc,country asc";
		String search=req.getParameter("search");
		
		Customer cus=new Customer();
		if(search!=null) {
			cus.setCustomerName(search);
		}
		System.out.println("get button name "+req.getParameter("name"));
		if(req.getParameter("orderStr")!=null) {
			orderStr=req.getParameter("orderStr");
			int fIdx=orderStr.indexOf(order);
			String temp=orderStr.substring(fIdx);
			int lIdx=temp.indexOf(",");
			String type=temp.substring(0);
			if(lIdx!=-1) {
				type=temp.substring(0,lIdx);
			}
			orderStr=orderStr.replace(type+",", "");
			type=(type.trim().equals(order+" asc"))?" desc,":" asc,"; 
			orderStr=order+type+orderStr;
		}
		req.setAttribute("search", search);
		req.setAttribute("order", order);
		req.setAttribute("orderStr", orderStr);
		req.setAttribute("customerList", cDAO.selectCustomerList(orderStr, cus));
	}
	@Override
	public void insertCustomer(HttpServletRequest req) {
		Customer cus=new Customer();
		if(req.getParameter("customerName")!=null) {
			cus.setCustomerName(req.getParameter("customerName"));
			cus.setCity(req.getParameter("city"));
			cus.setCountry(req.getParameter("country"));
		}else {
			return;
		}
		req.setAttribute("result", "failed");
		int result=cDAO.insertCustomer(cus);
		if(result!=0) {
			req.setAttribute("result", "suecces");
		}
	}
	@Override
	public void deleteCustomer(HttpServletRequest req) {
		System.out.println("setvice!");
		String temp=req.getParameter("cuId");
		System.out.println("temp= "+temp);
		int cuId=0;
		if(req.getParameter("cuId")!=null) {
			cuId=Integer.parseInt(temp);
			System.out.println("cuId"+cuId);
		}else {
			return;
		}
		req.setAttribute("result", "failed");
		int result=cDAO.deleteCustomer(cuId);
		if(result!=0) {
			req.setAttribute("result", "suecces");
		}
	}
	@Override
	public void updateCustomer(HttpServletRequest req) {
		Customer cus=new Customer();
		cus.setCustomerName(req.getParameter("cuName"));
		cus.setCity(req.getParameter("city"));
		cus.setCountry(req.getParameter("country"));
		cus.setCustomerId(Integer.parseInt(req.getParameter("cuId")));
		req.setAttribute("result", "failed");
		int result=cDAO.updateCustomer(cus);
		if(result!=0) {
			req.setAttribute("result", "suecces");
		}
		
	}
}
