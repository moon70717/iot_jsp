package com.test.iot;

import java.util.HashMap;

import com.google.gson.Gson;

public class Json {
	
	public static void main(String[]args) {
		String json="{\"id\": \"test\",\"pwd\":\"test\"}";
		Gson gs=new Gson();
		HashMap hm=gs.fromJson(json, HashMap.class);
		
		System.out.println(hm.get("id"));
		System.out.println(hm.get("pwd"));
	}
}
