<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: vanna
  Date: 02/04/2023
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search over time</title>
</head>
<body>
<div style="text-align: center">
    <h1>Employee Manager</h1>
    <h2>
        <a href="/?action=">List All</a>
    </h2>
</div>
<div align="center">
    <form method="get">
        <input type="hidden" name="action" value="submit"/>
        <input type="date" name="dayStart" size="15" value="${param.dayStart}" />
        <input type="date" name="dayEnd" size="15" value="${param.dayEnd}" /><br>
        <button type="submit">Search</button>
    </form>
</div>
<c:if test="${employeeList != null}">
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List search of employee</h2></caption>
            <tr>
                <th>STT</th>
                <th>Name</th>
                <th>Birthday</th>
                <th>Address</th>
                <th>Start day</th>
                <th>End day</th>
                <th>Salary</th>
                <th>Name job</th>
                <th>Status</th>
            </tr>
            <c:set var="count" value="0"/>
            <c:forEach var="e" items="${employeeList}">
                <tr>
                    <td><c:out value="${count + 1}"/></td>
                    <td><c:out value="${e.name}"/></td>
                    <td><fmt:formatDate value="${e.birthday}" pattern="dd/MM/yyyy"/></td>
                    <td><c:out value="${e.address}"/></td>
                    <td><fmt:formatDate value="${e.startDate}" pattern="dd/MM/yyyy"/></td>
                    <td><fmt:formatDate value="${e.endDate}" pattern="dd/MM/yyyy"/></td>
                    <td><c:out value="${e.salary}"/></td>
                    <td><c:out value="${e.nameJob}"/></td>
                    <td><a href="/?action=edit&id=${e.id}">Edit</a>
                        <a href="/?action=delete&id=${e.id}">Delete</a></td>
                </tr>
                <c:set var="count" value="${count + 1}"/>
            </c:forEach>
        </table>
    </div>
<%--    <c:redirect url="searchTime.jsp"/>--%>
</c:if>
</body>
</html>
