<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="termslist-content-wrapper">

    <div class="admin-panel2">
        <a class="button" onclick= "selectStudent()">Посмотреть успеваемость студента</a>
        <c:if test="${role eq '1'}">
            <a class="button" href="/student-create">Создать студента</a>
            <a class="button" onclick="modifyStudent()">Модифицировать выбранного студента</a>
            <a class="button" onclick="deleteStudent()">Удалить выбранного студента</a>
        </c:if>
    </div>
    <br>
    <div id="formDeleteDiv"></div>
    <div id="formModifyDiv">
        <form id="formModify" action="/students-modifying" method="post">
            <input type="hidden" name="checkboxesModify" id="checkboxesModify"/>
        </form>
    </div>
    <div id="checkboxesToLook">
        <form id="formToLook" action="/students-progress" method="get">
            <input type="hidden" name="checkboxesModify" id="checkboxesModify"/>
        </form>
    </div>

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
            <c:forEach items="${students}" var="st">
                <tr>
                    <td><input type="checkbox" name="idStudent" value="${st.id}"></td>
                    <td>${st.surname}</td>
                    <td>${st.name}</td>
                    <td>${st.group}</td>
                    <td><fmt:formatDate pattern="dd/MM/yyyy"
                                        value="${st.inDate}"/></td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
        <br>
        <br>
        <br>
    </div>
</div>

