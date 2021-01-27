<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>New Treatment</title>
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
    <h2 class="text-center">
        <c:if test="${close!=null}">
            Close Treatment
            <c:set var="action" scope="page" value="${pageContext.request.contextPath}/doctor/closeTreatment"/>
        </c:if>
        <c:if test="${close==null}">
            Edit Treatment
            <c:set var="action" scope="page" value="${pageContext.request.contextPath}/doctor/editTreatment"/>
        </c:if>
    </h2>
    <p>
        Doctor:${treatment.doctor.name} ${treatment.doctor.lastName}<br>
        Patient:${treatment.patient.name} ${treatment.patient.lastName}<br>
        Opened on:${treatment.treatmentOpened}<br>
    </p>
    <hr class="mb-4">
    <div class="col-md-8 mx-auto">
        <form:form method="POST" action="${action}" modelAttribute="treatment">

            <div class="col-md-6 mb-3">
                <label for="opened_comments">Anamnesis</label>

                <form:textarea type="text" class="form-control" id="opened_comments" path="openedComments" required="true"
                               value="${treatment.openedComments}"/>
                <div class="invalid-feedback">
                    Invalid field
                </div>
            </div>
            <div class="col-md-6 mb-3">
                <label for="diagnosis">Diagnosis</label>
                <form:textarea type="text" class="form-control" id="diagnosis" value="${treatment.diagnosis}" required="true"
                               path="diagnosis"/>
                <div class="invalid-feedback">
                    Invalid field
                </div>
            </div>

            <c:if test="${close!=null}">
                <div class="col-md-6 mb-3">
                    <label for="closed_comments">Please write closing comments</label>
                    <form:textarea type="text" class="form-control" id="closed_comments" path="closedComments" required="true"/>
                    <div class="invalid-feedback">
                        Invalid field
                    </div>
                </div>
            </c:if>

            <form:input type="hidden" value="${treatment.idTreatment}" path="idTreatment"/>
            <c:if test="${close==null}">
                <form:button class="btn btn-primary btn-lg btn-block mb-2" type="submit">Edit</form:button>
            </c:if>
            <c:if test="${close!=null}">
                <input type="hidden" value="${true}" name="close"/>
                <form:button class="btn btn-danger" type="submit">Close treatment</form:button>
            </c:if>
        </form:form>
    </div>
    <c:if test="${close==null}">
        <form action="${pageContext.request.contextPath}/doctor/closeTreatment" method="GET">
            <input class="btn btn-danger" type="submit" value="Close treatment"/>
            <input type="hidden" name="idTreatment" value="${treatment.idTreatment}"/>
            <input type="hidden" name="close" value="true"/>
        </form>
    </c:if>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"
        integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"
        integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj"
        crossorigin="anonymous"></script>
</body>
</html>