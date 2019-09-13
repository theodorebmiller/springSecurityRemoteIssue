package com.ttiinc.docSaveExample.web.security.framework.config.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author ThMiller
 *
 *	Controller used to initiate login.  The authorization must be
 *	in the HTTP call header as a basic authorization.  The user authorization token will be returned 
 *	in the header as property "ttiToken".  
 *
 */
@RestController
@RequestMapping("validate")
public class AccessValidatorRestController  {
	
	private static AccessValidatorRestController instance = null;
	private Logger logger = Logger.getLogger(this.getClass());
	
	public AccessValidatorRestController() {
		logger.debug(this.getClass().getName() + "  started");
		instance = this;
	}
	
	public static AccessValidatorRestController getInstance() {
		if (instance == null) {
			new AccessValidatorRestController();
		}
		return instance;
	}
	
	
	@RequestMapping(name="connectivity", value="/connectivity", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.OK)
    @ResponseBody
	public String returnMessage(HttpServletRequest request, 
	        HttpServletResponse response)  {
		logger.debug("Returned valid connection");
		return "connection is valid";
	}

	
	/* (non-Javadoc)
	 * @see com.ttiinc.app.httpSecurityExample.web.framework.security.SecurityService#hasRoleAccess(java.lang.String)
	 */
	@RequestMapping(name="hasRoleAccess", value="/hasRoleAccess", method = { RequestMethod.GET })
	@ResponseStatus(HttpStatus.OK)

	public String hasRoleAccess(@RequestParam("role") String role, @RequestParam("loginId") String loginId) throws SecurityException{
		 
		return "granted";
	}
}
