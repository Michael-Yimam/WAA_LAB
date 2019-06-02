<%--
  Created by IntelliJ IDEA.
  User: Hike
  Date: 5/31/2019
  Time: 2:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>

    <%
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/Calculator.jsp");
        //request.setAttribute("msg",message);
        rd.forward(request, response);
    %>



</body>
</html>
