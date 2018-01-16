package com.iot.test.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.iot.test.DAO.MenuDAO;
import com.iot.test.DAO.Impl.MenuDAOImpl;
import com.iot.test.service.MenuService;

public class MenuServiceImpl implements MenuService {
	MenuDAO mDAO=new MenuDAOImpl();
	@Override
	public void getMenuList(HttpServletRequest req) {
		req.setAttribute("menuList", mDAO.selectMenuList());

	}

}
