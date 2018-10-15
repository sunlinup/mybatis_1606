package com.hautec.edu.entity;

import java.util.List;

public interface UserMapper {
	void insert(User user);
	void update(User user);
	void delete(Long id);
	User getUserById(Long id);
	List<User> list ();
}
