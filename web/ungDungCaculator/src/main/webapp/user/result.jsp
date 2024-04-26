<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 17/03/2023
  Time: 2:56 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% float firstOperand = (float) request.getAttribute("firstOperand"); %>
<% float secondOperand = (float) request.getAttribute("secondOperand"); %>
<% float result = (float) request.getAttribute("result"); %>
<h1>Result:</h1>
<h1><%=firstOperand%></h1>
<%--<p><%=request.getAttribute("firstOperand")%> <%=request.getAttribute("operator")%> <%=request.getAttribute("secondOperand")%>--%>
<%--    = <%=request.getAttribute("result")%>--%>
</p>
</body>
</html>
