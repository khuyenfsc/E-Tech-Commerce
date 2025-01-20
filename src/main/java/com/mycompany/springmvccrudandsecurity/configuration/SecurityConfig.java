/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springmvccrudandsecurity.configuration;

import com.mycompany.springmvccrudandsecurity.Service.UserDetailsServiceImpl;
import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.HttpMethod;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionFixationProtectionStrategy;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.server.authentication.SessionLimit;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.web.filter.DelegatingFilterProxy;

/**
 *
 * @author khuye
 */
@Configuration
@EnableWebSecurity
//@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public UserDetailsService userDetailsServiceImpl(){
        return new UserDetailsServiceImpl();
    }
    
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthProvider = new DaoAuthenticationProvider();
        daoAuthProvider.setPasswordEncoder(passwordEncoder());
        daoAuthProvider.setUserDetailsService(userDetailsServiceImpl());
        return daoAuthProvider;
    }
   
    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler(){
        return new CustomAuthenticationSuccessHandler();
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        SecurityContextRepository securityContextRepository = new HttpSessionSecurityContextRepository();    
        http.authorizeHttpRequests((auth) -> 
            auth
                .requestMatchers("/login", "/register").permitAll()                                 .requestMatchers(new RegexRequestMatcher("/products/\\d+", "GET")).hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .requestMatchers("/users-management", "/products/**").hasAuthority("ROLE_ADMIN")
                .requestMatchers("/").permitAll()
                .anyRequest().authenticated()
        )
                .formLogin((FormLoginConfigurer<HttpSecurity> formLogin) -> {
                    formLogin.loginPage("/login")
                            .usernameParameter("email")
                            .successHandler(authenticationSuccessHandler())
                            .permitAll();
        }).logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").permitAll())
                .authenticationProvider(daoAuthenticationProvider()).securityContext(context -> context.securityContextRepository(securityContextRepository))
                .rememberMe(remember -> remember.alwaysRemember(true).tokenValiditySeconds(60*60))
                .sessionManagement(session -> session.sessionAuthenticationErrorUrl("/error").maximumSessions(1).maxSessionsPreventsLogin(true))
                ;   

        return http.build();
               
    }   
    //maxSessionsPreventsLogin chan tao ra session thu hai
    
//    @Bean(name = "aspringSecurityFilterChain")
//    public Filter filterChain(HttpSecurity http) throws Exception {
//
//        SecurityFilterChain securityFilterChain = http.authorizeHttpRequests((auth) -> 
//            auth
//                .requestMatchers("/login", "/register").permitAll()                             
//                .requestMatchers("/users-management", "/products/**").hasAuthority("ROLE_ADMIN")
//                .requestMatchers(new RegexRequestMatcher("/products/\\d+", "GET")).hasAuthority("ROLE_USER")
//                .anyRequest().authenticated()
//        )
//                .formLogin(formLogin -> formLogin.loginPage("/login")
//                                                 .usernameParameter("email")
//                                                 .defaultSuccessUrl("/", true)
//                                                 .permitAll()
//                )
//                .authenticationProvider(daoAuthenticationProvider()).httpBasic(withDefaults()).build();   
//        
//        return new FilterChainProxy(securityFilterChain);
//               
//    } CUSTOM TEN THEO Y THICH
    
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web) -> web.ignoring().requestMatchers("/resources/**");
    }

}
