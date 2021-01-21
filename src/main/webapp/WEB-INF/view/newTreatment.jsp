<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>New Treatment</title>
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
<h1 align="center">Add new Treatment</h1>
<div class="col-md-8 mx-auto">
    <form:form action="${pageContext.request.contextPath}/doctor/newTreatment/processForm" method="POST"
               modelAttribute="treatment" class="needs-validation" novalidate="">
        <div class="col-md-6 mb-3">
            <label for="opened_comments">Anamnesis</label>
            <form:input type="text" class="form-control" id="opened_comments" placeholder="" value="" required=""
                        path="openedComments"/>
            <div class="invalid-feedback">
                Invalid field
            </div>
        </div>
        <div class="col-md-6 mb-3">
            <label for="diagnosis">Diagnosis</label>
            <form:input type="text" class="form-control" id="diagnosis" placeholder="" value="" required=""
                        path="diagnosis"/>
            <div class="invalid-feedback">
                Invalid field
            </div>
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