<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    
    <style>
        body {
            background-color: #f0f4f7;
        }
    </style>
    
</head>
<body>
	
	<%@ include file="common/navbar.jspf" %>
	
	<div class="container my-5">
	
		<h2 class="mt-2">
	    	<pre>Welcome ${loggedInUserName}.</pre>
	    </h2>
	    	    
 	</div>
 		
 
 
 
 	<script href="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script href="webjars/jquery/3.6.0/jquery.min.js"></script>
 	
</body>
</html>
