<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Create</title>
</head>
<body>

<p><i>Имя :<c:out value="${user.username}"/></i></p>
<p><i>Email :<c:out value="${user.email}"/></i></p>

<form method="post" action="${pageContext.request.contextPath}/admin/create">

    <p><i>Имя: <label>
        <input type="text" name="name">
    </label></i></p>
    <p><i>Email: <label>
        <input type="text" name="email">
    </label></i></p>

    <p><input type="submit" value="Create"/><br></p>
</form>

</body>
</html>
