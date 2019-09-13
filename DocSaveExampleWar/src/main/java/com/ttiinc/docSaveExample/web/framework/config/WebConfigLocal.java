package com.ttiinc.docSaveExample.web.framework.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan({"com.ttiinc.docSaveExample"})
@EnableWebMvc
@EnableMBeanExport
@EnableTransactionManagement
public class WebConfigLocal extends WebMvcConfigurerAdapter {
	private Logger log = LoggerFactory.getLogger(getClass());
	public WebConfigLocal() throws Exception{
		log.info("web config instantiated");
	}
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	// make the resources available via GET calls:
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

    }
}
