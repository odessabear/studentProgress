<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="termslist-content-wrapper">
    <h3>Отображена успеваемость следующего студента</h3>
    <script>
        $(function () {
            $("#datepicker").datepicker();
        });

        function getSelectedValue() {
            var selectedValue = document.getElementById("selectedTerm").value;
            console.log(selectedValue);
        }

    </script>
    <div class="studinfo-table-wrapper">
        <input type="hidden" name="id" value="${student.id}">
        <table>
            <thead>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Группа</th>
            <th>Дата поступления</th>
            </thead>
            <tbody>
            <td>${student.surname}</td>
            <td>${student.name}</td>
            <td>${student.group}</td>
            <td><fmt:formatDate pattern="dd/MM/yyyy"
                                value="${student.inDate}"/></td>
            </tbody>
        </table>
        <br>
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
                    ${discipline}
                </td>
                <td>
                    ${mark}
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="select-panel">
        <form  action="#" >
            <label><strong>Выбрать семестр</strong></label>
            <select id="selectedTerm" name="terms" onchange="getSelectedValue()">

                <option >${term}</option>

            </select>
        </form>
        <h4>Средний бал за семестр:</h4>
    </div>


</div>

