package com.jspl.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.jspl.test.dao.UserDAO;
import com.jspl.test.dao.impl.UserDAOImpl;
import com.jspl.test.service.UserService;
import com.jspl.test.vo.UserClass;

public class UserServiceImpl implements UserService{
	UserDAO uDAO=new UserDAOImpl();
	
	
	public UserClass getUserClass(int i) {
		UserClass uc=new UserClass();
		uc.setUiNo(i);
		uc.setUiName("이름"+i);
		uc.setUiAge(i);
		uc.setUiId("아이디"+i);
		uc.setAddress("주소"+i);
		return uc;
	}
	
	private List<UserClass> getUserClassList(){
		List<UserClass> userList=new ArrayList<UserClass>();
		/*for(int i=0;i<10;i++) {
			UserClass uc=
			userList.add(uc);
		}*/
		userList=uDAO.getUserClassList();
		System.out.print(userList);
		return userList;
	}
	
	@Override
	public void getUserList(HttpServletRequest req) {
		List<UserClass> userList=getUserClassList();
		req.setAttribute("userList", userList);
	}

}
