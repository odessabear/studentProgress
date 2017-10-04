<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>logining</title>
    <link rel="stylesheet" href="../resourses/css/1-stCSS.css">
</head>
<body>
<h1>Login to the System</h1>

<div class="sub-header-wrapper">
    <h2 class="sub-header"><em>Система управления студентами и их успеваемостью</em></h2>
    <a class="logout-link" href="#">Logout</a>
</div>
<br>

<div class="navigation-links">
    <a href="back.html">Назад</a>
    <a href="title.html">На главную</a>
</div>

<center>
    <div style="font-size:110%">
	<pre><form action="/action_page.java" method="get">
    <b style="font-size:120%">Вход</b> : <br>

	<b>Логин</b>     <input type="text" name="login"><br>

       <b>Пароль</b>     <input type="text" name="password"><br>

<b>Статуc</b>     <select>
					<option>Администратор</option>
					<option>Студент</option>
		            </select><br>

  <input type="submit" value="Войти"><br></pre>
        </form>
    </div>
</center>
</body>
</html>