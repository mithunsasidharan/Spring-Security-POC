package com.tracker.web.security;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import com.tracker.business.logic.TrackerBimBusinessLogic;
import com.tracker.business.model.User;

public class AdminURLDecisionVoter implements AccessDecisionVoter {

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
		return ACCESS_ABSTAIN;
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
