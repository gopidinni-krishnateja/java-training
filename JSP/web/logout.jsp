<%--
  Created by IntelliJ IDEA.
  User: semanticbits
  Date: 12/3/18
  Time: 6:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 class="black">Sorry either you are logged out or no session
    exists for you !!!...</h2>
</body>
</html>
<%
    request.getSession().invalidate();
    response.sendRedirect(request.getContextPath() + "/index.jsp");
%>