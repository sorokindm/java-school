<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>New Assignment</title>
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
<h1 align="center">Add new assignment</h1>
<div class="col-md-8 mx-auto">
    <form:form action="${pageContext.request.contextPath}/doctor/newAssignment/processForm" method="POST"
               modelAttribute="assignment" class="needs-validation" novalidate="">

        <div class="mb-3">
            <label for="name">Medicine or procedure name</label>
            <form:input type="text" class="form-control" id="name" placeholder="" value="" required=""
                        path="name"/>
            <div class="invalid-feedback">
                Valid field required
            </div>
        </div>
        <div class=mb-3">
            <label for="dosage">Dosage</label>
            <form:input type="text" class="form-control" id="dosage" placeholder="" value="" required=""
                        path="dosage"/>
            <div class="invalid-feedback">
                Valid field required
            </div>
        </div>

        <div class="mb-3">
            <label for="type">Type</label>
            <form:select class="custom-select d-block w-100" id="type" required="" path="type">
                <option value="">Choose...</option>
                <option value="<MEDICATION>">Medication</option>
                <option value="PROCEDURE">Procedure</option>
            </form:select>
            <div class="invalid-feedback">
                Valid field required
            </div>
        </div>
        <div class="row">
            <div class="col-md-1 mb-3">
                <form:input type="text" class="form-control" id="pattern_quantity" placeholder="" required="" path="patternQuantity"/>
                <div class="invalid-feedback">
                    Valid number required
                </div>
            </div>
            <div class="col-md-2 mb-3">
                Times per
            </div>
            <div class="col-md-2 mb-3">
                <form:select class="custom-select d-block w-100" id="timeframe" required="" path="timeframe">
                    <option value="DAY">Day</option>
                    <option value="HOUR">Hour</option>
                    <option value="WEEK">Week</option>
                    <option value="MONTH">Month</option>
                </form:select>
                <div class="invalid-feedback">
                </div>
            </div>
            <div class="col-md-2 mb-3">
                For
            </div>
            <div class="col-md-1 mb-3">
                <form:input type="text" class="form-control" id="patternHowlong" placeholder="" required="" path="patternHowlong"/>
                <div class="invalid-feedback">
                    Valid number required
                </div>
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