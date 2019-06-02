<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>Login</title>
    <!--link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/-->
</head>
<body>

    <form action="Login" method="post">
        Name: <input type="text" name="username" size="9"/><br/>
        Password: <input type="password" name="password" size="9"/><br/>
        <input type="submit" value="Log In"/>
    </form>
    <p><c:out value="${loginError}"></c:out></p>
</body>
</html>