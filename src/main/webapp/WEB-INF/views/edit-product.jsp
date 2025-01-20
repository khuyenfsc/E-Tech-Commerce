<%-- 
    Document   : edit-product
    Created on : Dec 27, 2024, 12:00:18 PM
    Author     : khuye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Product</title>
        <noscript>
            <style>
              html {
                display: none;
              }
            </style>
            <meta http-equiv="refresh" content="0; url=${pageContext.request.contextPath}/no-javascript-error" />
         </noscript>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
    </head>
    <body style="display: flex; align-items: center; justify-content: center; height: 100vh; margin: 0;">
    <form:form class="border border-3 add-form" id="form-create" enctype="multipart/form-data" method="post" modelAttribute="productEdit" action="${pageContext.request.contextPath}/products/edit/id=${productEdit.getId()}" >
        <div class="title-container">
            <h1 style="">Edit Product</h1>
        </div>
        
        <div class="mb-3 row">
            <label for="id" class="col-sm-5 col-form-label">ID</label>
            <div class="col-sm-7">
                <form:input type="text" class="form-control border-3" id="id" aria-describedby="validationidFeedback" value="${productEdit.getId()}" path="id" readonly="readonly" style="pointer-events: none; background-color: #e9ecef;" />
            </div>
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
                <form:select class="form-select border-3" aria-label="Default select example" name="category" path="category">
                    <form:option value="Other">Other</form:option>
                    <form:option value="Smartphones">Smartphones</form:option>
                    <form:option value="Laptops">Laptops</form:option>
                    <form:option value="Headphones">Headphones</form:option>
                    <form:option value="Earbuds">Earbuds</form:option>
                    <form:option value="Gaming Consoles">Gaming Consoles</form:option>
                    <form:option value="E-Readers">E-Readers</form:option>
                    <form:option value="Tablets">Tablets</form:option>
                    <form:option value="Accessories">Accessories</form:option>
                    <form:option value="Cameras">Cameras</form:option>
                </form:select>
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
                <input type="file" class="form-control border-3 " id="file"  aria-describedby="validationfileFeedback" name="file" accept="image/png, image/gif, image/jpeg"/>      

                <div id="validationFileSize" class="invalid-feedback"  >
                    File size must be less than 20MB
                </div>
            </div>
        </div>

        <div style="text-align: center;">

            <input type="submit" value="Edit" class="btn btn-primary" style="margin-right: 10rem;" id="create-btn"/>

            <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/products/1">Cancel</a>

        </div>
            
    </form:form>
        
        
        
        <script src="${pageContext.request.contextPath}/resources/js/index.js"></script>
    </body>
</html>
