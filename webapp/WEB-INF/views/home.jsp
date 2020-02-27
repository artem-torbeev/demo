<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome</title>
    <style>
        .center {
            width: 200px;
            margin: auto;
        }
    </style>
</head>
<body>
<table align="center">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <div class="center">
            <h3>Welcome : ${pageContext.request.userPrincipal.name}</h3>
            <p><a href="<c:url value="/logout" />">Logout</a></p>
        </div>
    </c:if>

    <div>
        <td><a href="${pageContext.request.contextPath}/admin">Admin</a>
        </td>
        <td><a href="${pageContext.request.contextPath}/register">Register</a>
        </td>
        <td><a href="${pageContext.request.contextPath}/login">Login</a>
        </td>
    </div>

</table>
</body>
</html>
