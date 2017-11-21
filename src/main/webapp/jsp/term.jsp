<%--
  Created by IntelliJ IDEA.
  User: alexander.mikhailov
  Date: 06.10.2017
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="title" style="font-size:120%">
    <c:if test="${term.id == 0}"><p> Для создания семестра заполните все поля и нажмите кнопку "Создать".</p></c:if>
</div>

<div class="log-form-wrapper">

    <form class="term-create-form" method="POST" id="createTermForm" action="term">
        <div class="term-name-input">
            <label for="name">Имя семестра</label><br>
            <input id="name" name="name" type="text" value="${term.name}"/>
        </div>

        <div class="term-length-input">
            <label for="duration">Длительность в неделях</label><br>
            <input id="duration" name="durationLength" type="text" value="${term.duration}"/>
        </div>
        <div class="term-discipline-input">
            <label>Список дисцилин</label><br>
            <c:choose>
                <c:when test="${term.id == 0}">
                    <select id="selectedMap" name="disciplineList" multiple="multiple">
                        <c:forEach items="${term.disciplines}" var="discipline">
                            <option value="${discipline.id}">${discipline.name}</option>
                        </c:forEach>
                    </select>
                    <br/>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${term.disciplines}" var="discipline">
                        <input id="discipline_${discipline.id}" name="disciplineName" type="text"
                               value="${discipline.name}"/>
                        <button onclick="deleteDisciplineFromTerm(${discipline.id}, ${term.id});">x</button>
                        <br>
                    </c:forEach>
                    <br/>
                </c:otherwise>
            </c:choose>
        </div>


        <div class="term-submit-input">
            <!-- 0 term id means we're about to create a new term. and right now we have empty term stub -->
            <c:if test="${term.id == 0}"><input type='submit' value="Создать"> </c:if>
        </div>

        <script type="text/javascript">
            function deleteDisciplineFromTerm(discId, termId) {
                event.preventDefault();
                console.log( document.getElementById("discipline_" + discId).value );

            .
                log("you are trying to delete disc id " + discId + " from term id " + termId);

                //
                // $.post(
                //     "/deleteDiscFromTerm",
                //     {"discId": discId, "termId" : termId}
                // )
             /*   $(function() {
                    $('form').submit(function() {
                        $('#result').text(JSON.stringify($('form').serializeObject()));
                        return false;
                    });
                });*/
            }


            $(function () {
                $("#createTermForm").submit(function () {
                    var selectedDisciplines = $('#selectedMap').val().toString(); // comma-separated

                    $('<input>', {
                        type: 'hidden',
                        id: 'selectedDisciplines',
                        name: 'selectedDisciplines',
                        value: selectedDisciplines
                    }).appendTo('createTermForm');

                    return true;
                });
            });

        </script>
    </form>


</div>
