package com.iot.test.service.impl;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.iot.test.dao.ClassDAO;
import com.iot.test.dao.impl.ClassDAOImpl;
import com.iot.test.service.ClassService;
import com.iot.test.vo.ClassInfo;

public class ClassServiceImpl implements ClassService {
	private Gson gs = new Gson();
	private ClassDAO cdao=new ClassDAOImpl();

	@Override
	public ArrayList<ClassInfo> getClassList() {
		
		return cdao.selectClassList();
	}

	@Override
	public String openClass(HttpServletRequest req) {
		String param=req.getParameter("param");
		ClassInfo ci=gs.fromJson(param, ClassInfo.class);
		int result=cdao.openClass(ci);
		HashMap<String,String> rm= new HashMap<String,String>();
		rm.put("result", "no");
		rm.put("msg", "입력에 실패하였습니다");
		if(result==1) {
			rm.put("result", "ok");
			rm.put("msg", "성공했습니다");
		}
		return gs.toJson(rm);
	}

	@Override
	public String deleteClass(HttpServletRequest req) {
		int ciNo=Integer.parseInt(req.getParameter("ciNo"));
		ClassInfo ci=new ClassInfo();
		ci.setCiNo(ciNo);
		int result=cdao.deleteClass(ci);
		HashMap<String,String> rm= new HashMap<String,String>();
		rm.put("result", "no");
		rm.put("msg", "삭제에 실패하였습니다");
		if(result==1) {
			rm.put("result", "ok");
			rm.put("msg", "성공했습니다");
		}
		return gs.toJson(rm);
	}

	@Override
	public String updateClass(HttpServletRequest req) {
		String param=req.getParameter("param");
		System.out.print("classService param "+param);
		ClassInfo ci=gs.fromJson(param, ClassInfo.class);
		System.out.print("classService ci"+ ci);
		int result=cdao.updateClass(ci);
		HashMap<String,String> rm= new HashMap<String,String>();
		rm.put("result", "no");
		rm.put("msg", "수정에 실패하였습니다");
		if(result==1) {
			rm.put("result", "ok");
			rm.put("msg", "성공했습니다");
		}
		return gs.toJson(rm);
	}
	

}
