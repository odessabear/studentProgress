<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

<div class="termslist-content-wrapper">
    <form action="/terms-select" method="post" id="idForm">
        <label>Выбрать семестр</label>
        <select id="select-term"  onclick="refreshPage()">
            <c:forEach items="${terms}" var="term">
                <option value="${term.id}">${term.name}</option>
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
        <a class="button" href="termCreating.html">Создать семестр</a>
        <a class="button" href="termModifying.html">Модифицировать ввыбранный семестр</a>
        <a class="button" href="termCreating.html">Удалить выбранный семестр</a>
    </div>
    <script>
        // $( "#select-term" ).select(function() {
        //   var idTerm = $( "select#select-term option:checked" ).val();
        //     var input = $("<input>")
        //         .attr("type", "hidden")
        //         .attr("name", "idTerm").val(idTerm);
        //     $('#idForm').append($(input));
        //   $( "#idForm" ).submit();
        // });

        function refreshPage() {
            var x = document.getElementById("select-term").selectedIndex;
            var idTerm = $( "select#select-term option:checked" ).val();
            var input = $("<input>")
                    .attr("type", "hidden")
                    .attr("name", "idTerm").val(idTerm);
            $('#idForm').append($(input));
            $( "#idForm" ).submit();
        }
    </script>
</div>
</body>
</html>
