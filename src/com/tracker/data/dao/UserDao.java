package com.tracker.data.dao;

import com.tracker.business.model.User;

public interface UserDao {

	 User loadUser(String username);
	
}
