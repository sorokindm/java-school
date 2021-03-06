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
<%@include file="/resources/doctorHeader.html"%>
<div class="container-fluid">
    <h2 class="text-center">Add new Treatment</h2>
    <div class="col-md-8 mx-auto">
        <form:form action="${pageContext.request.contextPath}/doctor/newTreatment/processForm" method="POST"
                   modelAttribute="treatment" class="needs-validation" novalidate="">
            <div class="col-md-6 mb-3 mx-auto">
                <label for="opened_comments">Anamnesis</label>
                <form:textarea type="text" class="form-control" id="opened_comments" placeholder="" value="" required="true"
                            path="openedComments"/>
            </div>
            <div class="col-md-6 mb-3 mx-auto">
                <label for="diagnosis">Diagnosis</label>
                <form:textarea type="text" class="form-control" id="diagnosis" placeholder="" value="" required="true"
                            path="diagnosis"/>
            </div>
            <div class="col-md-6 mb-3 mx-auto text-center">
                <form:input type="hidden" value="${treatment.patient.idPatient}" path="patient.idPatient"/>
                <form:input type="hidden" value="${treatment.doctor.idMedStaff}" path="doctor.idMedStaff"/>

                <form:button class="btn btn-dark btn-lg btn-block mb-2" type="submit">Submit</form:button>
            </div>

        </form:form>
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