/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springmvccrudandsecurity.DAO;

import com.mycompany.springmvccrudandsecurity.model.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author khuye
 */
public class ProductRowMapper implements RowMapper<Product>{

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();

        product.setId(rs.getInt(1));
        product.setName(rs.getString(2));
        product.setBrand(rs.getString(3));
        product.setCategory(rs.getString(4));
        product.setPrice(rs.getDouble(5));
        product.setImgUrl(rs.getString(6));
        product.setCreatedAt(rs.getString(7));
        return product;
    }
    
}
