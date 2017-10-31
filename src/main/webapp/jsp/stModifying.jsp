<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<div class="title" style="font-size:120%">
    <p> Для модификации,введите новые значения и нажмите кнопку "Применить"</p>
</div>
<script>
    $( function() {
        $( "#datepicker" ).datepicker();
    } );
</script>

<div class="log-form-wrapper">
    <form class="create-form" action="/students-modifying-submit" method="post">
        <input type="hidden" name="id" value="${student.id}">

        <div class="surname-input">
            <label>Фамилия</label><input type="text" name="surname" value="${student.surname}">
        </div>

        <div class="name-input">
            <label>Имя</label><input type="text" name="name" value="${student.name}">
        </div>

        <div class="group-input">
            <label>Группа</label><input type="text" name="group" value="${student.group}">
        </div>

        <div class="date-in-input">
            <label>Дата поступления</label><input type="text" name="inDate" value="<fmt:formatDate pattern = "dd/MM/yyyy"
                                        value = "${student.inDate}" />" id="datepicker">
        </div>

        <div class="submit-input">
            <input type="submit" value="Применить">
        </div>

    </form>
</div>
