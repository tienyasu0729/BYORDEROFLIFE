<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vanna
  Date: 31/03/2023
  Time: 12:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
<div style="text-align: center">
    <h1>Employee Manager</h1>
    <h2>
        <a href="/?action=">List All</a>
    </h2>
</div>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Employee</h2>
            </caption>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45">
                </td>
            </tr>
            <tr>
                <th>Birthday:</th>
                <td>
                    <input type="date" name="birthday" id="birthday" size="45">
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="15">
                </td>
            </tr>
            <tr>
                <th>Start day:</th>
                <td>
                    <input type="date" name="startdate" id="startdate" size="15">
                </td>
            </tr>
            <tr>
                <th>End day:</th>
                <td>
                    <input type="date" name="enddate" id="enddate" size="15">
                </td>
            </tr>
            <tr>
                <th>Salary:</th>
                <td>
                    <input type="text" name="salary" id="salary" size="15">
                </td>
            </tr>
            <tr>
                <th>Job code:</th>
                <td>
                    <label>
                        <select name="jobCode">
                            <c:forEach items="${list}" var="job">
                                <option value="${job.jobCode}"><c:out value="${job.nameJob}"/></option>
                            </c:forEach>
                        </select>
                    </label>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
