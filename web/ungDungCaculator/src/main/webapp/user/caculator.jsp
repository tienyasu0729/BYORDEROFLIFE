<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 17/03/2023
  Time: 2:21 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <style>
    label{
      color: red;
    }
    .input {
      height:180px; width:230px;
      margin:0;
      padding:10px;
      border:1px #CCC solid;
    }
  </style>
</head>
<body>
<form method="post" action="/caculator">
  <h1>Simple Caculator</h1>
  <div class="input">
    <label for="firstOperand">First operand: </label>
    <input id="firstOperand" type="text" name="firstOperand" size="30" placeholder="Enter your First operand"><br>
    <label for="operator">Operator: </label>
    <br>
    <select id="operator" name="operator">
      <option value="+">addition</option>
      <option value="-">subtraction</option>
      <option value="*">multiplication</option>
      <option value="/">division</option>
    </select>
    <br>
    <label for="secondOperand">Second Operand: </label>
    <input id="secondOperand" type="text" name="secondOperand" size="30"placeholder="Enter your Second operator">
    <input style="margin-top: 10px" type="submit" value="caculate">
  </div>
</form>
</body>
</html>
