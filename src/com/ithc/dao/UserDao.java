package com.ithc.dao;

import java.util.List;

import com.ithc.bean.User;

public interface UserDao {

	User login(User user, String state);

	User registerName(String user_code);

	void register(User user);

	User findByName(String user_code);
	//校验密码
	User checkPassword(String user_code, String newuser_password);
	//修改密码
	void password(User user);
	//查询所有
	List<User> findBllAll();

	

}
