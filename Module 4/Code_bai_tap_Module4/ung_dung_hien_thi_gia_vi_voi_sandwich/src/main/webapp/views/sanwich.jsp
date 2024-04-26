<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 11/06/2023
  Time: 9:31 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sanwich Condiments</h1>
<form action="/sss" method="post">
    <label><input type="checkbox" name="spice" value="Lettuce">Lettuce</label>
    <label><input type="checkbox" name="spice" value="Tomato">Tomato</label>
    <label><input type="checkbox" name="spice" value="Mustacrd">Mustacrd</label>
    <label><input type="checkbox" name="spice" value="sprouts">sprouts</label><br>
    <button>Save</button>
</form>
<h1>${showSpice}</h1>
</body>
</html>
