<%--
  Created by IntelliJ IDEA.
  User: semanticbits
  Date: 12/3/18
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<script>
    function editMode(value) {
       console.log("value",value);
        window.location="/edit.jsp?userId='"+ value;
    }
</script>
<%
    HttpSession httpSession=request.getSession(false);

    String driverName = "org.postgresql.Driver";
    String connectionUrl = "jdbc:postgresql://localhost:5432/";
    String dbName = "postgres";
    String userId = "postgres";
    String password = "postgres";

    try {
        Class.forName(driverName);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
%>
<% if (httpSession.getAttribute("name") != null) { %>
<form align="left" action="/logout.jsp" method="get">
    <input  type="submit" value="Logout" />
</form>
<h2 align="center"><strong>Retrieve data from database in jsp</strong></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
    <tr>

    </tr>
    <tr bgcolor="#A52A2A">
        <td><b>User Id</b></td>
        <td><b>Bank Name</b></td>
        <td><b>IFSC Code</b></td>
        <td><b>Customer Name</b></td>
        <td><b>age</b></td>
        <td><b>Account Number</b></td>
        <td><b>Phone Number</b></td>
        <td><b>City</b></td>
    </tr>
    <%
        try{
            connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
            statement=connection.createStatement();
            String sql ="SELECT * FROM bank";

            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
    %>
    <tr bgcolor="#DEB887">
        <td><%=resultSet.getString("user_id") %></td>
        <td><%=resultSet.getString("bank_name") %></td>
        <td><%=resultSet.getString("ifsc_code") %></td>
        <td><%=resultSet.getString("customer_name") %></td>
        <td><%=resultSet.getInt("age") %></td>
        <td><%=resultSet.getString("account_number") %></td>
        <td><%=resultSet.getInt("phone_number") %></td>
        <td><%=resultSet.getString("city") %></td>
        <td><input type="button" value="Edit" onclick="editMode(<%resultSet.getString("user_id");%>)"/> </td>
        <td><input type="button" value="Delete" /> </td>

    </tr>

    <%}

        } catch (Exception e) {
            e.printStackTrace();
        }
    %>
</table>
<% } else {
    response.sendRedirect("/index.jsp");
%>

<% } %>