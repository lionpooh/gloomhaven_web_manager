package org.lionpooh.ghm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
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
                formLogin(Customizer.withDefaults());
//                formLogin(formLogin -> formLogin
//                    .loginPage("/login")
//                    .permitAll());
    }

    @Override
    public void configure(WebSecurity web)  {
        // 해당 경로는 스프링 세큐리티 무시
        web.
                ignoring().antMatchers("/resources/static/**/*");
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider()
//        auth.jdbcAuthentication().dataSource(null);
//        super.configure(auth);
    }
}
