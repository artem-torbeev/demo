<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html  lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>
</head>
<body>
<div>
    <form action="register" method="post">
        <h2>Register</h2>
        <div>
            <label>
                <input name="username" type="text" placeholder="Username"/>
            </label>
            <label>
                <input name="email" type="text" placeholder="Email"/>
            </label>
            <label>
                <input name="password" type="password" placeholder="Password"/>
            </label>

            <button type="submit">Register</button>

        </div>
    </form>
</div>
</body>
</html>
