/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.springmvccrudandsecurity.Service;

import com.mycompany.springmvccrudandsecurity.model.UserDtls;

/**
 *
 * @author khuye
 */
public interface IUserDtlsService {
    boolean saveUser(UserDtls user);
    boolean isExisting(String email);
    UserDtls getUserById(String email);
}
