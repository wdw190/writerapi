package com.sound.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.httpBasic()
		        .and().authorizeRequests().antMatchers("/**/writer/**").access("#oauth2.hasScope('resource-server-read')")
		        .and().authorizeRequests().antMatchers("/**/client/**").authenticated()
				.and().authorizeRequests().anyRequest().permitAll();
	}

}
