<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Assignments</title>
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
    <h2>Assignments</h2>
    <div class="table-responsive">
        <table class="table table-striped table-sm">
            <thead>
            <tr>
                <th scope="colgroup">Type</th>
                <th scope="colgroup">Name</th>
                <th scope="colgroup">Dosage</th>
                <th scope="colgroup">Quantity</th>
                <th scope="colgroup">Pattern</th>
                <th scope="colgroup">Started</th>
                <th scope="colgroup">Status</th>
                <th scope="colgroup">Edit</th>
                <th scope="colgroup">Med Events</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${assignments}" var="assignment">
                <tr>
                    <td>${assignment.type}</td>
                    <td>${assignment.name}</td>
                    <td>${assignment.dosage}</td>
                    <td>${assignment.quantity}</td>
                    <td>
                        <c:if test="${assignment.pattern.morning==true}">Morning </c:if>
                        <c:if test="${assignment.pattern.day==true}">Day </c:if>
                        <c:if test="${assignment.pattern.evening==true}">Evening </c:if>
                        <br>
                        <c:if test="${assignment.pattern.monday==true}">Monday </c:if>
                        <c:if test="${assignment.pattern.tuesday==true}">Tuesday </c:if>
                        <c:if test="${assignment.pattern.wednesday==true}">Wednesday </c:if>
                        <c:if test="${assignment.pattern.thursday==true}">Thursday </c:if>
                        <c:if test="${assignment.pattern.friday==true}">Friday </c:if>
                        <c:if test="${assignment.pattern.saturday==true}">Saturday </c:if>
                        <c:if test="${assignment.pattern.sunday==true}">Sunday </c:if>
                    </td>
                    <td>${assignment.assignmentStartDate}</td>
                    <td>
                        <c:if test="${assignment.assignmentEndDate==null}">Active</c:if>
                        <c:if test="${assignment.assignmentEndDate!=null}">
                            Ended
                            <br>
                            Reason:${assignment.closedComments}
                        </c:if>
                    </td>
                    <td>
                        <form action="${pageContext.request.contextPath}/doctor/editAssignment" method="GET">
                            <input class="btn btn-primary" type="submit" value="View">
                            <input type="hidden" value="${assignment.idAssignment}" name="idAssignment">
                        </form>
                    </td>
                    <td>
                        <form action="${pageContext.request.contextPath}/doctor/medEvents" method="GET">
                            <input class="btn btn-primary" type="submit" value="View">
                            <input type="hidden" value="${assignment.idAssignment}" name="idAssignment">
                        </form>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
    <br>
    <form action="${pageContext.request.contextPath}/doctor/newAssignment/create" method="GET">
        <input class="btn btn-primary" type="submit" value="New Assignment"/>
        <input type="hidden" name="idTreatment" value="${idTreatment}"/>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"
        integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"
        integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj"
        crossorigin="anonymous"></script>
</body>
</html>
