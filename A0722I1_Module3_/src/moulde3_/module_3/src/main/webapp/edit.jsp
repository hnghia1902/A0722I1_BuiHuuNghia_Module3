<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 27/02/2023
  Time: 8:31 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
  <h1>Edit Product</h1>
  <h2>
    <a href="/Product?action=showListProduct">List All Product</a>
  </h2>
</center>
<div align="center">
  <form method="post" action="/User">
    <table border="1" cellpadding="5">
      <caption>
        <h2>
          Edit Product
        </h2>
      </caption>
      <c:if test="${Prodcut != null}">
        <input type="hidden" name="stt" value="<c:out value='${Product.stt}' />"/>
      </c:if>
      <tr>
        <th>Product Name:</th>
        <td>
          <input type="text" name="name" size="45"
                 value="<c:out value='${Product.name}' />"
          />
        </td>
      </tr>
      <tr>
        <th>Price:</th>
        <td>
          <input type="text" name="price" size="45"
                 value="<c:out value='${Product.price}' />"
          />
        </td>
      </tr>
      <tr>
        <th>Quantity:</th>
        <td>
          <input type="text" name="quantity" size="45"
                 value="<c:out value='${Product.quantity}' />"
          />
        </td>
      </tr>
      <tr>
        <th>Color:</th>
        <td>
          <input type="text" name="color" size="45"
                 value="<c:out value='${Product.color}' />"
          />
        </td>
      </tr>
      <tr>
        <th>Description:</th>
        <td>
          <input type="text" name="description" size="45"
                 value="<c:out value='${Product.description}' />"
          />
        </td>
      </tr>
      <tr>
        <th>Category:</th>
        <td>
          <input type="text" name="category" size="45"
                 value="<c:out value='${Product.category}' />"
          />
        </td>
      </tr>


      <tr>
        <td colspan="2" align="center">
          <input type="submit" name="action" value="Save"/>
        </td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>
