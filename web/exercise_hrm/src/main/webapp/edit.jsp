<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vanna
  Date: 31/03/2023
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit information</title>
</head>
<body>
<center>
    <h1>Employee management</h1>
    <h2>
        <a href="?action=">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit employee
                </h2>
            </caption>
            <c:if test="${list != null}">
                <input type="hidden" name="id" value="<c:out value="${list.id}" />">
            </c:if>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" size="45" value="<c:out value="${list.name}"/> ">
                </td>
            </tr>
            <tr>
                <th>Birthday:</th>
                <td>
                    <input type="date" name="birthday" size="45"
                           value="<c:out value="${list.birthday}"/>">
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" size="45" value="<c:out value="${list.address}"/> ">
                </td>
            </tr>
            <tr>
                <th>Start day:</th>
                <td>
                    <input type="date" name="startdate" size="45"
                           value="<c:out value="${list.startDate}"/>">
                </td>
            </tr>
            <tr>
                <th>End day:</th>
                <td>
                    <input type="date" name="enddate" size="45" value="<c:out value="${list.endDate}"/>">
                </td>
            </tr>
            <tr>
                <th>Salary:</th>
                <td>
                    <input type="text" name="salary" size="15" value="<c:out value="${list.salary}"/>">
                </td>
            </tr>
            <tr>
                <th>Job code:</th>
                <td>
                    <label>
                        <select name="jobCode">
                            <c:forEach items="${listJob}" var="job">
                                <option value="${job.jobCode}"><c:out value="${job.nameJob}"/></option>
                            </c:forEach>
                        </select>
                    </label>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Update">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
