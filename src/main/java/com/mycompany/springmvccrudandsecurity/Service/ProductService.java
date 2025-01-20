/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springmvccrudandsecurity.Service;

import com.mycompany.springmvccrudandsecurity.DAO.ProductDAO;
import com.mycompany.springmvccrudandsecurity.model.Product;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author khuye
 */
@Service
public class ProductService implements IProductService{
    @Autowired
    private ProductDAO productDAO;
    
    @Autowired
    private StoreFileService storeFileService;
    
    @Override
    public List<Product> getAllProducts(){
        List<Product> products = productDAO.getAllProducts();
        return products;
    }

    @Override
    public int getNumberOfPages() {
        return productDAO.getNumberOfPages();
    }

    @Override
    public int getFirstEndPage(int currentPage, int numberOfPages) {
        int firstEndPage;
        if(numberOfPages - currentPage > 3){
            firstEndPage = currentPage + 1;
        }else{
            firstEndPage = (currentPage + 1 <= numberOfPages)?(currentPage + 1):numberOfPages;
        }
        
        return firstEndPage;
    }

    @Override
    public int getSecondStartPage(int currentPage, int numberOfPages, int firstEndPage) {
        int secondStartPage;
        if(numberOfPages - currentPage > 3){
            secondStartPage = numberOfPages - 1;
        }else{
            secondStartPage = (firstEndPage + 1 <= numberOfPages)?(firstEndPage + 1):(numberOfPages + 1);
        }
        
        return secondStartPage;
    }

    @Override
    public List<Product> findPaginated(int currentPageIndex) {
        return productDAO.requestProducts(currentPageIndex);
    }

    @Override
    public int getLastId() {
        return productDAO.getLastId();
    }
    
    
    public void updateImgUrl(String imgUrl, int id){
        productDAO.updateImgUrl(imgUrl, id);
    }
    
    @Override
    public boolean save(Product product, MultipartFile file) {
        
        
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            product.setCreatedAt(LocalDate.now().format(formatter));
            productDAO.save(product);
            
            String fileName = file.getOriginalFilename();
            String id = getLastId() + "";
            String extFile = fileName.substring(fileName.lastIndexOf("."));
            storeFileService.store(file, id, extFile);
            updateImgUrl(id + extFile, getLastId());
        }catch(Exception e){
            return false;
        }
        
        return true;
    }

    @Override
    public Product getProductById(int id) {
        Product product = productDAO.getProductById(id);
        return product;
    }

    @Override
    public boolean editProduct(Product productEdit, MultipartFile file) {
        try{
            productDAO.editProduct(productEdit);
            if(!file.isEmpty()){
                String oldImgUrl = productDAO.getProductById(productEdit.getId()).getImgUrl();
                storeFileService.deleteFile(oldImgUrl);
                
                String fileName = file.getOriginalFilename();
                String id = productEdit.getId() + "";
                System.out.println(fileName);
                String extFile = fileName.substring(fileName.lastIndexOf("."));
                storeFileService.store(file, id, extFile);
                updateImgUrl(id + extFile, productEdit.getId());
            }
        }catch(Exception e){
            return false;
        }

        return true;
    }

    @Override
    public boolean deleteProductById(int id) {
        try {
            productDAO.deleteProductById(id);
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
    
    
}
