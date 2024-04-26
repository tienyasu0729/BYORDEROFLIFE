<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Thêm điện thoại cầm mới</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>
    <style>
        /*select[name="name_phone"] optgroup input[type="text"] {*/
        /*    width: 100%;*/
        /*    box-sizing: border-box;*/
        /*}*/
    </style>
</head>
<body>

<center>
    <h1>Thêm điện thoại </h1>
    <form method="post" action="/tienthanh">
        <input type="hidden" name="action" value="list_Android_phone">
        <button class="btn btn-success">Quay lại</button>
    </form>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Thêm mới
                </h2>
            </caption>
            <tr>
                <th>Mã số:</th>
                <td>
                    <input type="number" name="id" size="45" required="required"/>
                </td>
            </tr>
            <tr>
                <th>Họ và tên:</th>
                <td>
                    <input type="text" name="name_owner" size="45" required="required"/>
                </td>
            </tr>
            <tr>
                <th>Loại máy:</th>
                <td>
                        <select name="name_phone" id="mySelect">
                            <optgroup label="Các hãng điện thoại">
                                <option value="samsung">SAMSUNG</option>
                                <option value="oppo">OPPO</option>
                                <option value="realme">REALME</option>
                                <option value="vivo">VIVO</option>
                                <option value="xiaomi">XIAOMI</option>
                                <option value="one_plus">ONE PLUS</option>
                            </optgroup>
                            <optgroup label="Hãng điện thoại khác">
                                <option value="khac">Khác</option>
                            </optgroup>
                        </select>
                        <div id="otherBrand" style="display:none;">
                            <input type="text" id="otherBrandInput" onblur="gg()" placeholder="Nhập tên hãng điện thoại khác...">
                        </div>
                </td>
            </tr>
            <tr>
                <th>PRICE:</th>
                <td>
                    <input type="number" name="price" size="45" required="required">
                </td>
            </tr>
            <tr>
                <th>Ngày cầm:</th>
                <td>
                    <input type="date" name="start_Date" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Tình trạng:</th>
                <td>
                    <input type="text" name="status" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Mật khẩu:</th>
                <td>
                    <input type="text" name="password" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Ghi chú:</th>
                <td>
                    <input name="note" type="text" size="45">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <form>
                        <input type="hidden" name="action2" value="save_create_android_phone">
                        <button type="submit">Save</button>
                    </form>
                </td>
            </tr>
        </table>
    </form>
</div>
<script>
    var select = document.getElementById("mySelect");
    var otherBrandDiv = document.getElementById("otherBrand");
    var otherBrandInput = document.getElementById("otherBrandInput");

    select.addEventListener("change", function() {
        if (select.value === "khac") {
            otherBrandDiv.style.display = "block";
        } else {
            otherBrandDiv.style.display = "none";
        }
    });

    function gg() {
        var otherBrandValue = otherBrandInput.value;
        var otherBrandOption = select.querySelector('option[value="khac"]');
        otherBrandOption.value = otherBrandValue;
    }

</script>
</body>
</html>
