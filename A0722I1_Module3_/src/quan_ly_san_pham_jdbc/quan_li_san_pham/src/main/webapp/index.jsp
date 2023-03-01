<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="css/layout.css">
</head>
<body>
<form>
    <div id="main">
        <div id="head"></div>
        <div id="head2">
            <span class="space">Home</span>
            <span class="space">Create</span>
            <span class="space">Delete</span>
            <span class="space">Edit</span>
            <span class="space">Find</span>
            <input type="submit" STYLE="font-size: 22px; float: right" name="action">
            <input type="text" STYLE="font-size: 22px; float: right" placeholder="search">
        </div>
        <div id="left">
            <span>1</span><br>
            <span>2</span><br>
            <span>3</span><br>
        </div>
        <div id="content">

        </div>
        <div id="footer">Footer</div>
    </div>
</form>
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