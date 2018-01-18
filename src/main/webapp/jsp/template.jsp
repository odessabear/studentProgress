<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <c:choose>
        <c:when test="${currentPage=='login.jsp'}">
            <title>Вход в систему управления студентами</title>
        </c:when>
        <c:when test="${currentPage=='title.jsp'}">
            <title>Система управления студентами</title>
        </c:when>

        <c:when test="${currentPage=='discList.jsp'}">
            <title>Список дисциплин</title>
        </c:when>
        <c:when test="${currentPage=='allTermsList.jsp'}">
            <title>Список Семестров</title>
        </c:when>

        <c:otherwise>
        </c:otherwise>
    </c:choose>
    <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
    <link rel="stylesheet" href="/resourses/css/1-stCSS.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="/resourses/js/jsFunction.js"></script>
    <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>

</head>
<body>

<div class="sub-header-wrapper">
    <h2 class="sub-header"><em>Система управления студентами и их успеваемостью</em></h2>
    <c:if test="${currentPage ne 'login.jsp'}"><a class="logout-link" href="/logout">Logout</a></c:if>

</div>
<br>
<c:if test="${currentPage ne 'login.jsp' && currentPage ne 'title.jsp'}">
    <div class="navigation-links">
        <c:if test="${currentPage ne 'studentsList.jsp' && currentPage ne 'discList.jsp' && currentPage ne 'allTermsList.jsp.jsp'}">
            <c:choose>
                <c:when test="${ currentPage =='discModifying.jsp' ||  currentPage =='discCreating.jsp'}">
                    <a href="/discipline-list">Назад</a>
                </c:when>
                <c:when test="${ currentPage =='stModifying.jsp' ||  currentPage =='stCreating.jsp' || currentPage =='stProgress.jsp'}">
                    <a href="/students-list">Назад</a>
                </c:when>
                <c:when test="${ currentPage =='termModifying.jsp' ||  currentPage =='term.jsp'}">
                    <a href="/terms-list">Назад</a>
                </c:when>
                <c:otherwise>
                </c:otherwise>

            </c:choose>

        </c:if>
        <a href="/home">На главную</a>
    </div>
</c:if>

<jsp:include page="${currentPage}"/>
<div class="warning">
<c:choose>
    <c:when test="${errorMessage=='1'}">
        Login or password entered incorrectly.
        <br/>
    </c:when>
    <c:when test="${errorMessage=='2'}">
        You did not enter under your role.
        <br/>
    </c:when>
    <c:when test="${errorMessage=='3'}">
        All fields must be filled!
        <br/>
    </c:when>
    <c:when test="${errorMessage=='4'}">
        Something is wrong.Try again later!
        <br/>
    </c:when>
    <c:when test="${errorMessage=='5'}">
        You entered an invalid value!
        <br/>
    </c:when>
    <c:otherwise>
    </c:otherwise>
</c:choose>
</div>
</body>
</html>
