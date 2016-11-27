package com.aljumaro.techtest.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Date 13/11/2016
 * @Time 10:27
 * @Author Juanma
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private AccountAuthenticationProvider accountAuthenticationProvider;

    public void setAccountAuthenticationProvider(
            AccountAuthenticationProvider accountAuthenticationProvider) {
        this.accountAuthenticationProvider = accountAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) {
        authenticationManagerBuilder.authenticationProvider(accountAuthenticationProvider);
    }

    @Configuration
    public static class ApiWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // @formatter:off

            http
              .csrf().disable()
                 .authorizeRequests()
                    .antMatchers("/api/**").hasRole("USER")
                    .antMatchers("/app-console/**").hasRole("SYSADMIN")
            .and()
            .httpBasic()
            .and()
            .sessionManagement()
              .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

            // @formatter:on
        }
    }
}
