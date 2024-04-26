<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>List</title>
</head>
<body>
<br/>
<center>
    <h1>Employee Manager</h1>
    <h2>
        <a href="/?action=create">Add new employee</a><br>
        <a href="/?action=searchTime">Search over time</a>
    </h2>
</center>
<div align="center" >
    <form method="get" action="/EmployeeServlet?action=search">
        <input type="text" name="jobName" id="search" size="25">
<%--        <input type="hidden" name="action" value="search"/>--%>
        <button type="submit">Search</button>
        <br>
    </form>
</div>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of employee</h2></caption>
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
</body>
</html>