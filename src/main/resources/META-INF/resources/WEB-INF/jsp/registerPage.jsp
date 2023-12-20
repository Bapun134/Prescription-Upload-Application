<!DOCTYPE html>
<html>
<head>
    <title>Registration Page</title>
    <link rel="stylesheet" type="text/css" href="/css/register.css">
</head>
<body>
    <form action="/register" method="post">
        <h2>Register</h2>
 
        
        <label for="fName">First Name:</label>
        <input type="text" id="fName" name="fName" required><br><br>

        
        <label for="lName">Last Name:</label>
        <input type="text" id="lName" name="lName" required><br><br>


        <c:if test="${not empty error}">
           	<div class="error-message">${error}</div>
        </c:if>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        
        <label>Gender:</label>
        <div class="gender-labels">
            <label for="male">Male</label>
            <input type="radio" id="male" name="gender" value="M">
            
            <label for="female">Female</label>
            <input type="radio" id="female" name="gender" value="F">
        </div>
        
        <label for="phone">Phone (+91):</label>
        <input type="text" id="phone" name="phone" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>

        
        <input type="submit" value="Register">
        
        <div class="vertical-text">
            <p>Already have an account?</p>
            <p><a href="/login">Login here</a></p>
        </div>
    </form>
</body>
</html>
