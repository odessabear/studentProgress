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

            <tbody id="discAndMarks">

            <tr>
                <td></td>
                <td></td>
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
                        $("#discAndMarks").empty();

                        var totalMark = 0;
                        var avg = 0;

                        data.forEach(function(elem) {
                            console.log(elem);
                            console.log("elem.disc " + elem.discipline + " elem.mark " + elem.mark);
                            var tr ;
                            tr =$('<tr/>');

                            tr.append("<td>" + elem.discipline + "</td>");
                            tr.append("<td>" + elem.mark + "</td>");
                            $('#discAndMarks').append(tr);

                            totalMark = totalMark + elem.mark;


                        });

                        avg = totalMark / data.length;
                        console.log(avg);
                    }
                });
            });


        </script>
        <h4>Средний бал за семестр:</h4>
    </div>


</div>

