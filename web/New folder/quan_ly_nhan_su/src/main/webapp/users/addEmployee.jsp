<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 4/14/2022
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <table border="1">
        <tr>
            <th>Full Name</th>
            <td><input type="text" name="name" placeholder="Please enter your name"></td>
        </tr>
        <tr>
        <th>Birthday</th>
        <td><input type="date" name="birthday"></td>
        </tr>
        <tr>
            <th>Address</th>
            <td><input type="text" name="address" placeholder="Please enter your address"></td>
        </tr>
        <tr>
        <th>Start Date</th>
        <td><input type="date" name="startDate"></td>
        </tr>
        <tr>
            <th>End Date</th>
            <td><input type="date" name="endDate"></td>
        </tr>
        <tr>
            <th>Salary</th>
            <td><input type="number" name="salary" placeholder="Please enter your salary"></td>
        </tr>
        <tr>
            <th>ID Job</th>
            <td>
                <select name="idJob">
                    <option value=""></option>
                </select>
            </td>
        </tr>
    </table>
<%--    <label>Tên học sinh:</label>--%>
<%--    <input type="text" name="name"><br>--%>
<%--    <p style="color:red;">${error.get("name")}</p>--%>
<%--    <label>Ngày sinh:</label>--%>
<%--    <input type="date" name="dateOfBirth"><br>--%>
<%--    <label>Điểm:</label>--%>
<%--    <input type="number" name="grade"><br>--%>
<%--    <label>Giới tính:</label>--%>
<%--    <select name="gender">--%>
<%--        <option value="1">Nam</option>--%>
<%--        <option value="0">Nữ</option>--%>
<%--        <option value="-1">Khác</option>--%>
<%--    </select>--%>
<%--    <button type="submit">Save</button>--%>
</form>
</body>
</html>
