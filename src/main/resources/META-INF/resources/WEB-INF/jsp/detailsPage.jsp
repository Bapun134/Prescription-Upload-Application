<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <title>Test Info Details</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f0f4f7;
        }
    </style>
</head>
<body>

	<%@ include file="common/navbar.jspf" %>
	
	<div class="container">
	
	    <h2 class="mt-2">
	    	<pre>See your test details:</pre>
	    </h2>
	    
	    <div class="my-4">
            <c:if test="${not empty testInfoList}">
                <c:set var="firstTest" value="${testInfoList[0]}" />
                <h5><pre><b>Patient Name:</b> ${firstTest.patientName}</pre></h5>
                <h5><pre><b>Patient ID:</b> ${firstTest.patientId}</pre></h5>
            </c:if>
        </div>
	    
    	<table border="1" class="table">
	        <thead>
	            <tr>
					<th>Test ID</th>
	                <th>Test Name</th>
					<th>Description</th>
					<th>Amount</th>
	            </tr>
	        </thead>
        
	        <tbody>
	            <c:forEach var="test" items="${testInfoList}">
	                <tr>
	                    <td>${test.testId}</td>
	                    <td>${test.testName}</td>
	                    <td>${test.desc}</td>
	                    <td>Rs. ${test.costOfTest}</td>
	                </tr>
	            </c:forEach>
	        </tbody>
    	</table>
    	
    	<div><a href="/appointment" class="btn btn-info">Book an Appointment</a></div>
 
	</div>
 
 
 
 	<script href="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script href="webjars/jquery/3.6.0/jquery.min.js"></script>
 	
</body>
</html>
