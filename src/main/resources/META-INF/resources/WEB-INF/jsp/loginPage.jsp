<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="/css/login.css">
</head>
<body>

    <form action="/login" method="post">
        <h2>Login</h2>
        
        <p>
            <c:if test="${not empty error}">
                <div class="error-message">${error}</div>
            </c:if>
        </p>
        
        <label for="email">Email:</label>
        <input type="text" id="email" name="email"><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br><br>
        <input type="submit" value="Login">
        
        <div class="vertical-text">
            <p>Don't have an account?</p>
            <p><a href="/register">Register here</a></p>
        </div>
    </form>
    
</body>
</html>
