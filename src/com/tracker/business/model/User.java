package com.tracker.business.model;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {

	private long userId;
	private long roleId;
	private char status;
	private String firstName;
	private String lastName;
	private String email;
	private long projectId;
	private String password;
	private String username;
	private List authority;

	// Define roles
	public static final int ROLE_SUPER_ADMIN = 1;
	public static final int ROLE_ADMIN = 2;
	public static final int ROLE_USER = 3;

	// Define user statuses
	public static final char STATUS_ACTIVE = 'A';
	public static final char STATUS_INACTIVE = 'I';
	public static final char STATUS_DELETED = 'D';
	public static final char STATUS_LOCKED = 'X';

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public List getAuthorities() {
		return authority;
	}

	public void setAuthorities(List authority) {
		this.authority = authority;
	}

	public boolean isCredentialsNonExpired(){
		return true;
	}

	public boolean isAccountNonLocked() {
		return this.getStatus()!=User.STATUS_LOCKED ? true : false;
	}

	public boolean isEnabled() {
		return this.getStatus()==User.STATUS_ACTIVE ? true : false;
	}

	public boolean isAccountNonExpired() {
		return true;
	}
}
