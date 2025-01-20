/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springmvccrudandsecurity.configuration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 *
 * @author khuye
 */
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Set<String> authorities  = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        HttpSession session = request.getSession();
        
        if(authorities.contains("ROLE_ADMIN")){
            session.setAttribute("role", "admin");
            response.sendRedirect(request.getContextPath() + "/products/1");
        }else if(authorities.contains("ROLE_USER")){
            session.setAttribute("role", "user");
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
    
}
