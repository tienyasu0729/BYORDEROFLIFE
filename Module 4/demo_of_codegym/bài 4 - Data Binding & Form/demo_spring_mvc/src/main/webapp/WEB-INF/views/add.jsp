
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="student" method="post">
    ID
    <form:input path="id"/><br>
    Name
    <form:input path="name"/><br>
    Gender
    <form:radiobutton path="gender" value="1"/>NAM
    <form:radiobutton path="gender" value="0"/>NU
    <form:radiobutton path="gender" value="-1"/>LGBT<br>
    Languages
     <form:checkboxes path="languages" items="${languages}"/><br>
<%--    <form:checkbox path="languages" value="JS"/>JS--%>
<%--    <form:checkbox path="languages" value="Java"/>Java--%>
<%--    <form:checkbox path="languages" value="PHP"/>PHP--%>
    <form:button>Save</form:button>
</form:form>

</body>
</html>
