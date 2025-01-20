<%-- 
    Document   : home
    Created on : Dec 28, 2024, 5:27:52 PM
    Author     : khuye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        
        <noscript>
            <style>
              html {
                display: none;
              }
            </style>
            <meta http-equiv="refresh" content="0; url=${pageContext.request.contextPath}/no-javascript-error" />
         </noscript>

    </head>
    <body class="bg-secondarybg-gradient" style="">
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">

              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                  <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/products/1">Products</a>
                  </li>
                    

                </ul>
              </div>
            </div>
            <div>

                    
                <a type="button" class="btn btn-outline-dark" href="${pageContext.request.contextPath}/login">Login</a>
          </nav>
        
                <div style="display: flex; justify-content: center; align-items: center; height: 100vh; "">
                    <p style="font-size: 3rem; ">Login to buy products</p>
                </div>
        
        
        
    </body>
</html>
