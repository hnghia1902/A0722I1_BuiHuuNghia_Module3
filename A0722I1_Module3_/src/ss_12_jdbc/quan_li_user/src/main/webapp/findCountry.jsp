<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>User Management Application</title>
</head>
<body>
<center>
  <h1>User Management</h1>
</center>
<div align="center">
  <form method="post" action="/User">
    <table border="1" cellpadding="5">
      <caption>
        <h2>
          Find User By Country
        </h2>
      </caption>
     <tr>
       <td><input type="text" name="country"></td>
       <td><input type="submit" value="Find" name="action"></td>
     </tr>
    </table>
  </form>
</div>
</body>
</html>