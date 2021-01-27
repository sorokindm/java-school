<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>New Med Staff</title>
    <!-- Bootstrap CSS file -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

<%@include file="/resources/emptyNavbar.html"%>

<div class="container-fluid">
    <h2 class="text-center">Add new med staff</h2>
    <div class="col-md-8 mx-auto">
        <form:form action="${pageContext.request.contextPath}/admin/newMedStaff/processForm" method="POST"
                   class="needs-validation" novalidate="" modelAttribute="user">
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="firstName">First name</label>
                    <form:input type="text" class="form-control" id="firstName" path="medStaff.name" required="true"/>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="lastName">Last name</label>
                    <form:input type="text" class="form-control" id="lastName" path="medStaff.lastName" required="true"/>
                </div>
            </div>

            <div class="mb-3">
                <label for="username">Username</label>
                <form:errors path="username" cssClass="style"/>
                <div class="input-group">
                    <form:input type="text" class="form-control" id="username" path="username" required="true"/>

                </div>
            </div>

            <div class="mb-3">
                <label for="email">Email</label>
                <form:input type="email" class="form-control" id="email" placeholder="you@example.com" path="email" required="true"/>
            </div>

            <div class="mb-3">
                <label for="password">Password</label>
                <form:input type="text" class="form-control" id="password" placeholder="Password" path="password" required="true"/>
            </div>

            <div class="row">
                <div class="col-md-5 mb-3">
                    <label for="role">Role</label>
                    <form:select class="custom-select d-block w-100" id="role" path="role" required="true">
                        <option value="">Choose...</option>
                        <option value="ROLE_ADMIN">Admin</option>
                        <option value="ROLE_DOCTOR">Doctor</option>
                        <option value="ROLE_NURSE">Nurse</option>
                    </form:select>
                </div>
                <div class="col-md-5 mb-3">
                    <label for="gender">Gender</label>
                    <form:select class="custom-select d-block w-100" id="gender" path="medStaff.gender" required="true">
                        <option value="">Choose...</option>
                        <option value="MALE">Male</option>
                        <option value="FEMALE">Female</option>
                    </form:select>
                    <div class="invalid-feedback">
                        Please provide a valid gender.
                    </div>
                </div>
            </div>

            <div class="mb-3">
                <label for="specialty">Specialty</label>
                <form:input type="text" class="form-control" id="specialty" placeholder="Surgeon"
                            path="medStaff.specialty" required="true"/>
            </div>
            <button class="btn btn-primary btn-lg btn-block mb-2" type="submit">Add</button>
        </form:form>
    </div>
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