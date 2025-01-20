<%-- 
    Document   : login
    Created on : Jan 9, 2025, 2:17:14 PM
    Author     : khuye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
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
    <body style="display: flex; height: 100vh; justify-content: center; align-items: center">
        <div class="border border-3">
            <h1 style="text-align: center" class="p-5">Login</h1>
            
            <form:form class="p-5" method="post" action="${pageContext.request.contextPath}/login" modelAttribute="user">
                <div class="mb-3 ">
                  <label for="exampleInputEmail1" class="form-label">Email address</label>
                  <form:input type="email" class="form-control border border-3" id="exampleInputEmail1" aria-describedby="emailHelp" path="email"/>
                  
                </div>
                <div class="mb-3">
                  <label for="exampleInputPassword1" class="form-label">Password</label>
                  <form:input type="password" class="form-control border border-3" id="exampleInputPassword1" path="password"/>
                </div>
                
                <button type="submit" class="btn btn-danger form-control">Login</button>
                <p class="mt-3" style="text-align: center">
                    OR
                </p>
                
                <a href="${pageContext.request.contextPath}/register" class="btn btn-primary form-control">Register</a>
            </form:form>
        </div>
        
    </body>
</html>
