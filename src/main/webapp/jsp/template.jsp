<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>disciplineList</title>
    <link rel="stylesheet" href="/resourses/css/1-stCSS.css">
</head>
<body>
<h1>Disciplines List</h1>

<div class="sub-header-wrapper">
    <h2 class="sub-header"><em>Система управления студентами и их успеваемостью</em></h2>
    <c:if test="${currentPage ne 'login.jsp'}"><a class="logout-link" href="/logout">Logout</a></c:if>

</div>
<br>
<c:if test="${currentPage ne 'login.jsp' && currentPage ne 'title.jsp'}">
    <div class="navigation-links">
        <a href="back.html">Назад</a>
        <a href="title.html">На главную</a>
    </div>
</c:if>

<jsp:include page="${currentPage}"/>
<c:choose>
    <c:when test="${errorMessage=='1'}">
        Логин или пароль введены неверно.
        <br />
    </c:when>
    <c:when test="${errorMessage=='2'}">
        Вы вошли не под своей ролью.
        <br />
    </c:when>
    <c:otherwise>
    </c:otherwise>
</c:choose>
</body>
</html>
