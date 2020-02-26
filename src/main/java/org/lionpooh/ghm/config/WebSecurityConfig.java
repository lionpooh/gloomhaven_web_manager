package org.lionpooh.ghm.config;

import lombok.extern.slf4j.Slf4j;
import org.lionpooh.ghm.service.GhmUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Slf4j
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final GhmUserDetailsService userDetailsService;
    private final AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    public WebSecurityConfig(GhmUserDetailsService userDetailsService, AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.userDetailsService = userDetailsService;
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests(authorizeRequests -> authorizeRequests
//                    아래 'ignoring'을 통해서 해당 리소스 패스 모두 허용
//                    .antMatchers("/images/**", "/js/**", "/css/**").permitAll()
                    .antMatchers("/member/join", "/member/verify", "/api/v1/**").permitAll()
                    .anyRequest().authenticated()).
//                formLogin();
                formLogin(formLogin -> formLogin
                    .loginPage("/member/login")
                    .loginProcessingUrl("/member/login/process")
                    .usernameParameter("email")
                    .passwordParameter("password")
//                    .failureUrl("/member/login?error=true")
                    .successHandler(authenticationSuccessHandler)
                    .permitAll()).csrf().disable().
                logout(logout -> logout
//                    .logoutUrl("/member/logout")
//                    .logoutSuccessUrl("/member/login")
                    .permitAll()).csrf().disable();
    }

    @Override
    public void configure(WebSecurity web)  {
//      해당 경로는 스프링 세큐리티 무시
        web.
                ignoring().antMatchers("/resources/static/**/*");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder)    {
        authenticationManagerBuilder.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

}
