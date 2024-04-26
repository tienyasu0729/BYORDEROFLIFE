<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 19/03/2023
  Time: 10:45 CH
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Thêm sản phẩm mới</title>
</head>
<body>
<h1> Create product</h1>
<form action="/create" method="post">
    <table>
        <tr>
            <td>ID</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>Tên sản phẩm</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Giá sản phẩm</td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td>Mô tả</td>
            <td><input type="text" name="describe"></td>
        </tr>
        <tr>
            <td>Nhà sản xuất</td>
            <td><input type="text" name="producer"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Create"></td>
        </tr>
    </table>
    <input type="hidden" name="action" value="create">
</form>
</body>
</html>