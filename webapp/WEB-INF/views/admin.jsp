<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>List</title>
    <style>
        table {
            width: 600px; /* Ширина таблицы */
            border: 4px double black; /* Рамка вокруг таблицы */
            border-collapse: collapse; /* Отображать только одинарные линии */
        }
        th, td {
            text-align: left; /* Выравнивание по левому краю */
            padding: 5px; /* Поля вокруг содержимого ячеек */
            border: 1px solid black; /* Граница вокруг ячеек */
        }
    </style>
</head>
<body>

<h2>Все пользователи</h2>

<table>
    <tr>
        <th>Имя</th>
        <th>Email</th>
        <th>Role</th>
        <th>Action</th>
    </tr>

    <c:forEach var="user" items="${listUser}">
        <tr>
            <td><i><c:out value="${user.username}"/></i></td>
            <td><i><c:out value="${user.email}"/></i></td>
            <td>
                <c:forEach items="${user.role}" var="role">${role.role} </c:forEach>
            </td>

            <td>
                <a href="${pageContext.request.contextPath}/admin/edit/<c:out value='${user.id}' />">Edit</a>
                <a href="${pageContext.request.contextPath}/delete/<c:out value='${user.id}' />">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<p><b><a href="${pageContext.request.contextPath}/admin/create">Create</a></b></p>


<c:if test="${pageContext.request.userPrincipal.name != null}">
    <div class="center">
        <h3>Welcome : ${pageContext.request.userPrincipal.name}</h3>
        <p><a href="<c:url value="/logout" />">Logout</a></p>
    </div>
</c:if>

<%--<p><i>Имя: <c:out value="${Message}"/></i></p>--%>
<%--${pageContext.servletContext.contextPath}/edit--%>

</body>
</html>

