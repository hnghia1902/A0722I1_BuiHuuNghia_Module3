<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: caube
  Date: 2/1/2023
  Time: 6:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <title>Title</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="/static/css/bootstrap.css">
  <link rel="stylesheet" href="/static/datatables/css/dataTables.bootstrap4.css">
  <link rel="stylesheet" href="css/layout.css">
</head>
<body>
<div id="main">
  <div id="head1"> <img src="img/codegym.png" style="width: 30%"; height="100%"></div>
  <div id="head2">
    <span class="text_space">Create</span>
    <span  class="text_space"><a href="/Product?action=showListProduct">DisplayProduct</a></span>
    <span  class="text_space"></span>
  </div>
  <div id="content">
    <form action="/Product" method="post">
    <table style=" margin: auto">
      <thead>
      <tr>
        <td colspan="5"><h1>Create Product</h1></td>
      </tr>
      </thead>
      <tr>
        <td><span class="text_space_right">Product Name :</span></td>
        <td><input type="text" name="name"></td>
      </tr>
      <tr>
        <td><span class="text_space_right" >Price :</span></td>
        <td><input type="number" name="price"></td>
      </tr>
      <tr>
        <td><span class="text_space_right">Quantity :</span></td>
        <td><input type="text" name="quantity"></td>
      </tr>
      <tr>
        <td><span class="text_space_right">Color :</span></td><td>
        <select name="color">
          <option>Black</option>
          <option>Yellow</option>
          <option>Green</option>
        </select>
      </td>
      </tr>
      <tr>
        <td><span class="text_space_right">Category :</span></td>
        <td>
          <select name="category">
            <option>Phone</option>
            <option>Tivi</option>
            <option>Tủ lạnh</option>
            <option>Máy giặc</option>
          </select>
        </td>
      </tr>
      <tr>
        <td><span class="text_space_right">Description :</span></td>
        <td><input type="text" name="description"></td>
      </tr>
      <tr><td><button value="create" name="action" type="submit">Create</button></td></tr>
      <div class="alert alert-success">
        <strong>Success!</strong> Indicates a successful or positive action.
      </div>

    </table>

    </form>
  </div>
</div>
</body>
<script src="/static/js/jquery-3.5.1.min.js"></script>
<script src="/static/js/bootstrap.js"></script>
<script src="/static/datatables/js/jquery.dataTables.js"></script>
<script src="/static/datatables/js/dataTables.bootstrap4.js"></script>

<script>
  $(document).ready(function () {
    $('#table').dataTable({
      'searching': false,
      'pageLength' : 2
    })
  })

  function onDelete(id) {
    console.log(id);
    document.getElementById("idDelete").value = id;
  }
</script>
</html>
