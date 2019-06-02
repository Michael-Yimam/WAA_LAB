<%--
  Created by IntelliJ IDEA.
  User: Hike
  Date: 5/31/2019
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<html>
<head>
    <title>Random</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="resources/css/style.css"/>">
</head>
<body>

    <a href="<c:url value="/Random"/>">Generate Random Number</a>
    <c:choose>
        <c:when test = "${randomNumbers.first == randomNumbers.control}">
            <div class="container">
                <h2>And the results are:</h2>
                <p class="blue">The number ${randomNumbers.first} is equal to ${randomNumbers.control}</p>
            </div>
        </c:when>

        <c:when test = "${randomNumbers.second > randomNumbers.control}">
            <div class="container">
                <h2>And the results are:</h2>
                <p class="green">The number ${randomNumbers.second} is greater than ${randomNumbers.control}</p>
            </div>
        </c:when>

        <c:when test = "${randomNumbers.third < randomNumbers.control}">
            <div class="container">
                <h2>And the results are:</h2>
                <p class="red">The number ${randomNumbers.third} is less than ${randomNumbers.control}</p>
            </div>
        </c:when>
    </c:choose>


</body>
</html>
