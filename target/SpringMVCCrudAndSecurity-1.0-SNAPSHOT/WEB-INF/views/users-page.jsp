
<%-- 
    Document   : home
    Created on : Dec 12, 2024, 4:29:13 PM
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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/products-page.css" />
        <title>Home</title>
        <noscript>
            <style>
              html {
                display: none;
              }
            </style>
            <meta http-equiv="refresh" content="0; url=${pageContext.request.contextPath}/no-javascript-error" />
         </noscript>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">

              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                  <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/">Home</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/products/1">Products</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link active" href="${pageContext.request.contextPath}/users/1">User Management</a>
                  </li>


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
        
        <div>
            <h1 style="text-align: center;margin-top: 1rem">Products</h1><br/> <br/>
        </div>
        <div style="margin: 4rem">
            >
            
            
            <table class="table">
                <thead>
                  <tr>
                    <th scope="col">ID</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Address</th>
                    <th scope="col">Role</th>
                    <th scope="col">Action</th>
                    
                       
                  </tr>
                </thead>
                <tbody id="tbody-products">
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <th scope="row">${user.getId()}</th>
                            <td>${user.getFirstName()}</td>
                            <td>${user.getLastName()}</td>
                            <td>${user.getEmail()}</td>
                            <td>${user.gettAddress()}</td>
                            <td>${user.getRole()}</td>
                            <td>
                                <a class="btn btn-primary" href="${pageContext.request.contextPath}/user/edit/id=${user.getId()}">Edit</a>
                                <a class="btn btn-danger" type="button" data-bs-toggle="modal" data-bs-target="#exampleModal"
                                    onclick="
                                        let id = this.parentElement.parentElement.firstElementChild.textContent
                                        idDelete = id
                                        console.log(id)
                                        document.getElementById('modal-delete-confirm').textContent = `Do you want to delete user with #ID is ` + id + '?'
                                    "
                                    >Delete</a>


                            </td>                            
                            
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            
            
        </div>
            
        <div style="text-align: center">
            <c:choose>
                <c:when test="${currentPage - 1 >= 1}">
                    <a class="btn btn-primary page-button" href="${pageContext.request.contextPath}/users/${currentPage - 1}"><</a>
                </c:when>
                <c:otherwise>
                    <a class="btn btn-primary page-button" href="#"><</a>
                </c:otherwise>
            </c:choose>
           
            <c:forEach var="page" begin="${currentPage}" end="${firstEndPage}">
                <c:choose>
                    <c:when test="${currentPage==page}">
                        <a class="btn btn-primary" href="${pageContext.request.contextPath}/users/${page}">${page}</a>
                    </c:when>
                    <c:otherwise>
                        <a class="btn btn-primary page-button" href="${pageContext.request.contextPath}/users/${page}">${page}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            
            <c:if test="${numberOfPages - currentPage > 3}">
                <span style="margin: 1rem">...</span>
            </c:if>
          
            <c:forEach var="page" begin="${secondStartPage}" end="${numberOfPages}">
                <c:choose>
                    <c:when test="${currentPage==page}">
                        <a class="btn btn-primary" href="${pageContext.request.contextPath}/users/${page}">${page}</a>
                    </c:when>
                    <c:otherwise>
                        <a class="btn btn-primary page-button" href="${pageContext.request.contextPath}/users/${page}">${page}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

           <c:choose>
                <c:when test="${currentPage + 1 <= numberOfPages}">
                    <a class="btn btn-primary page-button" href="${pageContext.request.contextPath}/users/${currentPage + 1}">></a>
                </c:when>
                <c:otherwise>
                    <a class="btn btn-primary page-button" href="#">></a>
                </c:otherwise>
            </c:choose>
                    
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop" >
                Page ${currentPage}
            </button>
            
            <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true" style="margin-top: 1em">
                  <div class="modal-dialog modal-dialog-scrollable">
                    <div class="modal-content">
                      <div class="modal-header">
                        <h1 class="modal-title fs-5" id="staticBackdropLabel">Select A Page</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                      </div>
                      <div class="modal-body">
                          <ul class="list-group">
                              <c:forEach var="page" begin="1" end="${numberOfPages}">
                                <li class="list-group-item btn" style="margin: 0px; padding: 0px">
                                     
                                    <c:choose>
                                        <c:when test="${page == currentPage}">
                                            <a class="btn btn-primary" style="display: block; width: 100%; height: 100%; margin: 0px"  href="${pageContext.request.contextPath}/users/${page}">Page ${page}</a> 
                                        </c:when>
                                        <c:otherwise>
                                            <a class="btn" style="display: block; width: 100%; height: 100%; margin: 0px" href="${pageContext.request.contextPath}/users/${page}">Page ${page}</a> 
                                        </c:otherwise>
                                    </c:choose>
                                </li>
                              </c:forEach>
                            
                                
                            
                          </ul>
                      </div>
                      <div class="modal-footer">
                        
                      </div>
                    </div>
                  </div>
                </div>
        </div>
            
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <h1 class="modal-title fs-5" id="exampleModalLabel">Delete?</h1>
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body" id="modal-delete-confirm">
                  
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                  <button type="button" class="btn btn-danger" onclick="
                            let formDelete = document.getElementById('form-delete')  
                            
                            formDelete.setAttribute('action', '${pageContext.request.contextPath}/users/delete/'      + idDelete)
                            formDelete.submit()
                          ">Delete</button>
                </div>
              </div>
            </div>
        </div>
        
        <form id="form-delete" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
            
        <script>
            let idDelete;
        </script>
        <script src="${pageContext.request.contextPath}/resources/js/index.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    </body>
</html>
