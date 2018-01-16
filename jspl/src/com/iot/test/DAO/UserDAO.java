package com.iot.test.DAO;

import java.util.List;

import com.iot.test.vo.UserInfo;

public interface UserDAO {


	public List<UserInfo> selectUserList(UserInfo ui);
	public UserInfo setUser(UserInfo ui);
	public int insertUser(UserInfo ui);
	public int updateUser(UserInfo ui);
	public int deleteUser(UserInfo ui);
}
