package com.ttiinc.docSaveExample.web.remoteService.docSave;

import org.springframework.context.annotation.Bean;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.stereotype.Component;

@Component(value = "docSaveServiceHttpRemoteFacade")
public class DocSaveServiceHttpRemoteImpl extends DocSaveServiceRemoteBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 654598539535894584L;

	private static DocSaveServiceHttpRemoteImpl service = null;

	public static String CLASS_NAME = null;

	public DocSaveServiceHttpRemoteImpl() {
		CLASS_NAME = this.getClass().getSimpleName();
		if (service == null) {
			service = this;
		}
	}

	@Bean(name = "/DocSaveServiceHttpFacade")
	public HttpInvokerServiceExporter DocSaveServiceHttpRemoteFacade() {
		HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
		exporter.setService(this);
		exporter.setServiceInterface(DocSaveServiceRemote.class);
		return exporter;
	}

	@Override
	public long getUniqueRemoteId() {
		// TODO Auto-generated method stub
		return serialVersionUID;
	}

}
