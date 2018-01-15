package com.jspl.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.jspl.test.dao.UserDAO;
import com.jspl.test.dao.impl.UserDAOImpl;
import com.jspl.test.service.UserService;
import com.jspl.test.vo.UserClass;

public class UserServiceImpl implements UserService{
	UserDAO uDAO=new UserDAOImpl();
	Gson gs=new Gson();
	
	private List<UserClass> getUserClassList(String uiName){
		List<UserClass> userList=new ArrayList<UserClass>();
		/*for(int i=0;i<10;i++) {
			UserClass uc=
			userList.add(uc);
		}*/
		userList=uDAO.getUserClassList(uiName);
		System.out.print(userList);
		return userList;
	}
	
	@Override
	public void getUserList(HttpServletRequest req) {
		String uiName=req.getParameter("uiName");
		List<UserClass> userList=getUserClassList(uiName);
		req.setAttribute("userList", userList);
	}

	@Override
	public void getSearchList(HttpServletRequest req) {
		String name=req.getParameter("param");
		List<UserClass> userList=uDAO.getSerachList(name);
		req.setAttribute("userList", userList);
	}

}
