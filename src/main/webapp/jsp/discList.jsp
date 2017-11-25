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
                        <input type="checkbox" name="idDisc" value="${discip.id}">
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
        <a class="button" href="/discipline-create.php">Создать дисциплину</a>
        <a class="button" onclick="modifyDiscipline()">Модифицировать выбранную дисциплину</a>
        <a class="button" onclick="deleteDiscipline()">Удалить выбранные дисциплины</a>
    </div>
    <div id="formDeleteDiv"></div>

    <div id="formModifyDiv">
        <form id="formModify" action="/discipline-modify" method="post">
            <input type="hidden" name="checkboxesModify" id="checkboxesModify"/>
        </form>
    </div>

</div>

