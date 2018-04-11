package com.ithc.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.ithc.bean.User;
@SuppressWarnings("all")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	@Override
	public User login(User user, String state) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code = ? and user_password = ? and user_state = ?", user.getUser_code(),user.getUser_password(),state);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public User registerName(String user_code) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code = ?", user_code);
		
		if(list != null&& list.size()>0){
			return list.get(0);
		}
		return null;
	}
	//注册
	@Override
	public void register(User user) {
		this.getHibernateTemplate().save(user);
		
	}

	@Override
	public User findByName(String user_code) {
		
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code = ?", user_code);
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
		
	}

	@Override
	public User checkPassword(String user_code, String newuser_password) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code= ? and user_password=?", user_code,newuser_password);
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void password(User user) {
		this.getHibernateTemplate().update(user);
		
	}

	@Override
	public List<User> findBllAll() {
		
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User");
		if(list !=null && list.size()>0 ){
			return list;
		}
		return null;
	}

}
