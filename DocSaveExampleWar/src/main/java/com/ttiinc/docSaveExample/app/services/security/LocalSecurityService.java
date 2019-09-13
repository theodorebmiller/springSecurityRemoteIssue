package com.ttiinc.docSaveExample.app.services.security;

public interface LocalSecurityService {

	boolean authorize();

	/* (non-Javadoc)
	 * @see com.ttiinc.app.httpSecurityExample.web.framework.security.SecurityService#hasRoleAccess(java.lang.String)
	 */
	boolean hasRoleAccess(String role) throws SecurityException;

}