<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hike
  Date: 5/31/2019
  Time: 2:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>">

</head>
<body>

    <%

        int num1 = Integer.parseInt(request.getParameter("numOne"));
        int num2 = Integer.parseInt(request.getParameter("numTwo"));

        int num3 = Integer.parseInt(request.getParameter("numThree"));
        int num4 = Integer.parseInt(request.getParameter("numFour"));

        request.setAttribute("sum", (num1 + num2));
        request.setAttribute("mul", (num3 * num4));

        request.setAttribute("numOne", num1);
        request.setAttribute("numTwo", num2);
        request.setAttribute("numThree", num3);
        request.setAttribute("numFour", num4);

    %>

    <form action="Result" method="post">
        <input name="numOne" type="number" value="${numOne}"> +
        <input name="numTwo" type="number" value="${numTwo}"> =
        <input name="sum" readonly value="${sum}"><br>

        <input name="numThree" type="number" value="${numThree}"> *
        <input name="numFour" type="number" value="${numFour}"> =
        <input name="mul" readonly value="${mul}"><br>

        <input id="submit" type="submit" value="calculate">

    </form>

</body>
</html>
