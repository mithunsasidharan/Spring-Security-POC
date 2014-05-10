package com.tracker.web.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

import com.tracker.business.logic.TrackerBimBusinessLogic;
import com.tracker.business.model.User;

public class WelcomeController extends ParameterizableViewController {
	private static final Logger log = Logger.getLogger(WelcomeController.class);


	private TrackerBimBusinessLogic bimBusinessLogic;

	public TrackerBimBusinessLogic getBimBusinessLogic() {
		return bimBusinessLogic;
	}
	public void setBimBusinessLogic(TrackerBimBusinessLogic bimBusinessLogic) {
		this.bimBusinessLogic = bimBusinessLogic;
	}

	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map data = new HashMap();
		UsernamePasswordAuthenticationToken context = (UsernamePasswordAuthenticationToken)request.getUserPrincipal();
		User loggedUser = (User)context.getPrincipal();

		try{

			data.put("user", loggedUser);

			return new ModelAndView(getViewName(), data);

		}catch(Exception e){
			log.error("ERROR: Cannot load User ", e);
			throw e;
		}

	}


}
