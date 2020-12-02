package com.ump.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(/*HttpSecurity httpSecurity,*/ WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/", "/**");
        super.configure(web);
        //httpSecurity.headers().frameOptions().disable();
    }

}
