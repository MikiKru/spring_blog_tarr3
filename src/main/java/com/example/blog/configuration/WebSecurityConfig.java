package com.example.blog.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/addPost").hasAnyAuthority("ROLE_USER","ROLE_ADMIN")
                .antMatchers("/posts*").hasAnyAuthority("ROLE_USER","ROLE_ADMIN")
                .anyRequest().permitAll()
                    .and()
                .csrf().disable()
                .formLogin().loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .loginProcessingUrl("/login_process")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/")
                    .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");
    }
}
