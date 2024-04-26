<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 08/06/2023
  Time: 12:43 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Ứng dụng chuyển đổi tiền tệ</h1>
<form action="/swap" method="post">
    <label for="money">Số tiền việt cần chuyển đổi</label>
    <input type="text" name="moneyNeedSwap" id="money"><br>
    <label for="exchangeRace">Tỉ giá</label>
    <input type="number" name="exchangeRace" id="exchangeRace"><br>
    <button type="submit">chuyển đổi</button>
</form>
</body>
</html>
