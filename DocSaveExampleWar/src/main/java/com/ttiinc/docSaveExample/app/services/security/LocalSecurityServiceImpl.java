package com.ttiinc.docSaveExample.app.services.security;

import org.springframework.stereotype.Service;

@Service("localSecurityService")
public class LocalSecurityServiceImpl  implements LocalSecurityService {

	@Override
	public boolean authorize() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.ttiinc.app.httpSecurityExample.web.framework.security.SecurityService#hasRoleAccess(java.lang.String)
	 */
	@Override
	public boolean hasRoleAccess(String role) throws SecurityException{
		 
		return true;
	}

}
