<%--
  Created by IntelliJ IDEA.
  User: alexander.mikhailov
  Date: 06.10.2017
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="termslist-content-wrapper">

    <h3>Список дисциплин</h3>

    <div class="disciplie-table-wrapper">

        <table>
            <thead>
            <tr>
                <th></th>
                <th>Наименование дисциплины</th>
            </tr>
            </thead>

            <tbody>
            <tr>
                <td>
                    <input type="checkbox">
                </td>
                <td>
                    Высшая математика
                </td>
            </tr>

            <tr>
                <td>
                    <input type="checkbox">
                </td>
                <td>
                    Политология
                </td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox">
                </td>
                <td>
                    История Науки и Техники
                </td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox">
                </td>
                <td>
                    Информатика
                </td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox">
                </td>
                <td>
                    Теория Алгоритмизации
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="admin-panel">
        <a class="button" href="discCreating.html">Создать дисциплину</a>
        <a class="button" href="discModifying.html">Модифицировать выбранную дисциплину</a>
        <a class="button" href="discCreating.html">Удалить выбранную дисциплину</a>
    </div>
</div>
</body>
</html>
