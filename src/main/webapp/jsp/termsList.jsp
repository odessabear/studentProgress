<%--
  Created by IntelliJ IDEA.
  User: alexander.mikhailov
  Date: 06.10.2017
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="termslist-content-wrapper">
    <form action="select1.php" method="post">
        <label>Выбрать семестр</label>
        <select>
            <option>Семестр 1</option>
            <option>Семестр 2</option>
            <option>Семестр 3</option>
        </select>
    </form>
    <h3>Длительность семестра: 24 недели</h3>

    <h4>Список дисциплин</h4>

    <ul class="discipline">
        <li>Высшая Математика</li>
        <li>Политология</li>
        <li>История Науки и Техники</li>
        <li>Информатика</li>
        <li>Теория Алгоритмизации</li>
    </ul>

    <div class="admin-panel">
        <a class="button" href="termCreating.html">Создать семестр</a>
        <a class="button" href="termModifying.html">Модифицировать ввыбранный семестр</a>
        <a class="button" href="termCreating.html">Удалить выбранный семестр</a>
    </div>
</div>
</body>
</html>
