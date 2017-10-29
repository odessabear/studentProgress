
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="title" style="font-size:120%">
    <p> Чтобы модифицировать дисциплину введите новое значение поля и нажмите кнопку "Применить".</p>
</div>
<div class="log-form-wrapper">
    <form class="create-form" action="/discipline-modify-submit" method="post">
        <div class="discipline-input">
            <label>Название дисциплины</label><input type="text" name="nameDiscipline" value="${discipline.name}">
        </div>
        <input type="hidden" name="idDiscipline" value="${discipline.id}">
        <div class="submit-input">
            <input type="submit" value="Применить">
        </div>
    </form>
</div>
