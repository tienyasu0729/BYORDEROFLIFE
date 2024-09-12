<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/15/2024
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/magazine" >
    <input type="hidden" name="action2" value="addNewMagazine">
        <label for="courseID" class="col-form-label">Magazine ID:</label>
        <input type="text" name="Maz_ID" class="form-control" id="courseID">
        <label for="subject" class="col-form-label">Magazine Title:</label>
        <input type="text" name="Magazine_Title" class="form-control" id="subject">
        <label for="lecturerName" class="col-form-label">Publisher:</label>
        <input type="text" name="Publisher" class="form-control" id="lecturerName">
        <label for="credits" class="col-form-label">Price:</label>
        <input type="number" name="Price" class="form-control" id="credits">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary" id="saveButton">Save</button>
    </div>

</form>
</body>
</html>
