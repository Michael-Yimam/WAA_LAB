<%--
  Created by IntelliJ IDEA.
  User: Hike
  Date: 5/30/2019
  Time: 5:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result Form</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>

    <form action="calculator" method="post">
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
