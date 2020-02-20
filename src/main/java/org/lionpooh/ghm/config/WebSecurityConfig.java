package org.lionpooh.ghm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests(authorizeRequests -> authorizeRequests
                    .antMatchers("/images/**", "/js/**", "/css/**").permitAll()
                    .antMatchers("/join", "/verify").permitAll()
                    .anyRequest().authenticated()).
                formLogin(formLogin -> formLogin
                    .loginPage("/login")
                    .permitAll());
    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.
//                ignoring().antMatchers("/resource/static/**/*");
//    }
}
