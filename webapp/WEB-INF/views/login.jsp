<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html  lang="en">
<head>
    <title>Login</title>
</head>
<body>

<c:if test="${param.error != null}">
    <span style="color: red; ">
            <p>Invalid username and password!</p>
    </span>
</c:if>

<div>
    <form action="login" method="post">
        <h2>Login</h2>
        <div>
            <input name="username" type="text" placeholder="Username"/>
            <input name="password" type="password" placeholder="Password"/>
            <button type="submit">Log In</button>
        </div>
    </form>
</div>
</body>
</html>

