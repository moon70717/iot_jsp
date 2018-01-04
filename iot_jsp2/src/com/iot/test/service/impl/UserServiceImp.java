package com.iot.test.service.impl;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.iot.test.dao.UserDAO;
import com.iot.test.dao.impl.UserDAOImpl;
import com.iot.test.service.UserService;
import com.iot.test.vo.UserClass;

public class UserServiceImp implements UserService {
	private Gson gs = new Gson();
	private UserDAO ud = new UserDAOImpl();

	@Override
	public HashMap<String, Object> login(HttpServletRequest req) {
		UserClass uc = gs.fromJson(req.getParameter("param"), UserClass.class);
		UserClass checkUc = ud.selectUser(uc.getUiId());

		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("msg", "로그인 성공");
		hm.put("login", "ok");
		if (checkUc != null) {
			if (checkUc.getUiId().equals(uc.getUiId())) {
				if (!checkUc.getUiPwd().equals(uc.getUiPwd())) {
					hm.put("msg", "비밀번호를 확인하세요");
					hm.put("login", "no");
				} else {
					HttpSession hs = req.getSession();
					hs.setAttribute("user", uc);
					System.out.print(uc);
				}
			} else {
				hm.put("msg", "아이디를 확인하세요");
				hm.put("login", "no");
			}
		}
		return hm;
	}

	@Override
	public void logout(HttpServletRequest req) {
		HttpSession hs = req.getSession();
		hs.invalidate();

	}
}
