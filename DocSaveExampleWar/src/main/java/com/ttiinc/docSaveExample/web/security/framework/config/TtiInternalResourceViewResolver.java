package com.ttiinc.docSaveExample.web.security.framework.config;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

public class TtiInternalResourceViewResolver extends InternalResourceViewResolver {
	protected Logger logger = Logger.getLogger(getClass());

	/**
	 * Sets the default {@link #setViewClass view class} to {@link #requiredViewClass}:
	 * by default {@link InternalResourceView}, or {@link JstlView} if the JSTL API
	 * is present.
	 */
	public TtiInternalResourceViewResolver() {
		super();

	}

	/**
	 * A convenience constructor that allows for specifying {@link #setPrefix prefix}
	 * and {@link #setSuffix suffix} as constructor arguments.
	 * @param prefix the prefix that gets prepended to view names when building a URL
	 * @param suffix the suffix that gets appended to view names when building a URL
	 * @since 4.3
	 */
	public TtiInternalResourceViewResolver(String prefix, String suffix) {
		super(prefix, suffix);
	}

	/**
	 * This resolver requires {@link InternalResourceView}.
	 */
	@Override
	protected Class<?> requiredViewClass() {
		return InternalResourceView.class;
	}



	@Override
	protected AbstractUrlBasedView buildView(String viewName) throws Exception {
		
		logger.debug(viewName + " ~~ ServletContext Class: " + this.getServletContext().getClass().getName());
		
		InternalResourceView view = (InternalResourceView) super.buildView(viewName);
		return view;
	}
}
