<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Doctor</title>
    <!-- Bootstrap CSS file -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<%@include file="/resources/doctorHeader.html" %>
<br>

<div class="container-fluid">
    <h2>Welcome,${medStaff.name} ${medStaff.lastName}!</h2>
    <br>
    <h3>Your Treatments:</h3>
    <div class="table-responsive">
        <table class="table table-striped table-sm">
            <thead>
            <tr>
                <th scope="colgroup">Patient</th>
                <th scope="colgroup">Doctor</th>
                <th scope="colgroup">Anamnesis</th>
                <th scope="colgroup">Diagnosis</th>
                <th scope="colgroup">Status</th>
                <th scope="colgroup">Assignments</th>
                <th scope="colgroup"></th>
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
                    <c:if test="${treatment.treatmentClosed==null}">Active</c:if>
                    <c:if test="${treatment.treatmentClosed!=null}">
                        Closed
                        <br>
                        Reason:${treatment.closedComments}
                    </c:if>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/doctor/assignment" method="GET">
                        <input class="btn btn-dark" type="submit" value="View"/>
                        <input type="hidden" name="idTreatment" value="${treatment.idTreatment}"/>
                    </form>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/doctor/editTreatment" method="GET">
                        <input class="btn btn-dark" type="submit" value="Edit"/>
                        <input type="hidden" name="idTreatment" value="${treatment.idTreatment}"/>
                    </form>
                </td>
            </tr>
            </c:forEach>
    </div>

    </tbody>
    </table>
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
