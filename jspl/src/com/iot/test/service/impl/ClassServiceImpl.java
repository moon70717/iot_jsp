package com.iot.test.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.iot.test.DAO.ClassDAO;
import com.iot.test.DAO.Impl.ClassDAOImpl;
import com.iot.test.service.ClassService;
import com.iot.test.vo.ClassInfo;
import com.iot.test.vo.Customer;

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

	@Override
	public void insertClass(HttpServletRequest req) {
		ClassInfo ci=new ClassInfo();
		if(req.getParameter("customerName")!=null) {
			ci.setCiDesc(req.getParameter(""));
			ci.setCiName(req.getParameter(""));
		}else {
			return;
		}
		req.setAttribute("result", "failed");
		int result=cDAO.insertClass(ci);
		if(result!=0) {
			req.setAttribute("result", "suecces");
		}
		
	}

	@Override
	public void deleteClass(HttpServletRequest req) {
		System.out.println("setvice!");
		String temp=req.getParameter("ciId");
		System.out.println("temp= "+temp);
		int ciId=0;
		if(req.getParameter("ciId")!=null) {
			ciId=Integer.parseInt(temp);
			System.out.println("ciId"+ciId);
		}else {
			return;
		}
		req.setAttribute("result", "failed");
		int result=cDAO.deleteClass(ciId);
		if(result!=0) {
			req.setAttribute("result", "suecces");
		}
		
	}

	@Override
	public void updateClass(HttpServletRequest req) {
		ClassInfo ci=new ClassInfo();
		ci.setCiDesc(req.getParameter("ciDesc"));
		ci.setCiName(req.getParameter("ciName"));
		ci.setCiNo(Integer.parseInt(req.getParameter("ciNo")));
		req.setAttribute("result", "failed");
		int result=cDAO.updateClass(ci);
		if(result!=0) {
			req.setAttribute("result", "suecces");
		}
		
	}

}
