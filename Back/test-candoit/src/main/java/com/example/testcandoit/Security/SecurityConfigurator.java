package com.example.testcandoit.Security;

import com.example.testcandoit.Security.jwt.JwtAuthenticationEntryPoint;
import com.example.testcandoit.Security.jwt.JwtRequestFilter;
import com.example.testcandoit.service.Impl.CustomeUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
public class SecurityConfigurator extends WebSecurityConfigurerAdapter {
    @Autowired
    CustomeUserDetailsService customeUserDetailsService;
    @Autowired
    JwtRequestFilter jwtRequestFilter;
    @Autowired
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        super.configure(auth);
        auth.userDetailsService(customeUserDetailsService);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Enable CORS and disable CSRF
        http.cors().and().csrf().disable()
                // Set session management to stateless
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // Set unauthorized requests exception handler
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                // Set permissions on endpoints
                .authorizeRequests()
                // Public endpoints
                .antMatchers("/auth/**").permitAll()
                // Private endpoints
                .anyRequest().authenticated()
                .and()
                // Add JWT Token Filter
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
