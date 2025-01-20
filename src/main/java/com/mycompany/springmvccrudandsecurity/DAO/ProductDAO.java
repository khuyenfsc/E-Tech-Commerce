/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springmvccrudandsecurity.DAO;
import com.mycompany.springmvccrudandsecurity.model.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author khuye
 */
@Repository
public class ProductDAO {
    JdbcTemplate template;
    final int pageSize = 3;
    
    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }
    
    public List<Product> getAllProducts(){
        String sql = "SELECT * FROM products";
        return template.query(sql, new RowMapper<Product>(){
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
            
        });
        
    }
    
    public int getNumberOfProducts(){
        String sql = "SELECT COUNT(*) FROM products";
        int numberOfProducts = template.queryForObject(sql, Integer.class);
        return numberOfProducts;
    }
    
    public int getNumberOfPages(){
        int numberOfProducts = getNumberOfProducts();
        int numberOfPages = numberOfProducts/pageSize;    
        if(numberOfProducts % 3 != 0){
            numberOfPages++;
        }
        
        return numberOfPages;
    }
    
    public List<Product> requestProducts(int currentPageIndex){
        String sql = "SELECT * FROM products LIMIT " + currentPageIndex*pageSize + "," + pageSize;
//        Product[] requestedProducts = template.queryForObject(sql, Product[].class);
//        return Arrays.asList(requestedProducts);
        return template.query(sql, new RowMapper<Product>(){
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

        });
    }
    
    public int getLastId(){
        String sql = "SELECT MAX(product_id) FROM products";
        Integer lastId = template.queryForObject(sql, Integer.class);
        if(lastId == null) return 0;
        return lastId;
    }
    
    
    public void updateImgUrl(String imgUrl, int id){
        String sql = "UPDATE products SET img_url = '" + imgUrl + "'" + "WHERE product_id = " + id;
        template.execute(sql);              
    }
    
    public void save(Product product){
        String sql = "INSERT INTO products(product_name, brand, category, price, img_url, created_at) "
                + "VALUES('" + product.getName() + "', "
                + "'" + product.getBrand() + "', "
                + "'" + product.getCategory() + "', "
                + product.getPrice() + ", "
                + "'" + product.getImgUrl() + "', "
                + "'" + product.getCreatedAt() + "')";
        System.out.println(sql);
        template.execute(sql);
        
    }
    
    public Product getProductById(int id){
        String sql = "SELECT * FROM products WHERE product_id = " + id;
        Product product = template.queryForObject(sql, new ProductRowMapper());
        return product;
    }
    
    public void editProduct(Product productEdit){
        int id = productEdit.getId();
        String sql = "UPDATE products SET "
                + "product_name = '" + productEdit.getName() + "', "
                + "brand = '" + productEdit.getBrand() + "', "
                + "category = '" + productEdit.getCategory() + "', "
                + "price = " + productEdit.getPrice() + " "
                + "WHERE product_id = " + id;
        System.out.println(sql);
        template.execute(sql);
    }
    
    public void deleteProductById(int id){
        String sql = "DELETE FROM products WHERE product_id = " + id;
        System.out.println(sql);
        template.execute(sql);
    }
}
