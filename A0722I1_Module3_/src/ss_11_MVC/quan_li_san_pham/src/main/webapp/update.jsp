<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 06/02/2023
  Time: 5:53 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <style>
        .sp{width: 300px}
    </style>
<body>
<form action="/Product" method="post">
    <table>
        <thead>
        <tr>
            <td><h1>Edit Product</h1></td>
        </tr>
        </thead>
        <tr>
            <td class="sp">Nhập id cần sửa : </td>
            <td><input type="number" name="id"></td>
        </tr>
        <tr>
            <td class="sp">Nhập lại tên : </td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td class="sp">Nhập lại giá : </td>
            <td><input type="number" name="price"></td>
        </tr>
        <tr>
            <td class="sp">Nhập lại Product Description : </td>
            <td><input type="text" name="productDescription"></td>
        </tr>
        <tr>
            <td class="sp">Nhập lại Producer : </td>
            <td><input type="text" name="producer"></td>
        </tr>
        <tr>
            <td class="sp"><button type="submit" value="edit">Edit</button></td>
            <td>////////////</td>
        </tr>

    </table>
</form>
</body>
</html>
