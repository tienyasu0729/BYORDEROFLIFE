<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: VICTUS
  Date: 6/15/2023
  Time: 7:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Music</title>

</head>
<body>
<h1>List of Music</h1>
<table>
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Author</th>
        <th>Genres</th>
    </tr>
    <c:forEach items="${showList}" var="music" varStatus="count">
        <tr>
            <td>${count.count}</td>
            <td>${music.nameMusic}</td>
            <td>${music.author}</td>
            <td>${music.musicGenres}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>