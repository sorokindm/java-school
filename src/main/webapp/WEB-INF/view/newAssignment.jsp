<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>New Assignment</title>
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
    <h2 class="text-center">Add new assignment</h2>
    <div class="col-md-8 mx-auto">
        <form:form action="${pageContext.request.contextPath}/doctor/newAssignment/processForm" method="POST"
                   modelAttribute="assignment" class="needs-validation" novalidate="">
            <div class="row justify-content-md-center">
                <div class="col-sm-auto">
                    <form:radiobutton id="medication" name="type" class="radio-inline" path="type" value="MEDICATION" checked="checked"/>
                    <label class="custom-control-label" for="medication">Medication</label>
                </div>
                <div class="col-sm-auto">
                    <form:radiobutton id="procedure" name="type" class="radio-inline" path="type" value="PROCEDURE"/>
                    <label class="custom-control-label" for="procedure">Procedure</label>
                </div>
            </div>

            <hr class="mb-4">

            <div class="mb-3">
                <label for="name">Name</label>
                <form:input type="text" class="form-control" id="name" path="name" required="true"/>
                <div class="invalid-feedback">
                    Valid field required
                </div>
            </div>

            <div class="row">
                <div class="col-sm">
                    <label for="dosage">Dosage</label>
                    <form:input type="text" class="form-control" id="dosage" path="dosage" required="true"/>
                    <div class="invalid-feedback">
                        Valid field required
                    </div>
                </div>
                <div class="col-sm">
                    <label for="quantity">Amount of weeks</label>
                    <form:errors path="quantity" cssClass="style"/>
                    <form:input type="number" class="form-control" id="quantity" path="quantity" required="true"/>
                </div>
            </div>

            <hr class="mb-4">

            <h3 class="text-center">Pattern</h3>
            <form:errors path="pattern" cssClass="style"/>
            <div class="row">
                <div class="col-sm">
                    <form:checkbox id="monday" path="pattern.monday" value="true"/>
                    <label for="monday">Monday</label>
                    <br>
                    <form:checkbox id="tuesday" path="pattern.tuesday" value="true"/>
                    <label for="tuesday">Tuesday</label>
                    <br>
                    <form:checkbox id="wednesday" path="pattern.wednesday" value="true"/>
                    <label for="wednesday">Wednesday</label>
                    <br>
                    <form:checkbox id="thursday" path="pattern.thursday" value="true"/>
                    <label for="thursday">Thursday</label>
                    <br>
                    <form:checkbox id="friday" path="pattern.friday" value="true"/>
                    <label for="friday">Friday</label>
                    <br>
                    <form:checkbox id="saturday" path="pattern.saturday" value="true"/>
                    <label for="saturday">Saturday</label>
                    <br>
                    <form:checkbox id="sunday" path="pattern.sunday" value="true"/>
                    <label for="sunday">Sunday</label>
                </div>
                <div class="col-sm">
                    <form:checkbox id="morning" path="pattern.morning" value="true"/>
                    <label for="morning">Morning</label>
                    <br>
                    <form:checkbox id="day" path="pattern.day" value="true"/>
                    <label for="day">Day</label>
                    <br>
                    <form:checkbox id="evening" path="pattern.evening" value="true"/>
                    <label for="evening">Evening</label>
                </div>

            </div>

            <form:input type="hidden" path="treatment.idTreatment" value="${idTreatment}"/>
            <div class="row">
                <form:button class="btn btn-primary text-center" type="submit">Add</form:button>
            </div>
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