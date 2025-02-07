/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.springmvccrudandsecurity.Service;
import com.mycompany.springmvccrudandsecurity.model.Product;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author khuye
 */
@Service
public interface IProductService {
    List<Product> getAllProducts();
    int getNumberOfPages();
    int getFirstEndPage(int currentPage, int numberOfPages);
    int getSecondStartPage(int currentPage, int numberOfPages, int firstEndPage);
    List<Product> findPaginated(int currentPageIndex);
    int getLastId();
    boolean save(Product product, MultipartFile file);
    Product getProductById(int id);
    boolean editProduct(Product productEdit, MultipartFile file);
    boolean deleteProductById(int id);
}
