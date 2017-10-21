<%--
  Created by IntelliJ IDEA.
  User: alexander.mikhailov
  Date: 06.10.2017
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="title" style="font-size:120%">
    <p> Чтобы модифицировать дисциплину введите новое значение поля и нажмите кнопку "Применить".</p>
</div>
<div class="log-form-wrapper">
    <form class="create-form" action="" method="get">
        <div class="discipline-input">
            <label>Название дисциплины</label><input type="text" name="lname" value="${discipline.name}">
        </div>
        <div class="submit-input">
            <input type="submit" value="Применить">
        </div>
    </form>
</div>
