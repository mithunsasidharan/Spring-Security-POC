package com.tracker.business.logic.user;

import com.tracker.business.model.User;
import com.tracker.data.dao.UserDao;

public class UserLogic {
	
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User loadUser(String username) {		
		return userDao.loadUser(username);
	}

}
