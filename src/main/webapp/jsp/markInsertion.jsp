<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="termslist-content-wrapper">
    <h3>Отображена успеваемость следующего студента</h3>
    <script>
        $(function () {
            $("#datepicker").datepicker();
        });

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
                <th>ID</th>
                <th>Дисциплина</th>
                <th>Оценка</th>

            </tr>
            </thead>

            <tbody>

            <tr>
                <td></td>
                <td></td>
                <td></td>

            </tr>

            </tbody>
        </table>
        <br>

    </div>
    <div class="select-panel">
        <form action="/marks-insertion" method="get">
            <label><strong>Выбрать семестр</strong></label>
            <select id="selectedTerm" name="termsList">
                <c:forEach items="${termsList}" var="term">
                    <option value="${term.termId}">${term.termsName}</option>
                </c:forEach>
            </select>

        </form>
        <script>
            $('#selectedTerm').click(function () {
                var selectedValue = $(this).val();
                console.log("we want to select " + selectedValue + " term");
                var studentId=${student.id};

                $.ajax({
                   type:'get',

                });

            });
        </script>

    </div>


</div>

