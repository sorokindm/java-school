<%@ page import="com.jschool.reha.crud.entity.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Logged In</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="container-fluid navbar">
    <div class="row"></div>
    <div class="col"> <a class="navbar-link" href="${pageContext.request.contextPath}/">Reha</a></div>
    <div class="col"></div>
</div>
<br>

<h2>Fetched from database</h2>
<%
    ArrayList<Person> users=(ArrayList<Person>) request.getAttribute("users");
%>
<table class="data-table">
    <tr>
        <th>Email</th>
        <th>Username</th>
        <th>Password</th>
        <th>Role</th>
        <th>Name</th>
        <th>Lastname</th>
        <th>Gender</th>
    </tr>
<% for (Person user:users) {%>
    <tr>
        <td><%=user.getEmail()%></td>
        <td><%=user.getUsername()%></td>
        <td><%=user.getPassword()%></td>
        <td><%=user.getRole()%></td>
        <td><%=user.getName()%></td>
        <td><%=user.getLastName()%></td>
        <td><%=user.getGender()%></td>
    </tr>
    <%}%>
</table>
</body>
</html>
