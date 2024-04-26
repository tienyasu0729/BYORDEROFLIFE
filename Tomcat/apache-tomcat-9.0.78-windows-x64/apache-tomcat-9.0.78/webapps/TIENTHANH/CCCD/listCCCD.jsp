<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 27-Mar-23
  Time: 6:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tiệm cầm đồ Tiến Thanh</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        .form-edit, .form-delete,.form-pay {
            display: inline-block;
        }
    </style>
</head>
<body>
<center>
    <h1>Cầm đồ Tiến Thanh</h1>

        <form method="post" action="/tienthanh">
            <input type="hidden" name="action" value="create">
            <button class="btn btn-success">Thêm CCCD cầm mới</button>
        </form>

        <form method="post" action="/tienthanh">
            <input type="hidden" name="action" value="watchDetailList">
            <button class="btn btn-success">Xem danh sách chi tiết</button>
        </form>
    <form method="post" action="/tienthanh">
        <input type="hidden" name="action" value="reload">
        <button class="btn btn-success">Tải lại trang</button>
    </form>
    <form method="post" action="/tienthanh">
        <input type="hidden" name="action" value="watchLateList">
        <button class="btn btn-success">Xem danh sách trễ hạn</button>
    </form>
    <form method="post" action="/tienthanh">
        <input type="hidden" name="action" value="watchNearTermList">
        <button class="btn btn-success">Xem danh sách gần tới hạn</button>
    </form>
    <div class="search">
        <form action="/tienthanh" method="post">
            <h2>Tìm kiếm CCCD theo mã số</h2>
            <input type="text" name="findByCccd" placeholder="Tìm kiếm theo mã số CCCD">
            <input type="hidden" value="search" name="action2">
            <button type="submit">Tìm kiếm</button> 
        </form>
    </div>

    <div class="search">
        <form action="/tienthanh" method="post">
            <h2>Tìm kiếm CCCD theo tên</h2>
            <input type="text" name="findByName" placeholder="Tìm CCCD theo tên">
            <input type="hidden" value="search" name="action2">
            <button type="submit">Tìm kiếm</button>
        </form>
    </div>
</center>
<div align="center">
    <table class="table table-hover"    STYLE="text-align: center">
        <h2>Danh sách CCCD cầm</h2>
        <caption><h2>Danh sách CCCD cầm</h2></caption>
        <tr>
            <th>STT</th>
            <th>CCCD</th>
            <th>Họ và Tên</th>
            <th>Số tiền cầm</th>
            <th>Ngày cầm</th>
            <th>Chi tiết</th>

        </tr>
        <% int count = 1; %>
        <c:forEach items="${listCCCD}" var="android_phone">
            <tr>
               <td><%=count%></td>
                <% count++; %>

                <td><c:out value="${android_phone.cccd}"/></td>
                <td><c:out value="${android_phone.name}"/></td>
                <td><fmt:formatNumber value="${android_phone.price}" pattern="###,###,###,###"/></td>
                <td><fmt:formatDate value="${android_phone.startDate}" pattern="dd/MM/yyyy"/></td>
<%--                <td><c:out value="${CCCD.checkForDetail}"/></td>--%>
                <td>
                    <c:choose>
                        <c:when test="${android_phone.checkForDetail == 0}">
                            <form action="/tienthanh" method="post" class="form-edit">
                                <input type="hidden" name="action2" value="watchDetail">
                                <input type="hidden" name="idDetail" value="${android_phone.cccd}">
                                <button type="submit" class="btn btn-success" onclick="changeButtonText(this)">Xem chi tiết</button>
                            </form>
                        </c:when>
                        <c:otherwise>
                            <button class="btn btn-success" onclick="window.alert('Chưa có thông tin của người này')">Không có chi tiết</button>
                        </c:otherwise>
                    </c:choose>
                </td>
<%--                <td>--%>
                        <%--                        &lt;%&ndash; Khởi tạo biến tên của nút &ndash;%&gt;--%>
                        <%--                        <c:set var="buttonName" value="Xem chi tiết" />--%>

                        <%--                        &lt;%&ndash; Kiểm tra giá trị của CCCD.checkForDetail &ndash;%&gt;--%>
                        <%--                    <c:choose>--%>
                        <%--                    <c:when test="${CCCD.checkForDetail == 1}">--%>
                        <%--                        &lt;%&ndash; Nếu không có chi tiết, thay đổi tên của nút &ndash;%&gt;--%>
                        <%--                        <c:set var="buttonName" value="Không có chi tiết" />--%>
                        <%--                    </c:when>--%>
                        <%--                    </c:choose>--%>

                        <%--                        &lt;%&ndash; Hiển thị nút với tên tương ứng &ndash;%&gt;--%>
                        <%--                    <form action="/tienthanh" method="post" class="form-edit">--%>
                        <%--                        <input type="hidden" name="action2" value="watchDetail">--%>
                        <%--                        <input type="hidden" name="idDetail" value="${CCCD.cccd}">--%>
                        <%--                        <button type="submit" class="btn btn-success">${buttonName}</button>--%>
                        <%--                    </form>--%>
<%--                </td>--%>

<%--                    <button>Không có chi tiết</button>--%>

<%--                <td>--%>
<%--                        &lt;%&ndash;                    <form action="/tienthanh" method="post" class="form-edit">&ndash;%&gt;--%>
<%--                        &lt;%&ndash;                        <input type="hidden" name="action2" value="watchDetail">&ndash;%&gt;--%>
<%--                        &lt;%&ndash;                        <input type="hidden" name="idDetail" value="${CCCD.cccd}">&ndash;%&gt;--%>
<%--                        &lt;%&ndash;                        <button type="submit" class="btn btn-success" onclick="changeButtonText(this)">Xem chi tiết</button>&ndash;%&gt;--%>
<%--                        &lt;%&ndash;                    </form>&ndash;%&gt;--%>
<%--                </td>--%>

                <td>
                    <form action="/tienthanh" method="post" class="form-edit">
                        <input type="hidden" name="action" value="edit">
                        <input type="hidden" name="idEdit" value="${android_phone.cccd}">
                        <button type="submit" class="btn btn-success">Chỉnh sửa</button>
                    </form>

                    <form action="/tienthanh" method="post" class="form-delete">
                        <input type="hidden" name="action2" value="delete">
                        <input type="hidden" name="id" value="${android_phone.cccd}">
                        <button type="submit" class="btn btn-danger"
                                onclick="return confirm('Bạn có chắc chắn muốn xoá không?')">Xoá
                        </button>
                    </form>
                    <form action="/tienthanh" method="post" class="form-pay">
                        <input type="hidden" name="action2" value="interestPayment">
                        <input type="hidden" name="id" value="${android_phone.cccd}">
                        <button type="submit" class="btn btn-warning">Tính lãi</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<script> //  script này để ngăn người dùng nhấn chuột phải rồi nhấn kiểm tra để xem được code html
    document.addEventListener("contextmenu", function(e){
        e.preventDefault();
    }, false);
</script>

<%--<script>--%>
<%--    function changeButtonText(button) {--%>
<%--        if (button.value == 0) {--%>
<%--            button.innerHTML = 'Xem chi tiết';--%>
<%--        } else {--%>
<%--            button.innerHTML = 'Không có chi tiết';--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>
</body>

</html>
