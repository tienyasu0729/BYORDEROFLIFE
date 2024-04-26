<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 11/06/2023
  Time: 10:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Caculator</h1>
<form action="/show/caculator" method="post">
    <input type="number" name="first">
    <input type="number" name="second">
    <button name="calculation" value="+">Addition(+)</button>
    <button name="calculation" value="-">Subtraction(-)</button>
    <button name="calculation" value="x">Multiplication(x)</button>
    <button name="calculation" value="/">Division(/)</button>
</form>
<h1>Result ${result}</h1>
</body>
</html>
