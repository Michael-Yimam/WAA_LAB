<%--
  Created by IntelliJ IDEA.
  User: Hike
  Date: 6/1/2019
  Time: 7:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Coffee</title>
</head>
<body>
    <h2>Username <c:out value="${userName}"></c:out></h2>

    <form action="Coffee">
    <select name="roast">
        <option>---Choose Roast Type</option>
        <c:forEach var="roast" items="${roast}">
            <option value="${roast}">
                <c:out value="${roast}"></c:out>
            </option>
        </c:forEach>
    </select>

    <ul>
        <c:forEach var="breed" items="${breeds}">
            <li>
                <c:out value="${breed}"></c:out>
            </li>
        </c:forEach>
    </ul>
        <input type="submit" value="submit">
    </form>
</body>
</html>
