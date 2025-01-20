<%-- 
    Document   : layout
    Created on : Dec 28, 2024, 5:48:39 PM
    Author     : khuye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <tiles:insertAttribute name="title" ignore="true" />
        <tiles:insertAttribute name="boostrap-css" ignore="true" />
        <tiles:insertAttribute name="noscript" ignore="true" /> 
    </head>
    <body>
        <tiles:insertAttribute name="navbar" ignore="true" />
        <tiles:insertAttribute name="body" ignore="true" />
        <tiles:insertAttribute name="boostrap-js" ignore="true"/>
    </body>
</html>
