package com.iot.test.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.iot.test.DAO.UserDAO;
import com.iot.test.DAO.Impl.UserDAOImpl;
import com.iot.test.service.UserService;
import com.iot.test.vo.UserInfo;

public class UserServiceImpl implements UserService {
	UserDAO uDAO=new UserDAOImpl();
	Gson gs=new Gson();
	@Override
	public void getUserList(HttpServletRequest req) {
		UserInfo ui=null;
		String json=req.getParameter("param");
		if(json!=null) {
			ui=gs.fromJson(json, UserInfo.class);
		}
		req.setAttribute("userList", uDAO.selectUserList(ui));
	}

	@Override
	public void setUser(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertUser(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

}
