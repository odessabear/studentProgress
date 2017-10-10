<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="log-form-wrapper">
    <form class="log-form" action="/login" method="post">

        <div class="title">
            <strong style="font-size:120%">Вход</strong>
        </div>

        <div class="login-input">
            <label>Логин</label><input type="text" name="login">
        </div>

        <div class="password-input">
            <label>Пароль</label><input type="text" name="password">
        </div>

        <div class="status-input">
            <label>Статуc</label><select name="role">
            <c:forEach items="${roles}" var="item">
                <option value="${item.id}">${item.role}</option>
            </c:forEach>
        </select>
        </div>

        <div class="submit-input">
            <input type="submit" value="Войти">
        </div>

    </form>
</div>