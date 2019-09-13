package com.ttiinc.docSaveExample.web.security.framework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(
  prePostEnabled = true, 
  securedEnabled = true, 
  jsr250Enabled = true)
@Order(2)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

	@Autowired
	private ApplicationContext context;
	
	
	public MethodSecurityConfig() {
		super();
	}
	
	
}
