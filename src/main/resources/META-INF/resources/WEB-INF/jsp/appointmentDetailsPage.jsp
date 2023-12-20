<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <title>Appointment Details</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f0f4f7;
        }
    </style>
</head>
<body>

    <%@ include file="common/navbar.jspf" %>

    <div class="container mt-4">
        <h2>Appointment Details</h2>
        <table class="table">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Appointment Date</th>
                    <th>Total Amount</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="appointment" items="${appointmentDetails}">
                    <tr>
                        <td>${appointment.userName}</td>
                        <td>${appointment.userEmail}</td>
                        <td>${appointment.userPhone}</td>
                        <td>${appointment.scheduleDate}</td>
                        <td>${appointment.totalAmount}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
</body>
</html>
