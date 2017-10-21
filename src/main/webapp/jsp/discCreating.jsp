
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="title" style="font-size:120%">
    <p> Для создания новой дисциплины заполните все поля и нажмите кнопку "Создать".</p>
</div>
<div class="log-form-wrapper">
    <form class="create-form" action="/discipline-create.php" method="post">
        <div class="discipline-input">
            <label>Название дисциплины</label>`<input type="text" name="discipline">
        </div>
        <div class="submit-input">
            <input type="submit" value="Создать">
        </div>
    </form>
</div>
