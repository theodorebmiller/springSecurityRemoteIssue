package com.ttiinc.docSaveExample.web.framework.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * This class is a logical equivalent of application context and (along with
 * MyWebConfig) web.xml files.
 * 
 */
@Order(1)
public class WebInitializerLocal extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 
     */
    public WebInitializerLocal() {
        logger.info(getClass().getName() + " created..." + hashCode());
    }

   
    
	@Override
	protected WebApplicationContext createRootApplicationContext() {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.setConfigLocation(this.getClass().getName());
		
		applicationContext.register(getWebConfigClass());
		applicationContext.setClassLoader(WebInitializerLocal.class.getClassLoader());
		return applicationContext;
	}

    /**
	 * These config classes have to be root config classes, not servlet config
	 * classes.The main sticking point is Metric configuration - it has to be in
	 * the root context to be visible by both the application and the admin
	 * servlet.
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {getWebConfigClass()};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { };
    }

    @Override
    protected String[] getServletMappings() {        
		//return new String[] { "/" + WebConfig.urlIdentifier + "/*" };
		return new String[] { "/*" };
    }
    

	@SuppressWarnings("rawtypes")
	public Class getWebConfigClass() {
		
		return WebConfigLocal.class;
	}
}