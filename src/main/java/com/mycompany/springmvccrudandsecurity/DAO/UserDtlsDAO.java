/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springmvccrudandsecurity.DAO;

import com.mycompany.springmvccrudandsecurity.model.UserDtls;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author khuye
 */
@Repository
public class UserDtlsDAO {
    JdbcTemplate template;
    
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    
    public void saveUser(UserDtls user){
        StringBuffer sb = new StringBuffer("INSERT INTO user_dtls(first_name, last_name, email, address, password, role) VALUES(");
        String quote = "'";
        String endQuoteComma = "',";
        String endingBracket = ")";
        sb.append(quote);
        sb.append(user.getFirstName());
        sb.append(endQuoteComma);
        sb.append(quote);
        sb.append(user.getLastName());
        sb.append(endQuoteComma);
        sb.append(quote);
        sb.append(user.getEmail());
        sb.append(endQuoteComma);
        sb.append(quote);
        sb.append(user.getAddress());
        sb.append(endQuoteComma);
        sb.append(quote);
        sb.append(user.getPassword());
        sb.append(endQuoteComma);
        sb.append(quote);
        sb.append(user.getRole());
        sb.append(quote);
        sb.append(endingBracket);
        
        System.out.println(sb.toString());
        template.execute(sb.toString());
    }
    
    public UserDtls getUserByEmail(String email){
        StringBuffer sb = new StringBuffer("SELECT * FROM user_dtls WHERE email = ");
        String quote = "'";
        sb.append(quote);
        sb.append(email);
        sb.append(quote);
        
         System.out.println(sb.toString());
        
        UserDtls user = null;
        try {
            user = template.queryForObject(sb.toString(), new RowMapper<UserDtls>(){
                @Override
                public UserDtls mapRow(ResultSet rs, int rowNum) throws SQLException {
                    UserDtls user = new UserDtls();
                    user.setId(rs.getInt(1));
                    user.setFirstName(rs.getString(2));
                    user.setLastName(rs.getString(3));
                    user.setEmail(rs.getString(4));
                    user.setAddress(rs.getString(5));
                    user.setPassword(rs.getString(6));
                    user.setRole(rs.getString(7));

                    return user;
                }

            });
        } catch (Exception e) {
            
        }
        
        return user;
        
    }
    
    public boolean isExisting(String email){
        UserDtls user = getUserByEmail(email);
        return user != null;
    }
}
