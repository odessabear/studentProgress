<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="termslist-content-wrapper">
    <h3>Выставить оценки следующего студента</h3>
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
                <th></th>
            </tr>
            </thead>

            <tbody id="idsAndDisciplines">

            <tr>
                <td></td>
                <td></td>
                <td class="content"></td>
                <td></td>
            </tr>

            </tbody>
        </table>
        <br>

    </div>
    <div class="select-panel">
        <form action="/mark-insertion" method="get">
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
                var studentId = ${student.id};
                $.ajax({
                    type: 'get',
                    url: '/mark-insertion?termId=' + selectedValue,
                    success: function (data) {
                        console.log(data);
                        $("#idsAndDisciplines").empty();


                        data.forEach(function (elem) {
                            console.log(elem);
                            console.log(" elem.idTermDiscipline " + elem.termDisciplineId + " elem.disciplineName " + elem.disciplineName + " elem.marksValue " + elem.marksValue);
                            var tr;
                            tr = $('<tr/>');

                            tr.append("<td>" + elem.termDisciplineId + "</td>");

                            tr.append("<td>" + elem.disciplineName + "</td>");

                            tr.append("<td contenteditable=\"true\" class=\"content\" id='marksValue'>" + elem.marksValue + "</td>");

                            tr.append("<td>" + "<button class=\"editBtn\" data-element=" + elem.termDisciplineId + ">" + "Insert" + "</button>" + "</td>");

                            $('#idsAndDisciplines').append(tr);
                        });

                        $(document).ready(function () {
                            $('.editBtn').click(function (event) {

                                alert("Do you want to change this mark");
                                var termDisciplineId = event.target.dataset.element;
                                var marksValue = $(event.target).parents('tr').find('.content').text();
                                var newValues = JSON.stringify({"studentId":studentId,
                                    "termDisciplineId": termDisciplineId,
                                    "marksValue": marksValue
                                });

                                console.log(newValues);
                                $.ajax({
                                    type: 'POST',
                                    url: '/mark-insertion?termId=' + selectedValue + "&studentId=" + studentId,
                                    data: newValues,
                                    success: function (data) {
                                        alert('data: ' + data);
                                    },
                                    contentType: "application/json",
                                    dataType: 'json'
                                });

                            });
                        });
                    }

                });

            });
        </script>

    </div>


</div>

