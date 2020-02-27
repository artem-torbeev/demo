<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html >
<html  lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome</title>
</head>
<style>
    .center {
        width: 200px;
        margin: auto;
    }
</style>
<body>
<table align="center">
    <div class="center">

        <c:if test="${username != null}">
            <h3>Welcome : ${username}</h3>
        </c:if>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h3>Welcome : ${pageContext.request.userPrincipal.name}</h3>
        </c:if>

    </div>

    <div>
        <td><a href="${pageContext.request.contextPath}/">Home</a></td>
    </div>
</table>
</body>
</html>
