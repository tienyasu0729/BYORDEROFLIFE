<%--
  Created by IntelliJ IDEA.
  User: VICTUS
  Date: 6/14/2023
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>

</head>
<body>
<%--@elvariable id="email" type="com.codegym.controller"--%>
<form:form modelAttribute="email" method="post">
    <table>
        <tr>
            <td>Language</td>
            <td>
                <form:select path="language" class="form-select">
                    <c:forEach items="${language}" var="l">
                        <form:option value="${l}"/>
                    </c:forEach>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Page size</td>
            <td>Show
                <form:select path="pageSize" class="form-select">
                    <c:forEach items="${size}" var="s">
                        <form:option value="${s}"/>
                    </c:forEach>
                </form:select>
                emails per page
            </td>
        </tr>
        <tr>
            <td>Spams filter</td>
            <td><form:checkbox path="spamFilter" value="1"/> Enable spams filter</td>
        </tr>
        <tr>
            <td>Signature</td>
            <td><form:textarea path="signature" class="form-textarea"/></td>
        </tr>
        <tr>
            <td>
                <button>Submit</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
