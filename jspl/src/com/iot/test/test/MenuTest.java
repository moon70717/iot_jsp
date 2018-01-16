package com.iot.test.test;

import java.util.List;

import com.iot.test.DAO.MenuDAO;
import com.iot.test.DAO.Impl.MenuDAOImpl;
import com.iot.test.vo.Menu;

public class MenuTest {

	public static void main(String[]args) {
		MenuDAO udao=new MenuDAOImpl();
		List<Menu> menuList=udao.selectMenuList();
		for(Menu m:menuList) {
			System.out.println(m);
		}
	}
}
