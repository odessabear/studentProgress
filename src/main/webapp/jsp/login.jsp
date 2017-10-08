<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<center>
    <div style="font-size:110%">
	<pre><form action="/login" method="post">
    <b style="font-size:120%">Вход</b> : <br>

	<b>Логин</b>     <input type="text" name="login"><br>

       <b>Пароль</b>     <input type="text" name="password"><br>

<b>Статуc</b>     <select name="role">
					<option value="admin">Администратор</option>
					<option value="student">Студент</option>
		            </select><br>

  <input type="submit" value="Войти"><br></pre>
        </form>
    </div>
</center>
