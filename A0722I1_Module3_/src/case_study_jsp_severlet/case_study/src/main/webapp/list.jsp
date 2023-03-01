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
    <div id="head1"></div>
    <div id="head2">
        <span class="text_space">Create</span>
        <span  class="text_space">Edit</span>
        <span  class="text_space">Delete</span>
    </div>
    <div id="content">

    </div>
</div>
</body>
<script src="/static/js/jquery-3.5.1.min.js"></script>
<script src="/static/js/bootstrap.js"></script>
<script src="/static/datatables/js/jquery.dataTables.js"></script>
<script src="/static/datatables/js/dataTables.bootstrap4.js"></script>

<script>
    $(document).ready(function () {
        $('#tableStudent').dataTable({
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
