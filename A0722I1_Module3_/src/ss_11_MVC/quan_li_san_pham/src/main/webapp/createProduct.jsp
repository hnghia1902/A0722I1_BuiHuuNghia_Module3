<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 04/02/2023
  Time: 11:03 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/Product" method="post">
  <table>
    <tr>
      <td colspan="2">Create</td>
    </tr>

    <tr>
      <td>Product ID : </td>
      <td><input type="number" name="id"></td>
    </tr>
    <tr>
      <td>Product Name : </td>
      <td><input type="text" name="name"></td>
    </tr>
    <tr>
      <td>Product Price : </td>
      <td><input type="number" name="price"></td>
    </tr>
    <tr>
      <td>Product Description : </td>
      <td><input type="text" name="description"></td>
    </tr>
    <tr>
      <td>Producer : </td>
      <td><input type="text" name="producer"></td>
    </tr>
    <tr>
      <td><button type="submit" name="action" value="create">Create</button></td>
      <td></td>
    </tr>
  </table>
</form>
</body>
</html>
