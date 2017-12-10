<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="title" style="font-size:120%">
    <p> Для модификации семестра отредактируйте данные и нажмите кнопку "Создать".</p>
</div>
<div class="log-form-wrapper">
    <form class="term-create-form" action="/term-modifying" method="post" id="modifyingForm">
        <input type="hidden" name="id" value="${term.id}">
        <div class="term-name-input">
            <label>Название семестра</label><input type="text" name="termsName" value="${term.name}">
        </div>
        <div class="term-length-input">
            <label>Длительность(в неделях)</label><input type="text" name="duration" value="${term.duration}">
        </div>

        <div class="term-discipline-input">
            <label>Дисциплины в семестре</label><br>
            <br>
            <c:forEach items="${disciplines}" var="discipline">
                <input id="discipline_${discipline.id}" name="disciplineName" type="text"
                       value="${discipline.name}"/>
                <button onclick="deleteDisciplineFromTerm(${discipline.id}, ${term.id});">x</button>
                <br>
            </c:forEach>
            <br>
            <select id="selectedDisc" name="disciplineList" multiple="multiple">
                <c:forEach items="${disciplineList}" var="discipline">
                    <option value="${discipline.id}">${discipline.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="term-submit-input">
            <input type="submit" value="Применить">
        </div>
        <script>
            function deleteDisciplineFromTerm(discId, termId) {
                event.preventDefault();
                console.log("you are trying to delete disc id " + discId + " from term id " + termId);
                var deleteRequest = document.getElementById("discipline_" + discId).innerHTML =
                    JSON.stringify({"disciplineId":discId,"termId":termId});
                console.log(deleteRequest);


                $.ajax({
                    type: 'POST',
                    url: '/deleteDiscFromTerm',
                    data: deleteRequest,
                    success: function (data) {
                        alert('data: ' + data);
                    },
                    contentType: "application/json",
                    dataType: 'json'
                });
            }

            /** function for select discipline from dropbox*/
            $('#selectedDisc').change(function () {
                var selectedValues = $(this).val();
                console.log("we want to add " + selectedValues);
            });

        </script>
    </form>
</div>