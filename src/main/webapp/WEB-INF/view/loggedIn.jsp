<%@ page import="com.jschool.reha.model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Logged In</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="navbar">
    <a class="navbar-link" href="${pageContext.request.contextPath}/">Reha</a>
</div>
<br>

<h2>Fetched from database</h2>
<%
    ArrayList<User> users=(ArrayList<User>) request.getAttribute("users");
%>
<table class="data-table">
    <tr>
        <th>Email</th>
        <th>Username</th>
        <th>Password</th>
        <th>Role</th>
    </tr>
<% for (User user:users) {%>
    <tr>
        <td><%=user.getEmail()%></td>
        <td><%=user.getUsername()%></td>
        <td><%=user.getPassword()%></td>
        <td><%=user.getRole()%></td>
    </tr>
    <%}%>
</table>
</body>
</html>
