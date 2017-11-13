<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

<div class="termslist-content-wrapper">
    <form action="/terms-select" method="get" id="idForm">
        <label>Выбрать семестр</label>
        <select id="select-term" onchange="refreshPageAfterSelectTerm()">
            <c:forEach items="${terms}" var="term">
                <c:choose>
                    <c:when test="${ idSelectedTerm eq term.id}">
                        <option value="${term.id}" selected >${term.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${term.id}" >${term.name}</option>
                    </c:otherwise>

                </c:choose>

            </c:forEach>
        </select>
    </form>
    <h3>Длительность семестра: ${duration}</h3>

    <h4>Список дисциплин</h4>

    <ul class="discipline">
        <c:forEach items="${disciplineList}" var="disc">
            <li>${disc.name}</li>
        </c:forEach>
    </ul>


    <div class="admin-panel">
        <a class="button" href="/term-create">Создать семестр</a>
        <a class="button" href="termModifying.html">Модифицировать ввыбранный семестр</a>

        <form id="deleteTermForm" method="post" action="/term-delete">
            <input type="submit" id="deleteTermButton" value="Удалить выбранный семестр"/>
        </form>
        <%--<a class="button" href="/term-delete"></a>--%>

    </div>
    <script>

        function refreshPageAfterSelectTerm() {
            var selectedIndex = $("#select-term").prop("selectedIndex");
            var termName = $("#select-term").prop("options")[selectedIndex].text;

            var input = $("<input>")
                .attr("type", "hidden")
                .attr("name", "termName").val(termName);

            $('#idForm').append($(input));
            $("#idForm").submit();
        };

        function addTermIdToBePossiblyDeleted() {
            var idTerm = $("select#select-term option:checked").val();
            var input = $("<input>")
                .attr("type", "hidden")
                .attr("name", "idTerm").val(idTerm);
            $('#deleteTermForm').append($(input));
        }


        $(document).ready(function() {

            $('#deleteTermForm').submit(function(event) {
                if(!confirm("Вы действительно хотите удалить данный семестр?")){
                    event.preventDefault();
                }
            });

            addTermIdToBePossiblyDeleted();
        });

    </script>
</div>
</body>
</html>
