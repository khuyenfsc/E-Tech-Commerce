/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springmvccrudandsecurity.Service;

import com.mycompany.springmvccrudandsecurity.DAO.UserDtlsDAO;
import com.mycompany.springmvccrudandsecurity.model.CustomUserDetails;
import com.mycompany.springmvccrudandsecurity.model.UserDtls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author khuye
 */
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserDtlsDAO userDtlsDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDtls user = userDtlsDAO.getUserByEmail(username);
        if(user != null){
            return new CustomUserDetails(user);
        }
        
        throw new UsernameNotFoundException("User is in valid!");
    }
    
}
