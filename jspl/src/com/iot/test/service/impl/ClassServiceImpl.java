package com.iot.test.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.iot.test.DAO.ClassDAO;
import com.iot.test.DAO.Impl.ClassDAOImpl;
import com.iot.test.service.ClassService;
import com.iot.test.vo.ClassInfo;

public class ClassServiceImpl implements ClassService {
	ClassDAO cDAO = new ClassDAOImpl();
	Gson gs = new Gson();

	@Override
	public void getClassList(HttpServletRequest req) {
		ClassInfo ci = null;
		String param = req.getParameter("param");
		if (param != null) {
			ci.setCiName(param);
			System.out.println("uiName= "+ci.getCiName());
		}
		req.setAttribute("classList", cDAO.selectClassList(ci));
		/*System.out.println(req.getAttribute("classList").toString());*/
		
	}

}
