<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 06/02/2023
  Time: 6:54 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/Product" method="post">
  <table border="1">
    <tr>
      <td width="200px">Product ID Delete: </td>
      <td><input type="number" name="delete"></td>
    </tr>
    <tr>
      <td><button type="submit" name="action" value="deleteId" style="width: 199px">Delete</button></td>
    </tr>
  </table>
</form>
</body>
</html>
