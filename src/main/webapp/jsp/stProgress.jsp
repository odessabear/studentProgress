<%--
  Created by IntelliJ IDEA.
  User: alexander.mikhailov
  Date: 06.10.2017
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="termslist-content-wrapper">
    <h3>Отображена успеваемость следующего студента</h3>
    <div class="studinfo-table-wrapper">
        <table>
            <thead>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Группа</th>
            <th>Дата поступления</th>
            </thead>
            <tbody>
            <td>Петров</td>
            <td>Петр</td>
            <td>КТ-21</td>
            <td>1/09/2011</td>
            </tbody>
        </table><br>
        <br>
        <br>
    </div>
    <div class="marks-table-wrapper">
        <table>
            <thead>
            <tr>
                <th>Дисциплина</th>
                <th>Оценка</th>
            </tr>
            </thead>

            <tbody>
            <tr>
                <td>
                    Высшая математика
                </td>
                <td>
                    5
                </td>
            </tr>

            <tr>
                <td>
                    Политология
                </td>
                <td>
                    4
                </td>
            </tr>
            <tr>
                <td>
                    История Науки и Техники
                </td>
                <td>
                    5
                </td>
            </tr>
            <tr>
                <td>
                    Информатика
                </td>
                <td>
                    4
                </td>
            </tr>
            <tr>
                <td>
                    Теория Алгоритмизации
                </td>
                <td>
                    5
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="select-panel">
        <form action="select1.php" method="get">
            <label><strong>Выбрать семестр</strong></label>
            <select>
                <option>Семестр 1</option>
                <option>Семестр 2</option>
                <option>Семестр 3</option>
            </select>
        </form>
        <h4>Средний бал за семестр:</h4>
    </div>


</div>
</body>
</html>
