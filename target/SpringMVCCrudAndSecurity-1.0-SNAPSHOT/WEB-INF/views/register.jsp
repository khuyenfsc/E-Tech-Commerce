<%-- 
    Document   : register
    Created on : Jan 9, 2025, 2:36:32 PM
    Author     : khuye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
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
        <div class="border border-3" style="display:flex">
            <h1 style="text-align: center" class="p-5">Register</h1>
            
            <form:form class="p-5" method="post" action="${pageContext.request.contextPath}/register" modelAttribute="user" >
                <div class="mb-3">
                  <label for="exampleInputFirstName" class="form-label">First name</label>
                  <form:input type="text" class="form-control border-3 ${fieldErrors['firstName'] != null ? 'is-invalid' : ''}"  aria-describedby="firstNameHelp" id="exampleInputFirstName" path="firstName"/>
                    <c:if test="${fieldErrors['firstName'] != null}">
                        <div id="firstNameHelp" class="invalid-feedback">
                            Provide a first name
                        </div>
                    </c:if>  
                </div>
                <div class="mb-3">
                  <label for="exampleInputLastName" class="form-label">Last name</label>
                  <form:input type="text" class="form-control border-3 ${fieldErrors['lastName'] != null ? 'is-invalid' : ''}" id="exampleInputLastName" path="lastName"  aria-describedby="lastNameHelp"/>
                    <c:if test="${fieldErrors['lastName'] != null}">
                        <div id="lastNameHelp" class="invalid-feedback">
                            Provide a last name
                        </div>
                    </c:if>
                </div>
                <div class="mb-3 ">
                  <label for="exampleInputEmail1" class="form-label">Email address</label>
                  <form:input type="email" class="form-control border-3 ${fieldErrors['email'] != null ? 'is-invalid' : ''}" id="exampleInputEmail1" aria-describedby="emailHelp" path="email"/>
                    <c:if test="${fieldErrors['email'] != null}">
                        <div id="emailHelp" class="invalid-feedback">
                            ${session.msg}
                        </div>
                    </c:if>
                  
                </div>
                <div class="mb-3">
                  <label for="exampleInputAddress" class="form-label">Address</label>
                  <form:input type="text" class="form-control border-3 ${fieldErrors['address'] != null ? 'is-invalid' : ''}" id="exampleInputAddress" path="address"/>
                    <c:if test="${fieldErrors['address'] != null}">
                        <div id="validationnameFeedback" class="invalid-feedback">
                            Provide address
                        </div>
                    </c:if>
                </div>
                <div class="mb-3">
                  <label for="inputPassword" class="form-label">Password</label>
                  <form:input type="password" class="form-control border-3 ${fieldErrors['password'] != null ? 'is-invalid' : ''}" id="inputPassword" path="password"/>
                    <c:if test="${fieldErrors['password'] != null}">
                        <div id="validationnameFeedback" class="invalid-feedback">
                            Provide a password
                        </div>
                    </c:if>
                </div>
                <div class="mb-3">
                  <label for="inputConfirmedPassword" class="form-label">Confirm password</label>
                  <input type="password" class="form-control border-3" id="inputConfirmedPassword"/>
                  <div id="match-noti">
                      
                  </div>
                </div>
                <div class="mb-3">
                    <input type="checkbox" id="i-show-password"/> Show password
                </div>
                <c:if test="${result != null}">
                    <div class="mb-3 ${result ? 'text-success' : 'text-danger'}" id="register-result">
                        ${result ? 'Register user successfully!' : 'Email already exists!'}
                        ${result = null}
                    </div>
                </c:if>
                
                    
                <input type="submit" class="btn btn-primary form-control" value="Register" disabled="" id="i-register"/>
            </form:form>
        </div>
        <script src="${pageContext.request.contextPath}/resources/js/register-js.js"></script>
    </body>
</html>
