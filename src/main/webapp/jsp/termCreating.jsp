<%--
  Created by IntelliJ IDEA.
  User: alexander.mikhailov
  Date: 06.10.2017
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="title" style="font-size:120%">
    <p> Для создания семестра заполните все поля и нажмите кнопку "Создать".</p>
</div>
<div class="log-form-wrapper">
    <form class="term-create-form" action="/term-create" method="post">
        <div class="term-name-input">
            <label>Название семестра</label><input type="text" name="${termsName}">
        </div>
        <div class="term-length-input">
            <label>Длительность(в неделях)</label><input type="text" name="${valueOfDuration}">
        </div>
        <div class="term-discipline-input">
            <label>Дисциплины в семестре</label>
            <select name="select" size="8" multiple>
                <option selected value="s1">Информатика</option>
                <option value="s2">Политология</option>
                <option value="s3">Социология</option>
                <option value="s4">Высшая Математика</option>
                <option value="s4">Теория Алгоритмизации</option>
                <option value="s4">Теория Игр</option>
                <option value="s4">Булева Алгебра</option>
                <option value="s4">Системный анализ</option>
            </select>
        </div>
        <div class="term-submit-input">
            <input type="submit" value="Создать">
        </div>
    </form>
</div>
