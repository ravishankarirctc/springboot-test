package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@EnableResourceServer
//@Order(value = 0)
@Configuration
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
public class GatewayConfiguration extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(final HttpSecurity http) throws Exception {
	http.authorizeRequests()
          .antMatchers("/api/v1/oauth/**")
          .permitAll()
          .antMatchers("/**")
	  .authenticated();
    }
}