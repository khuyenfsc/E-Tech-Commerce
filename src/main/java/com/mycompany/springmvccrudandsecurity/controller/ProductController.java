/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springmvccrudandsecurity.controller;

import com.mycompany.springmvccrudandsecurity.Service.IProductService;
import com.mycompany.springmvccrudandsecurity.model.Product;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author khuye
 */
@Controller
public class ProductController {
    @Autowired
    private IProductService productService;
    
    
    @GetMapping("/products/{currentPage}")
    public String viewStaticProductsPage(@PathVariable(value = "currentPage") int currentPage,Model model, HttpServletRequest request){
        int numberOfPages = productService.getNumberOfPages();
        int firstEndPage = productService.getFirstEndPage(currentPage, numberOfPages);
        int secondStartPag = productService.getSecondStartPage(currentPage, numberOfPages, firstEndPage);
  
        if(currentPage > numberOfPages){
            return "redirect:/products/" + numberOfPages;
        }
        
        List<Product> products = productService.findPaginated(currentPage - 1);
        model.addAttribute("currentPage", currentPage);      
        model.addAttribute("products", products);
        model.addAttribute("numberOfPages", numberOfPages);
        model.addAttribute("firstEndPage", firstEndPage);
        model.addAttribute("secondStartPage", secondStartPag);
        
        System.out.println(((CsrfToken)request.getAttribute("_csrf")).getToken());
        return "products-page.jsp";
    }
    
    @GetMapping("/products/add")
    public String viewAddPage(Model model){
        model.addAttribute("product", new Product());
        return "add-product.jsp";
    }
    
    @PostMapping("/products/add")
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model, @RequestParam("file") MultipartFile file){
        
        if(bindingResult.hasErrors()){
            List<FieldError> errors = bindingResult.getFieldErrors();
            model.addAttribute("fieldErrors", errors.stream().collect(Collectors.toMap(e -> e.getField(), e -> e.getDefaultMessage())));
            System.out.println("Loi field");
            return "add-product.jsp";
            
        }else if(file.getOriginalFilename().equals("")){
            model.addAttribute("fileUploadError", (Object)"Select a file to upload");
            System.out.println("Loi file");
            return "add-product.jsp";
        }
        
        if(!productService.save(product, file)){
            return "add-product-failed.jsp";
        }
        
        return "redirect:/products/1";
    }
    
    @GetMapping("no-javascript-error")
    public String viewNoJsPage(){
        return "no-js-page.jsp";
    }
    
    @GetMapping("/products/edit/id={idProduct}")
    public String viewEditPage(@PathVariable(value = "idProduct") int idProduct, Model model){
        Product productEdit = productService.getProductById(idProduct);
        if(productEdit == null){
            return "error-id-not-found.jsp";
        }
        
        model.addAttribute("productEdit", productEdit);
        return "edit-product.jsp";
    }
    
    @PostMapping("/products/edit/id={idProduct}")
    public String editProduct(@Valid @ModelAttribute("productEdit") Product productEdit,@PathVariable(value="idProduct") int idProduct , BindingResult bindingResult, @RequestParam("file") MultipartFile file, Model model){
        if(bindingResult.hasErrors()){
            return "edit-product.jsp";
        }
        
        if(!productService.editProduct(productEdit, file)){
            return "edit-product-failed.jsp";
        }
        
        return "redirect:/products/1";

    } 
    
    @PostMapping("/products/delete/{idProduct}")
    public String deleteProduct(@PathVariable(value = "idProduct") int id, HttpServletRequest request){
        System.out.println("Deleting!!");
        Product product = productService.getProductById(id);
        if(product == null){
            return "error-id-not-found.jsp";
        }
        
        if(!productService.deleteProductById(id)){
            return "delete-product-failed.jsp";
        }
        
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }
}
