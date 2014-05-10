package com.tracker.web.security;

import org.springframework.security.core.GrantedAuthority;

public class AdminGrantedAuthority implements GrantedAuthority {
	private String auth;
	
	public AdminGrantedAuthority(String auth) {
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
