<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Admin</title>
    <!-- Bootstrap CSS file -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

<%@include file="/resources/emptyNavbar.html"%>

<br>

<%--USER:<security:authentication property="principal.username"></security:authentication>--%>
<%--ROLE:<security:authentication property="principal.authorities"></security:authentication>--%>
<div class="container-fluid">
    <h2>Users</h2>
    <div class="table-responsive">
        <table class="table table-striped table-sm">
            <thead>
            <tr>
                <th scope="colgroup">Username</th>
                <th scope="colgroup">Name/LastName</th>
                <th scope="colgroup">Role</th>
                <th scope="colgroup">Email</th>
                <th scope="colgroup">Create Time</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.username}</td>
                    <c:if test="${user.role=='ROLE_PATIENT'}">
                        <td>
                                ${user.patient.name}/${user.patient.lastName}
                        </td>
                    </c:if>
                    <c:if test="${user.role!='ROLE_PATIENT'}">
                        <td>
                                ${user.medStaff.name}/${user.medStaff.lastName}
                        </td>
                    </c:if>
                    <td>${user.role}</td>
                    <td>${user.email}</td>
                    <td>${user.createTime}</td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
    <br>
    <a href="${pageContext.request.contextPath}/admin/newMedStaff" class="btn btn-primary">New Med Staff</a>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"
        integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"
        integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"
        integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj"
        crossorigin="anonymous"></script>
</body>
</html>
