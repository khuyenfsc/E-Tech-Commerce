<%-- 
    Document   : add-product
    Created on : Dec 13, 2024, 1:26:03 PM
    Author     : khuye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
        <title>Add Product</title>
        <noscript>
            <style>
              html {
                display: none;
              }
            </style>
            <meta http-equiv="refresh" content="0; url=${pageContext.request.contextPath}/no-javascript-error" />
         </noscript>
    </head>
    <body style="display: flex; align-items: center; justify-content: center; height: 100vh; margin: 0;">
         
        
        <form:form class="border border-3 add-form" id="form-create" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/products/add" modelAttribute="product" >
            <div class="title-container">
                <h1 style="">New Product</h1>
            </div>
            
            <div class="mb-3 row">
                <label for="name" class="col-sm-5 col-form-label">Name</label>
                <div class="col-sm-7">
                    <form:input type="text" class="form-control border-3 ${fieldErrors['name'] != null ? 'is-invalid' : ''}"  id="name" aria-describedby="validationnameFeedback" path="name"/>
                    
                   <c:if test="${fieldErrors['name'] != null}">
                        <div id="validationnameFeedback" class="invalid-feedback">
                            Provide a name
                        </div>
                    </c:if>    
                    
                </div>
            </div>
            <div class="mb-3 row">
                <label for="brand" class="col-sm-5 col-form-label">Brand</label>
                <div class="col-sm-7">
                    <form:input type="text" class="form-control border-3 ${fieldErrors['brand'] != null ? 'is-invalid':''}" id="brand" aria-describedby="validationbrandFeedback" path="brand"/>
                    <c:if test="${fieldErrors['brand'] != null}">
                        <div id="validationbrandFeedback" class="invalid-feedback">
                            Provide a brand
                        </div>
                    </c:if>  
                    
                </div>
            </div>
            <div class="mb-3 row">
                <label for="category" class="col-sm-5 col-form-label">Category</label>
                <div class="col-sm-7">
                    <select class="form-select border-3" aria-label="Default select example" name="category">
                        <option selected="Orther" value="Other">Other</option>
                        <option value="Smartphones">Smartphones</option>
                        <option value="Laptops">Laptops</option>
                        <option value="Headphones">Headphones</option>
                        <option value="Earbuds">Earbuds</option>
                        <option value="Gaming Consoles">Gaming Consoles</option>
                        <option value="E-Readers">E-Readers</option>
                        <option value="Tablets">Tablets</option>
                        <option value="Accessories">Accessories</option>
                        <option value="Cameras">Cameras</option>
                    </select>
                </div>
            </div>
            <div class="mb-3 row">
                <label for="price" class="col-sm-5 col-form-label">Price</label>
                <div class="col-sm-7">
                    <form:input type="text" class="form-control border-3 ${fieldErrors['price'] != null ? 'is-invalid':''}" id="price" aria-describedby="validationpriceFeedback" path="price"/>
                    <c:if test="${fieldErrors['price'] != null}">
                        <div id="validationpriceFeedback" class="invalid-feedback">
                            Must be greater or equal than 1$
                        </div>
                    </c:if>  
                    
                </div>
            </div>
            <div class="mb-3 row">
                <label for="file" class="col-sm-5 col-form-label">Image</label>
                <div class="col-sm-7">
                    <input type="file" class="form-control border-3 ${fileUploadError != null ? 'is-invalid' : ''}" id="file"  aria-describedby="validationfileFeedback" name="file" accept="image/png, image/gif, image/jpeg"/>      
                    <c:if test="${fileUploadError != null}">
                        <div id="validationfileFeedback" class="invalid-feedback" >
                        ${fileUploadError}
                    </div>
                    </c:if>
                    
                    <div id="validationFileSize" class="invalid-feedback"  >
                        File size must be less than 20MB
                    </div>
                </div>
            </div>
            
            <div style="text-align: center;">
                
                <input type="submit" value="Create" class="btn btn-primary" style="margin-right: 10rem;" id="create-btn"/>
                
                <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/products/1">Cancel</a>
                
            </div>
            
            
          </form:form>
        
        <script src="${pageContext.request.contextPath}/resources/js/index.js"></script>
        
    </body>
</html>
