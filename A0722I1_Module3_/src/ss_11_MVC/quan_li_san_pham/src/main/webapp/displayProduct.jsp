<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<style>
    table,th, td{
        border: 1px solid black;
        border-collapse: collapse;
    }
    th, td{
        padding: 10px;
    }
</style>
<body>
<table >
    <thead>
    <tr>
        <td colspan="5" style="text-align: center">Product List</td>
    </tr>
    <tr>
        <td>Product ID</td>
        <td>Product Name</td>
        <td>Product Price</td>
        <td>Product Description</td>
        <td>Producer</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${product}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.productDescription}</td>
            <td>${product.producer}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>