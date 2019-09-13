package com.ttiinc.docSaveExample.web.security.framework.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.inMemoryAuthentication().withUser("myUser").password("123456").roles("internetUsers");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").authenticated().and().formLogin();
		http.csrf().disable();
		
	}
	/**
	 * Method invoked by Spring after the bean is fully constructed. This insures
	 * the super class beans are ready for use when configuring the filter.
	 * 
	 * @throws Exception
	 */
	@PostConstruct
	public void postConstruct() throws Exception {
		
	}
}

