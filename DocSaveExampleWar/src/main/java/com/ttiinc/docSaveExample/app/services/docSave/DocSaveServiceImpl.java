package com.ttiinc.docSaveExample.app.services.docSave;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.ttiinc.docSaveExample.commons.service.docSave.DocSaveService;

@Service("docSaveService")
public class DocSaveServiceImpl implements DocSaveService {

	
	@Override
	@Secured("'ROLE_internetUsers')")
	public String testMethodSecurity(String doc) {
		return doc;
	}


}
