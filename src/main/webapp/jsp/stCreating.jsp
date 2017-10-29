<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="title">
    <p style="font-size:120%"> Для создания студента заполните все поля и нажмите кнопку "Создать".</p>
</div>

<script>
    $( function() {
        $( "#datepicker" ).datepicker();
    } );
</script>

<div class="log-form-wrapper">
    <form class="create-form" action="/student-create" method="post">

        <div class="surname-input">
            <label>Фамилия</label><input type="text" name="surname">
        </div>

        <div class="name-input">
            <label>Имя</label><input type="text" name="name">
        </div>

        <div class="group-input">
            <label>Группа</label><input type="text" name="group">
        </div>

        <div class="date-in-input">
            <label>Дата поступления</label><input type="text" name="intDate" id="datepicker">
        </div>

        <div class="submit-input">
            <input type="submit" value="Создать">
        </div>
    </form>
</div>

