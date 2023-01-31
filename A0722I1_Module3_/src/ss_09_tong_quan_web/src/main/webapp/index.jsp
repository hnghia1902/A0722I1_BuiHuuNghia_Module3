<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/CalcuratorServlet" method="post">
    <table border="1">
        <tr>
            <td>Product Description:</td>
            <td><input type="text" name="description"></td>
        </tr>
        <tr>
            <td>List Price:</td>
            <td><input type="number" name="price" ></td>
        </tr>
        <tr>
            <td>Discount Amount:</td>
            <td><input type="text" name="amount"></td>
        </tr>
        <tr>
            <td><button type="submit" name="action" value="calculator" style="width: 100%">calculator</button></td>
            <td><button type="reset" name="action" value="reset" style="width: 100%">reset</button></td>
        </tr>
        <tr>
            <td colspan="2">
                ${DescriptionAmount}
            </td>
        </tr>
    </table>
</form>
</body>
</html>