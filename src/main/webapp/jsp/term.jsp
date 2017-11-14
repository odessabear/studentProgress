<%--
  Created by IntelliJ IDEA.
  User: alexander.mikhailov
  Date: 06.10.2017
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="title" style="font-size:120%">
    <p> Для создания семестра заполните все поля и нажмите кнопку "Создать".</p>
</div>

<div class="term-form-wrapper">

    <form method="post" id="createTermForm">
        <label for="duration">Duration</label>
        <input id="duration" type="text" value="${term.duration}" disabled/>

        <br/>
        Disciplines
        <br/>

        <c:forEach items="${term.disciplines}" var="discipline">

            <input id="discipline_${discipline.id}" type="text" value="${discipline.name}" disabled/>
            <br/>
        </c:forEach>

    </form>

    <table>

    </table>

</div>
