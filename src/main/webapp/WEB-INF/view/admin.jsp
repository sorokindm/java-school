<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jschool.reha.dto.UserDto" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Admin</title>
    <!-- Bootstrap CSS file -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="container-fluid navbar">
    <div class="row">
        <div class="col"><a class="navbar-link" href="${pageContext.request.contextPath}/">Reha</a></div>
        <div class="col">
            <form:form class="login text-center" action="${pageContext.request.contextPath}/logout"
                       method="POST">
                <button type="submit" class="btn btn-primary">Logout</button>

            </form:form>
        </div>
    </div>

</div>
<br>

<h2>Fetched from database</h2>
<%--USER:<security:authentication property="principal.username"></security:authentication>--%>
<%--ROLE:<security:authentication property="principal.authorities"></security:authentication>--%>
<%
    List<UserDto> users = (List<UserDto>) request.getAttribute("users");
%>
<table class="data-table">
    <tr>
        <th>Email</th>
        <th>Username</th>
        <th>Role</th>
        <th>Name</th>
        <th>Lastname</th>
        <th>Gender</th>
    </tr>
    <% for (UserDto user : users) {%>
    <tr>
        <td><%=user.getEmail()%>
        </td>
        <td><%=user.getUsername()%>
        </td>
        <td><%=user.getRole()%>
        </td>
        <td><%=user.getName()%>
        </td>
        <td><%=user.getLastName()%>
        </td>
        <td><%=user.getGender()%>
        </td>
    </tr>
    <%}%>
</table>

<form class="text-center" action="${pageContext.request.contextPath}/admin/newMedStaff"
           method="GET">
    <button type="submit" class="btn btn-primary">Add new med staff</button>
</form>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"
        integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"
        integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj"
        crossorigin="anonymous"></script>
</body>
</html>
