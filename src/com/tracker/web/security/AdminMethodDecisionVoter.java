package com.tracker.web.security;

import java.util.Collection;
import org.aopalliance.intercept.MethodInvocation;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;

import com.tracker.business.logic.TrackerBimBusinessLogic;
import com.tracker.business.model.User;

public class AdminMethodDecisionVoter implements AccessDecisionVoter, ApplicationContextAware {
	private ApplicationContext applicationContext;
	private TrackerBimBusinessLogic bimBusinessLogic;
	private String rolePrefix;

	public boolean supports(ConfigAttribute arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean supports(Class arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	public int vote(Authentication authentication, Object secureObject, Collection config) {
		TrackerBimBusinessLogic bimBusinessLogic = (TrackerBimBusinessLogic)applicationContext.getBean("bimBusinessLogic");
		MethodInvocation invocation = (MethodInvocation) secureObject;
		User user = (User)authentication.getPrincipal();
		return ACCESS_ABSTAIN;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public TrackerBimBusinessLogic getBimBusinessLogic() {
		return bimBusinessLogic;
	}

	public void setBimBusinessLogic(TrackerBimBusinessLogic bimBusinessLogic) {
		this.bimBusinessLogic = bimBusinessLogic;
	}

	public String getRolePrefix() {
		return rolePrefix;
	}

	public void setRolePrefix(String rolePrefix) {
		this.rolePrefix = rolePrefix;
	}

}
