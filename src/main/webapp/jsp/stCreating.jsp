<%--
  Created by IntelliJ IDEA.
  User: alexander.mikhailov
  Date: 06.10.2017
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="enter">
    <p style="font-size:120%"> Для создания студента заполните все поля и нажмите кнопку "Создать".</p>
</div>

<div class="log-form-wrapper">
    <form class="create-form" action="" method="post">

        <div class="surname-input">
            <label>Фамилия</label><input type="text" name="lname">
        </div>

        <div class="name-input">
            <label>Имя</label><input type="text" name="fname">
        </div>

        <div class="group-input">
            <label>Группа</label><input type="text" name="group">
        </div>

        <div class="date-in-input">
            <label>Дата поступления</label><input type="text" name="incName">
        </div>

        <div class="submit-input">
            <input type="submit" value="Создать">
        </div>
    </form>
</div>

