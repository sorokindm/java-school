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

<%@include file="/resources/emptyNavbar.html"%>

<br>

<div class="container-fluid">
    <h2>MedEvents</h2>
    <div class="table-responsive">
        <table class="table table-striped table-sm">
            <thead>
            <tr>
                <th scope="colgroup">Patient</th>
                <th scope="colgroup">Nurse</th>
                <th scope="colgroup">Starts</th>
                <th scope="colgroup">Status</th>
                <th scope="colgroup">Closed Comments</th>
                <th scope="colgroup">Cancel</th>
                <th scope="colgroup">Done</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${medEvents}" var="medEvent">
                <tr>
                    <td>
                        Name:${medEvent.patient.name}
                        <br>
                        LastName:${medEvent.patient.lastName}
                    </td>
                    <td>
                        Name:${medEvent.nurse.name}
                        <br>
                        Last Name:${medEvent.nurse.lastName}
                    </td>
                    <td>${medEvent.starts}</td>
                    <td>${medEvent.status}</td>
                    <td>${medEvent.closedComments}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/nurse/cancel" method="GET">
                            <input class="btn btn-danger" type="submit" value="Cancel"/>
                            <input type="hidden" name="idMedEvent" value="${medEvent.idMedEvent}"/>
                        </form>
                    </td>
                    <td>
                        <form:form action="${pageContext.request.contextPath}/nurse/done" method="POST">
                            <input class="btn btn-success" type="submit" value="Done"/>
                            <input type="hidden" name="idMedEvent" value="${medEvent.idMedEvent}"/>
                        </form:form>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
    <br>
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
