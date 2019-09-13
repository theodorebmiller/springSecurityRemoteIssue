package com.ttiinc.docSaveExample.web.remoteService.docSave;

import com.ttiinc.docSaveExample.commons.service.docSave.DocSaveService;

public interface DocSaveServiceRemote extends DocSaveService {

	public long getUniqueRemoteId();
}
