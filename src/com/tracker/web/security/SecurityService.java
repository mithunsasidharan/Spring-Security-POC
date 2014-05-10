package com.tracker.web.security;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.tracker.business.logic.TrackerBimBusinessLogic;
import com.tracker.business.model.User;

public class SecurityService implements UserDetailsService {
	private final static Logger log = Logger.getLogger(SecurityService.class);
	private TrackerBimBusinessLogic trackerbimBusinessLogic;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {

		String errMsg = "User with username: " + username;

		User user = trackerbimBusinessLogic.loadUser(username);
		if(user==null) {
			log.error("User with username: " + username + " not found");
		}
		return user;
	}

	public TrackerBimBusinessLogic getBimBusinessLogic() {
		return trackerbimBusinessLogic;
	}

	public void setBimBusinessLogic(TrackerBimBusinessLogic trackerbimBusinessLogic) {
		this.trackerbimBusinessLogic = trackerbimBusinessLogic;
	}
}
