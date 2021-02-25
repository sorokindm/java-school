<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>MedEvents</title>
    <!-- Bootstrap CSS file -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

<%@include file="/resources/nurseHeader.html" %>
<br>
<div class="container-fluid">
    <h2>Welcome,${medStaff.name} ${medStaff.lastName}!</h2>
    <h3>Today's events:</h3>
    <div class="row">
        <c:forEach items="${medEvents}" var="medEvent">
            <div class="col-md-4">
                <div class="card med-event m-4">
                    <div class="card-header text-center">Time:${medEvent.starts}</div>
                    <div class="card-body">
                        <h5 class="card-title">Patient:${medEvent.patient.name} ${medEvent.patient.lastName}</h5>
                        <h6 class="card-subtitle mb-2 text-muted">
                            Nurse:${medEvent.nurse.name} ${medEvent.nurse.lastName}</h6>
                        <h6 class="card-subtitle mb-2 text-muted">${medEvent.status}</h6>
                    </div>
                </div>
            </div>
        </c:forEach>
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
