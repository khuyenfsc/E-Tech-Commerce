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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home.css" />
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
                    <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/">Home</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/products/1">Products</a>
                  </li>
                    <c:if test="${role == 'admin'}">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/users/1">User Management</a>
                        </li>
                    </c:if>
                  

                </ul>
              </div>
            </div>
            
            <div class="dropdown account" style="margin-right:5rem">
                <button class="btn dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                  <img src="${pageContext.request.contextPath}/resources/images/avatar.jpg" width="50rem" height="50rem" alt="alt" style="border-radius:25rem"/>
                </button>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="#">Account</a></li>
                  <li><a class="dropdown-item" href="#">Change password</a></li>
                  <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Log out</a></li>
                </ul>
            </div>
        </nav>
        
                <div style="display: flex; justify-content: center; align-items: center; height: 100vh; "">
                    <p style="font-size: 3rem; ">Hello, ${firstName}</p>
                </div>
        
        
        
    </body>
</html>
