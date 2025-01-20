/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springmvccrudandsecurity.controller;

import com.mycompany.springmvccrudandsecurity.model.UserDtls;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.mycompany.springmvccrudandsecurity.Service.IUserDtlsService;
import com.mycompany.springmvccrudandsecurity.model.Product;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author khuye
 */
@Controller
public class UserController {
    @Autowired
    private IUserDtlsService userDtlsServiceImpl;
    
    @GetMapping("/")
    public String viewHomePage(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("role") == null){
            
            return "unauthenticated-home.jsp";
        }
        UserDtls user = userDtlsServiceImpl.getUserById(request.getUserPrincipal().getName());
        model.addAttribute("firstName", user.getFirstName());
        return "home.jsp";
        
    }
    
    @GetMapping("/login")
    public String viewLoginPage(Model model){
        model.addAttribute("user", new UserDtls());
        return "login.jsp";
    }
    
    @GetMapping("/register")
    public String viewRegisterPage(Model model){
        model.addAttribute("user", new UserDtls());
        return "register.jsp";
    }
    
    @PostMapping("/register")
    public String registerANewUser(@Valid @ModelAttribute("user") UserDtls user, BindingResult bindingResult, Model model, HttpSession session){
        if(bindingResult.hasErrors()){
            List<FieldError> errors = bindingResult.getFieldErrors();
            model.addAttribute("fieldErrors", errors.stream().collect(Collectors.toMap(e -> e.getField(), e -> e.getDefaultMessage())));
            
            return "register.jsp";
            
        }
        
        Boolean f = userDtlsServiceImpl.saveUser(user);
        session.setAttribute("result", f);
        return "redirect:/register";
    }
    
    @GetMapping("/users/{currentPage}")
    public String viewUsers(@PathVariable(value = "currentPage") int currentPage,Model model, HttpServletRequest request){
        
        
        return "users-page.jsp";
    }
    
    
}
