<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Appointment Form</title>
    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" >
    <style>
        body {
            background-color: #f0f4f7;
        }
        .appointment-form {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 8px;
            margin-top: 15px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-label {
            font-weight: bold;
        }
        .form-control {
            width: 100%;
            padding: 8px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }
        .btn-primary {
            width: 100%;
            padding: 10px;
            border-radius: 4px;
        }
        .container {
		    position: relative;
		    margin: 0 auto;
		    box-sizing: border-box;
		}
		
		.left-content {
		    position: absolute;
		    left: 0;
		    width: 40%; /* Adjust the width as needed */
		    top: 0;
		    bottom: 0;
		    background-color: #f9f9f9; /* Example background color */
		}
		
		.right-content {
		    position: absolute;
		    right: 0;
		    width: 60%; /* Adjust the width as needed */
		    top: 0;
		    bottom: 0;
		    background-color: #fff; /* Example background color */
		}
		
		/* Adjustments for responsiveness */
		@media (max-width: 768px) {
		    .left-content,
		    .right-content {
		        position: relative;
		        width: 100%;
		    }
		}
    </style>
</head>
<body>

    <%@ include file="common/navbar.jspf" %>
    
    <div class="container">
    	<div class="content">
    		<div class="left-content">
    		
		        <h2 class="container mt-3">
				   	<pre>Schedule Your Appointment:</pre>
				</h2>
			    
			    <div class="mt-1 mx-3">
			    	<h5><b>Clinic Name:</b></h5>
		            <p>R-K Medical Center- Diagnostic and Pathology</p>
		            <h5><b>Address:</b></h5>
		            <p>A/76, Central Rd, XYZ Town, XXXXXXX <br>Kolkata, West Bengal 54321</p>
		            <h5><b>Contact Us:</b></h5>
		            <p>Phone: +91 94524XXXXX</p>      
		        </div>
	        </div>
	        
	        <div class="right-content">
	            <%-- error and successful message if-elseif-else --%>
				
				<% if (request.getAttribute("successMessage") != null) { %>
			    	<div class="alert alert-success mt-3 d-inline-block w-auto" role="alert" style="margin: 0 auto;">
			        	<%= request.getAttribute("successMessage") %>
			    	</div>
				<% } 
				else if (request.getAttribute("errorMessage") != null) { %>
			    	<div class="alert alert-danger mt-3 d-inline-block w-auto" role="alert" style="margin: 0 auto;">
			        	<%= request.getAttribute("errorMessage") %>
			    	</div>
				<% } 
				else { %>
				
					<div class="my-2">	      				
			            <form class="appointment-form" action="/appointment" method="post" >
			                <div class="form-group">
			                    <label for="userName" class="form-label">Full Name:</label>
			                    <input type="text" id="userName" name="userName" class="form-control" required>
			                </div>
			                
			                <div class="form-group">
			                    <label for="userEmail" class="form-label">Email:</label>
			                    <input type="email" id="userEmail" name="userEmail" class="form-control" required>
			                </div>
			                
			                <div class="form-group">
			                    <label for="userPhone" class="form-label">Phone:</label>
			                    <input type="tel" id="userPhone" name="userPhone" class="form-control" required>
			                </div>
			                
			                <div class="form-group">
			                    <label for="scheduleDate" class="form-label">Schedule Your Date:</label>
			                    <input type="date" id="scheduleDate" name="scheduleDate" class="form-control" required>
			                </div>
			                
			                
			                <div class="form-group">
			                    <label for="totalAmount" class="form-label">Total Amount (Rupees):</label>
			                    <input type="number" id="totalAmount" name="totalAmount" class="form-control" value="${totalAmount}" readonly>
			                </div>
			                
			                <button type="submit" class="btn btn-primary">Confirm Appointment</button>
			                
			            </form>
			        </div>
		        
				<% } %>
	        </div>
    	</div>
    	
 	    	    

    </div>
 
    <script href="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script href="webjars/jquery/3.6.0/jquery.min.js"></script>
    
</body>
</html>
