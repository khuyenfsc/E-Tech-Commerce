/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springmvccrudandsecurity.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class Product {
    private int id;
    
    @NotEmpty
    private String name;
    
    @NotEmpty
    private String brand;
    
    @NotNull
    private String category;
    
    @Min(value = 1, message = "Price must be greater than 1$")
    @NotNull
    private Double price;
    
    private String imgUrl;
    
    private String createdAt;
    
    
}
