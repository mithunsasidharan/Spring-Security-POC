package com.tracker.business.logic;

import org.apache.log4j.Logger;

import com.tracker.business.logic.user.UserLogic;
import com.tracker.business.model.User;

public class TrackerBimBusinessLogicImpl implements TrackerBimBusinessLogic{

	
	private final static Logger log = Logger.getLogger(TrackerBimBusinessLogicImpl.class);
	 
    private UserLogic userLogic;
    
    
	public UserLogic getUserLogic() {
		return userLogic;
	}


	public void setUserLogic(UserLogic userLogic) {
		this.userLogic = userLogic;
	}


	//Loads user detail for editing
	public User loadUser(String username) {
		return userLogic.loadUser(username);
	}

}
