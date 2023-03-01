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
        <span class="text_space"><a href="/Product?action=create">Create</a></span>
        <span  class="text_space">Edit</span>
        <span  class="text_space">Delete</span>
    </div>
    <div id="content" STYLE="text-align: center">
        <table border="1" style="border: 1px solid black" , width="100%" ; id="table">
            <thead>
            <tr><td colspan="5">
                <h2 style="text-align: center">Product List</h2>
            </td></tr>
            <tr>
                <td>STT</td>
                <td>Name</td>
                <td>Price</td>
                <td>Quantity</td>
                <td>Color</td>
                <td>Category</td>
                <td colspan="2">Action</td>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listProduct}" var="list">
                <tr>
                    <td>${list.stt}</td>
                    <td>${list.name}</td>
                    <td>${list.price}</td>
                    <td>${list.quantity}</td>
                    <td>${list.color}</td>
                    <td>${list.category}</td>
                    <td><a href="/Product?action=delete&stt=${list.stt}"><button>Delete</button></a></td>
                    <td><a href="/Product?action=edit&stt=${list.stt}"><button>Edit</button></a></td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
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
