<!DOCTYPE html>
<html>
<head>
    <title>Upload Page</title>
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
	    	<pre>Upload your Prescription:</pre>
	    </h2>
	    
	    <div class="col-md-4">
	        <form action="/upload" method="post" enctype="multipart/form-data">
	        	<input class="form-control" type="file" name="file" >
	        	<br>
	            <input class="btn btn-success" type="submit" name="Submit" />
	        </form>
	    </div>

	    
	    <%-- error and successful message --%>
	    
	    <% if (request.getAttribute("extractionError") != null) { %>
	    	<div class="alert alert-danger mt-3 d-inline-block w-auto" role="alert">
	        	<%= request.getAttribute("extractionError") %>
	    	</div>
		<% } else if (request.getAttribute("success") != null) { %>
	    	<div class="alert alert-success mt-3 d-inline-block w-auto" role="alert">
	        	<%= request.getAttribute("success") %>
	    	</div>
		<% } %>

	    
 	</div>
 
 	<script href="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script href="webjars/jquery/3.6.0/jquery.min.js"></script>
 	
</body>
</html>
