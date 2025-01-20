/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springmvccrudandsecurity.model;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author khuye
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDtls {
    private int id;
    
    @NotEmpty
    private String lastName;
   
    @NotEmpty
    private String firstName;

    @Pattern(regexp = "\\w+@\\w+\\.\\w+", message = "Invalid email")
    private String email;

    @NotEmpty
    private String address;

    @NotEmpty
    private String password;

    private String role;
    
    
}
