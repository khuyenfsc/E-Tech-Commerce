/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springmvccrudandsecurity.Service;

import com.mycompany.springmvccrudandsecurity.DAO.UserDtlsDAO;
import com.mycompany.springmvccrudandsecurity.model.UserDtls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author khuye
 */
@Service
public class UserDtlsServiceImpl implements IUserDtlsService{
    @Autowired
    private UserDtlsDAO userDtlsDAO;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public boolean saveUser(UserDtls user) {
        boolean f = isExisting(user.getEmail());
        if(!f){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole("ROLE_USER");
            userDtlsDAO.saveUser(user);
            return !f;
        }
        
        System.out.println("Email already exists!");
        return !f;
    }

    @Override
    public boolean isExisting(String email) {
        return userDtlsDAO.isExisting(email);
    }

    @Override
    public UserDtls getUserById(String email) {
        return userDtlsDAO.getUserByEmail(email);
    }
    
    
}
