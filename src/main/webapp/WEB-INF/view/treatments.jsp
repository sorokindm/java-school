<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Treatments</title>
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

<div class="container-fluid">
    <h2>Treatments</h2>
    <div class="table-responsive">
        <table class="table table-striped table-sm">
            <thead>
            <tr>
                <th scope="colgroup">Patient</th>
                <th scope="colgroup">Doctor</th>
                <th scope="colgroup">Anamnesis</th>
                <th scope="colgroup">Diagnosis</th>
                <th scope="colgroup">Assignments</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${treatments}" var="treatment">
                <tr>
                    <td>${treatment.patient.name} ${treatment.patient.lastName}</td>
                    <td>${treatment.doctor.name} ${treatment.doctor.lastName} (${treatment.doctor.specialty})</td>
                    <td>${treatment.openedComments}</td>
                    <td>${treatment.diagnosis}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/doctor/assignment" method="GET">
                            <input class="btn btn-primary" type="submit" value="View">
                            <input type="hidden" value="${treatment.idTreatment}">
                        </form>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
    <br>
    <a href="${pageContext.request.contextPath}/doctor/newTreatment/selectPatient" class="btn btn-primary">New Treatment</a>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"
        integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"
        integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj"
        crossorigin="anonymous"></script>
</body>
</html>
