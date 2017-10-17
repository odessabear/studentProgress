<%--
  Created by IntelliJ IDEA.
  User: alexander.mikhailov
  Date: 06.10.2017
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
            <c:forEach items="${disciplines}" var="discip">
                <tr>
                    <td>
                        <input type="checkbox">
                    </td>
                    <td>
                            ${discip.name}
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
    <div class="admin-panel">
        <a class="button" href="discCreating.html">Создать дисциплину</a>
        <a class="button" href="discModifying.html">Модифицировать выбранную дисциплину</a>
        <a class="button" href="discCreating.html">Удалить выбранную дисциплину</a>
    </div>
</div>

