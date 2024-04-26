<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 27-Mar-23
  Time: 7:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản lý sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<center>
    <h1>Edit product</h1>
    <h2>
        <a href="list?action=list">List product</a>
    </h2>
</center>
<div align="center">
    <form method="post" action="/list">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Product
                </h2>
            </caption>
            <tr>
                <th>NAME:</th>
                <td>
                    <input type="text" id="name" name="name" size="45" onblur="checkName()" placeholder="${productDetail.name}">
                    <br>
                    <a class="check" id="messName"></a>
                </td>
            </tr>
            <tr>
                <th>PRICE:</th>
                <td>
                    <input type="number" id="price" name="price" size="45" onblur="checkPrice()" placeholder="${productDetail.price}">
                    <br>
                    <a class="check" id="messPrice"></a>
                </td>
            </tr>
            <tr>
                <th>QUANTITY:</th>
                <td>
                    <input type="number" name="quantity" size="15" placeholder="${productDetail.quantity}">
                </td>
            </tr>
            <tr>
                <th>COLOR:</th>
                <td>
                    <label><input type="checkbox" name="color[]" value="red"> Red</label><br>
                    <label><input type="checkbox" name="color[]" value="blue"> Blue</label><br>
                    <label><input type="checkbox" name="color[]" value="Black"> Black</label><br>
                    <label><input type="checkbox" name="color[]" value="white"> White</label><br>
                    <label><input type="checkbox" name="color[]" value="yellow"> Yellow</label>
                </td>
            </tr>
            <tr>
                <th>DESCRIPTION:</th>
                <td>
                    <input type="text" name="description" size="15" placeholder="${productDetail.description}">
                </td>
            </tr>
            <tr>
                <th>CATEGORY:</th>
                <td>
                    <select name="category">
                        <c:forEach items="${listCategory}" var="category">
                            <option value="${category.id}"><c:out value="${category.name}"></c:out></option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="hidden" name="idEdit" value="${product}">
                    <input type="hidden" value="Edit" name="action2">
                    <button type="submit" class="btn btn-outline-primary">Save</button>
                </td>
            </tr>
        </table>
    </form>
</div>
<script src="validate.js"></script>
</body>
</html>
