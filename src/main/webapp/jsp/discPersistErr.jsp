<%--
  Created by IntelliJ IDEA.
  User: alexander.mikhailov
  Date: 06.10.2017
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="title" style="font-size:120%">
    <p> Для создания новой дисциплины заполните все поля и нажмите кнопку "Создать".</p>
</div>
<div class="log-form-wrapper">
    <form class="create-form" action="" method="get">
        <div class="discipline-input">
            <label>Название дисциплины</label><input type="text" name="lname">
        </div>
        <div class="submit-input">
            <input type="submit" value="Создать">
        </div>
    </form>
</div>
<div class="warning">
    <strong style="color:#ff0000">Поля не должны быть пустыми !!!</strong>
</div>