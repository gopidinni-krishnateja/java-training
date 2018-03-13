<%--
  Created by IntelliJ IDEA.
  User: semanticbits
  Date: 12/3/18
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script>
    function register()
  {
    window.location='/registration.jsp';
  }
</script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Example</title>
</head>
<body>
<div class="" align="center">
<form method="post" action="authenticate" >
    <table border="1" width="30%" cellpadding="3">
      <thead>
      <tr>
        <th colspan="2">Login Here</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>User Id</td>
        <td><input type="text" name="user_id" value="" /></td>
      </tr>
      <tr>
        <td>Account Number</td>
        <td><input type="text" name="account_number" value="" /></td>
      </tr>
      <tr>
        <td><input type="button" value="Register" onclick="register()" /></td>
        <td><input type="submit" value="Authenticate" /></td>
      </tr>
      </tbody>
    </table>
</form>
</div>
</body>
</html>
