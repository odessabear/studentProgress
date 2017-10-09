<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="log-form-wrapper">
    <form class="log-form" action="" method="get">

        <div class="enter">
            <strong style="font-size:120%">Вход</strong>
        </div>

        <div class="login-input">
            <label>Логин</label><input type="text" name="login">
        </div>

        <div class="password-input">
            <label>Пароль</label><input type="text" name="password">
        </div>

        <div class="status-input">
            <label>Статуc</label><select>
            <option>Администратор</option>
            <option>Студент</option>
        </select>
        </div>

        <div class="submit-input">
            <input type="submit" value="Войти">
        </div>

    </form>
</div>