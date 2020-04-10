package com.warrantytracker.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Bean
	FirebaseTokenFilter filterAuthToken() {
	return new FirebaseTokenFilter();	
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.cors()
        .and()
        .csrf()
        .disable()
        .authorizeRequests()
        .anyRequest().authenticated()
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(filterAuthToken(), UsernamePasswordAuthenticationFilter.class);
	}
	
	

}
