<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>New Med Staff</title>
    <!-- Bootstrap CSS file -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="container-fluid navbar">
    <div class="row"></div>
    <div class="col"><a class="navbar-link" href="${pageContext.request.contextPath}/">Reha</a></div>
    <div class="col"></div>
</div>
<h1 align="center">Add new patient</h1>
<div class="col-md-8 mx-auto">
    <form:form action="${pageContext.request.contextPath}/doctor/newPatient/processForm" method="POST"
               modelAttribute="patient" class="needs-validation" novalidate="">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="firstName">First name</label>
                <form:input type="text" class="form-control" id="firstName" placeholder="" value="" required=""
                            path="name"/>
                <div class="invalid-feedback">
                    Valid first name is required.
                </div>
            </div>
            <div class="col-md-6 mb-3">
                <label for="lastName">Last name</label>
                <form:input type="text" class="form-control" id="lastName" placeholder="" value="" required=""
                            path="lastName"/>
                <div class="invalid-feedback">
                    Valid last name is required.
                </div>
            </div>
        </div>

        <div class="mb-3">
            <label for="username">Username</label>
            <div class="input-group">
                <form:input type="text" class="form-control" id="username" placeholder="Username" required=""
                            path="user.username"/>
                <div class="invalid-feedback" style="width: 100%;">
                    Your username is required.
                </div>
            </div>
        </div>

        <div class="mb-3">
            <label for="email">Email </label>
            <form:input type="email" class="form-control" id="email" placeholder="you@example.com" required=""
                        path="user.email"/>
            <div class="invalid-feedback">
                Please enter a valid email.
            </div>
        </div>

        <div class="mb-3">
            <label for="password">Password</label>
            <form:input type="text" class="form-control" id="password" placeholder="Password" required=""
                        path="user.password"/>
            <div class="invalid-feedback">
                Please enter your password.
            </div>
        </div>

        <div class="row">
            <div class="col-md-5 mb-3">
                <label for="gender">Gender</label>
                <form:select class="custom-select d-block w-100" id="gender" required="" path="gender">
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
            <label for="id_insurance">Insurance ID</label>
            <form:input type="text" class="form-control" id="id_insurance" required=""
                        path="idInsurance"/>
        </div>

        <form:button class="btn btn-primary btn-lg btn-block mb-2" type="submit">Add</form:button>
    </form:form>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"
        integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"
        integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj"
        crossorigin="anonymous"></script>
</body>
</html>