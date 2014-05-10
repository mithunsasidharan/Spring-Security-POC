package com.tracker.business.model;

import org.springframework.security.core.GrantedAuthority;

public class UserGrantedAuthority implements GrantedAuthority {
	private String auth;
	
	public UserGrantedAuthority(String auth) {
		this.auth = auth;
	}

	public String getAuthority() {
		// TODO Auto-generated method stub
		return auth;
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
