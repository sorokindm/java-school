<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>New Patient</title>
    <!-- Bootstrap CSS file -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="container-fluid logo">
    <div class="row">
        <div class="col"><a class="logo-link" href="${pageContext.request.contextPath}/">Reha</a></div>
        <div class="col">
            <form:form class="login text-center" action="${pageContext.request.contextPath}/logout"
                       method="POST">
                <button type="submit" class="btn btn-primary">Logout</button>
            </form:form>
        </div>
    </div>
</div>
<div class="container-fluid">
    <h2 class="text-center">Add new patient</h2>
    <div class="col-md-8 mx-auto">
        <form:form action="${pageContext.request.contextPath}/doctor/newPatient/processForm" method="POST"
                   modelAttribute="user">
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="firstName">First name</label>
                    <form:errors path="patient.name" cssClass="style"/>
                    <form:input type="text" class="form-control" id="firstName" path="patient.name" required="true"/>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="lastName">Last name</label>
                    <form:errors path="patient.lastName" cssClass="style"/>
                    <form:input type="text" class="form-control" id="lastName" path="patient.lastName" required="true"/>
                </div>
            </div>

            <div class="mb-3">
                <label for="username">Username</label>
                <form:errors path="username" cssClass="style"/>
                <div class="input-group">
                    <form:input type="text" class="form-control" id="username" placeholder="Username" required="true" path="username"/>
                </div>
            </div>

            <div class="mb-3">
                <label for="email">Email </label>
                <form:errors path="email" cssClass="style"/>
                <form:input type="email" class="form-control" id="email" placeholder="patient@example.com" required="true" path="email"/>
            </div>

            <div class="row">
                <div class="col-md-5 mb-3">
                    <label for="gender">Gender</label>
                    <form:errors path="patient.gender" cssClass="style"/>
                    <form:select class="custom-select d-block w-100" id="gender" required="true" path="patient.gender">
                        <option value="">Choose...</option>
                        <option value="MALE">Male</option>
                        <option value="FEMALE">Female</option>
                    </form:select>
                    <div class="invalid-feedback">
                        Please provide a gender
                    </div>
                </div>
            </div>

            <div class="mb-3">
                <label for="id_insurance">Insurance ID</label>
                <form:errors path="patient" cssClass="style"/>
                <form:input type="text" class="form-control" id="id_insurance" required="true"
                            path="patient.idInsurance"/>
            </div>
            <form:input type="hidden" value="1" path="password"/>
            <form:button class="btn btn-primary btn-lg btn-block mb-2" type="submit">Add</form:button>
        </form:form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"
        integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"
        integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj"
        crossorigin="anonymous"></script>
</body>
</html>