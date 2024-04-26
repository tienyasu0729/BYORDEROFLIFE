<%--
  Created by IntelliJ IDEA.
  User: linht
  Date: 3/10/2023
  Time: 7:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
    <h1>Create student</h1>
    <form action="/student" method="post">
        <table>
            <tr>
                <td>ID</td>
                <td><input type="text" name="id" /></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr>
                <td>Gioi Tinh</td>
                <td><select name="sex">
                    <option value="1">Nam</option>
                    <option value="0">Nữ</option>
                </select></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Register"></td>
            </tr>
        </table>
        <input type="hidden" name="action" value="create">
    </form>
</body>
</html>
