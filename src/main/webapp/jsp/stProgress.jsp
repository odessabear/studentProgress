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
        <form action="/students-marks" method="get">
            <label><strong>Выбрать семестр</strong></label>
            <select id="selectedTerm" name="studentTerms">
                <c:forEach items="${studentTerms}" var="term">
                    <option value="${term.termId}">${term.termsName}</option>
                </c:forEach>
            </select>

        </form>
        <script>
            /** function for select term from dropbox*/
            $('#selectedTerm').click(function () {
                var selectedValue = $(this).val();
                console.log("we want to select " + selectedValue + " term");
                var studentId = ${student.id};
                $.ajax({
                    type: 'GET',
                    url: '/students-marks?termId=' + selectedValue + "&studentId=" + studentId,
                    success: function (data) {
                        console.log(data);
                    }
                });
            });

            function getSelectedValue(termId,termsName) {
                event.preventDefault();
                console.log("you are trying to select term with id " + termId + " and with name " + termsName);
                var selectedValue = document.getElementById(termId).innerHTML =
                    JSON.stringify({"termId": termId, "termsName": termsName});
                console.log(selectedValue);

                $.ajax({
                    type: 'GET',
                    url: '/students-marks',
                    data: selectedValue,
                    success: function (data) {
                        alert('data: ' + data);
                    },
                    contentType: "application/json",
                    dataType: 'json'
                });
            }
        </script>
        <h4>Средний бал за семестр:</h4>
    </div>


</div>

