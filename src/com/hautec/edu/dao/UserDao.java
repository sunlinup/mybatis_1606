package com.hautec.edu.dao;

import java.util.List;

import com.hautec.edu.entity.User;

public interface UserDao {
	void svae(User obj);
	void update(User obj);
	void delete(Long id);
	User get(Long id);
	List<User> list ();
	
//	void save (User obj);
//	void update(User obj);
//	void delete(Long id);
//	User get(Long id);
//	List <User> list();
//	
	
	
	
	//泛型的写法
	
	
	
	
	
}
