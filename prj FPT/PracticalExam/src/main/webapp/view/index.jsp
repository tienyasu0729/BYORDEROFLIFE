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
    <title>Magazine</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.7.0.min.js"
            integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <%--    đoạn link này để phân trang cho một trang wed--%>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css" />
    <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.js"></script>
    <script src="https://cdn.datatables.net/1.10.23/js/dataTables.bootstrap.min.js"></script>

    <style>
        .form-add, .form-return, .form-late, .form-extend {
            display: inline-block;
        }

        .form-edit, .form-delete {
            display: inline-block;
        }

        .form-payment {
            display: inline;
        }

        .input-error {
            color: red;
            display: none;
        }
    </style>
    <section>
        <p>New magazine added: ${newMagazine.magazineTitle} (ID: ${newMagazine.magID})</p>
        <p>Total visits to add magazine page: ${hitCount}</p>
    </section>

</head>
<body id="background">
<center>
    <h1>Magazine</h1>

    <form method="post" action="/magazine" class="form-return">
        <input type="hidden" name="action" value="create">
        <button class="btn btn-success">Add new magazine</button>
    </form>

    <form method="post" action="/magazine" class="form-return">
        <input type="hidden" name="action" value="reload">
        <button class="btn btn-success">Return</button>
    </form>

</center>

<div align="center">
    <table id="myTable" class="table table-hover" STYLE="text-align: center">
        <h2>Magazine list</h2>
        <thead>
        <tr>
            <th>STT</th>
            <th>Maz ID</th>
            <th>Magazine Title</th>
            <th>Publisher</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <c:set var="count" value="1"/>
        <c:forEach items="${listMagazine}" var="magazine">
            <tr>
                <td><c:out value="${count}"/></td>
                <c:set var="count" value="${count + 1}"/>

                <td><c:out value="${magazine.mazID}"/></td>
                <td><c:out value="${magazine.magazineTitle}"/></td>
                <td><c:out value="${magazine.publisher}"/></td>
                <td><c:out value="${magazine.price}"/></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>

<script>

    // đoạn jquery này để phân trang cho một trang wed
    $(document).ready(function() {
        $('#myTable').DataTable({
            "pageLength": 15,
            "lengthChange": false,

        });
    });
</script>
</body>

</html>
