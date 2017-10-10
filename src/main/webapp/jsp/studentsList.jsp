<%--
  Created by IntelliJ IDEA.
  User: alexander.mikhailov
  Date: 06.10.2017
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="termslist-content-wrapper">

    <div class="admin-panel2">
        <a class="button" href="discCreating.html">Просмотреть выбранных студентов</a>
        <a class="button" href="discModifying.html">Создать студента</a>
        <a class="button" href="discCreating.html">Модифицировать выбранного студента</a>
        <a class="button" href="discCreating.html">Удалить выбранного студента</a>
    </div><br>
    <br>

    <h3>Список студентов</h3>

    <div class="students-table-wrapper">
        <table>
            <thead>
            <tr>
                <th class="control"></th>
                <th class="surname">Фамилия</th>
                <th class="name">Имя</th>
                <th class="group">Группа</th>
                <th class="date">Дата поступления</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input type="checkbox"></td>
                <td>Петров</td>
                <td>Петр</td>
                <td>КТ-21</td>
                <td>1/09/2011</td>
            </tr>
            <tr>
                <td><input type="checkbox"></td>
                <td>Сидоров</td>
                <td>Сидор</td>
                <td>КТ-21</td>
                <td>1/09/2011</td>
            </tr>
            <tr>
                <td><input type="checkbox"></td>
                <td>Иванов</td>
                <td>Иван</td>
                <td>КТ-21</td>
                <td>1/09/2011</td>
            </tr>
            <tr>
                <td><input type="checkbox"></td>
                <td>Макаревич</td>
                <td>Андрей</td>
                <td>КТ-21</td>
                <td>1/09/2011</td>
            </tr>
            <tr>
                <td><input type="checkbox"></td>
                <td>Бельгиец</td>
                <td>Василий</td>
                <td>КТ-21</td>
                <td>1/09/2011</td>
            </tr>
            </tbody>
        </table><br>
        <br>
        <br>
    </div>
</div>

