package com.ttiinc.docSaveExample.web.remoteService.docSave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;

import com.ttiinc.docSaveExample.commons.service.docSave.DocSaveService;

public abstract class DocSaveServiceRemoteBase implements DocSaveServiceRemote {

	@Autowired
	@Qualifier("docSaveService")
	protected DocSaveService docSaveService;
	
	@Override
	@Secured("Role_internetUsers")
	public String testMethodSecurity(String doc) {
		return docSaveService.testMethodSecurity(doc);
	}


}
